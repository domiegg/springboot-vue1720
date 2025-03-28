
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 迁移申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qianyiYuyue")
public class QianyiYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(QianyiYuyueController.class);

    private static final String TABLE_NAME = "qianyiYuyue";

    @Autowired
    private QianyiYuyueService qianyiYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BaoxiuService baoxiuService;//报修
    @Autowired
    private BaoxiuCommentbackService baoxiuCommentbackService;//报修评价
    @Autowired
    private BaoxiuFenpeiService baoxiuFenpeiService;//报修分配
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private FeiyongService feiyongService;//宽带缴费
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private KuandaiService kuandaiService;//宽带
    @Autowired
    private KuandaiCollectionService kuandaiCollectionService;//宽带收藏
    @Autowired
    private KuandaiLiuyanService kuandaiLiuyanService;//宽带留言
    @Autowired
    private KuandaiOrderService kuandaiOrderService;//宽带开户
    @Autowired
    private KuandaiYuyueService kuandaiYuyueService;//宽带预约安装
    @Autowired
    private YewurenyuanService yewurenyuanService;//业务人员
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("业务人员".equals(role))
            params.put("yewurenyuanId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = qianyiYuyueService.queryPage(params);

        //字典表数据转换
        List<QianyiYuyueView> list =(List<QianyiYuyueView>)page.getList();
        for(QianyiYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QianyiYuyueEntity qianyiYuyue = qianyiYuyueService.selectById(id);
        if(qianyiYuyue !=null){
            //entity转view
            QianyiYuyueView view = new QianyiYuyueView();
            BeanUtils.copyProperties( qianyiYuyue , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(qianyiYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody QianyiYuyueEntity qianyiYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qianyiYuyue:{}",this.getClass().getName(),qianyiYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            qianyiYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<QianyiYuyueEntity> queryWrapper = new EntityWrapper<QianyiYuyueEntity>()
            .eq("yonghu_id", qianyiYuyue.getYonghuId())
            .in("qianyi_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QianyiYuyueEntity qianyiYuyueEntity = qianyiYuyueService.selectOne(queryWrapper);
        if(qianyiYuyueEntity==null){
            qianyiYuyue.setQianyiYuyueYesnoTypes(1);
            qianyiYuyue.setInsertTime(new Date());
            qianyiYuyue.setCreateTime(new Date());
            qianyiYuyueService.insert(qianyiYuyue);
            return R.ok();
        }else {
            if(qianyiYuyueEntity.getQianyiYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(qianyiYuyueEntity.getQianyiYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QianyiYuyueEntity qianyiYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,qianyiYuyue:{}",this.getClass().getName(),qianyiYuyue.toString());
        QianyiYuyueEntity oldQianyiYuyueEntity = qianyiYuyueService.selectById(qianyiYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            qianyiYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            qianyiYuyueService.updateById(qianyiYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody QianyiYuyueEntity qianyiYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,qianyiYuyueEntity:{}",this.getClass().getName(),qianyiYuyueEntity.toString());

        QianyiYuyueEntity oldQianyiYuyue = qianyiYuyueService.selectById(qianyiYuyueEntity.getId());//查询原先数据

//        if(qianyiYuyueEntity.getQianyiYuyueYesnoTypes() == 2){//通过
//            qianyiYuyueEntity.setQianyiYuyueTypes();
//        }else if(qianyiYuyueEntity.getQianyiYuyueYesnoTypes() == 3){//拒绝
//            qianyiYuyueEntity.setQianyiYuyueTypes();
//        }
        qianyiYuyueEntity.setQianyiYuyueShenheTime(new Date());//审核时间
        qianyiYuyueService.updateById(qianyiYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<QianyiYuyueEntity> oldQianyiYuyueList =qianyiYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        qianyiYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<QianyiYuyueEntity> qianyiYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            QianyiYuyueEntity qianyiYuyueEntity = new QianyiYuyueEntity();
//                            qianyiYuyueEntity.setQianyiYuyueUuidNumber(data.get(0));                    //报名唯一编号 要改的
//                            qianyiYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            qianyiYuyueEntity.setQianyiYuyueText(data.get(0));                    //理由 要改的
//                            qianyiYuyueEntity.setQianyiYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            qianyiYuyueEntity.setQianyiYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            qianyiYuyueEntity.setQianyiYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            qianyiYuyueEntity.setInsertTime(date);//时间
//                            qianyiYuyueEntity.setCreateTime(date);//时间
                            qianyiYuyueList.add(qianyiYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //报名唯一编号
                                if(seachFields.containsKey("qianyiYuyueUuidNumber")){
                                    List<String> qianyiYuyueUuidNumber = seachFields.get("qianyiYuyueUuidNumber");
                                    qianyiYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> qianyiYuyueUuidNumber = new ArrayList<>();
                                    qianyiYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("qianyiYuyueUuidNumber",qianyiYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名唯一编号
                        List<QianyiYuyueEntity> qianyiYuyueEntities_qianyiYuyueUuidNumber = qianyiYuyueService.selectList(new EntityWrapper<QianyiYuyueEntity>().in("qianyi_yuyue_uuid_number", seachFields.get("qianyiYuyueUuidNumber")));
                        if(qianyiYuyueEntities_qianyiYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(QianyiYuyueEntity s:qianyiYuyueEntities_qianyiYuyueUuidNumber){
                                repeatFields.add(s.getQianyiYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        qianyiYuyueService.insertBatch(qianyiYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = qianyiYuyueService.queryPage(params);

        //字典表数据转换
        List<QianyiYuyueView> list =(List<QianyiYuyueView>)page.getList();
        for(QianyiYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QianyiYuyueEntity qianyiYuyue = qianyiYuyueService.selectById(id);
            if(qianyiYuyue !=null){


                //entity转view
                QianyiYuyueView view = new QianyiYuyueView();
                BeanUtils.copyProperties( qianyiYuyue , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(qianyiYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody QianyiYuyueEntity qianyiYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,qianyiYuyue:{}",this.getClass().getName(),qianyiYuyue.toString());
        Wrapper<QianyiYuyueEntity> queryWrapper = new EntityWrapper<QianyiYuyueEntity>()
            .eq("qianyi_yuyue_uuid_number", qianyiYuyue.getQianyiYuyueUuidNumber())
            .eq("yonghu_id", qianyiYuyue.getYonghuId())
            .eq("qianyi_yuyue_text", qianyiYuyue.getQianyiYuyueText())
            .in("qianyi_yuyue_yesno_types", new Integer[]{1,2})
            .eq("qianyi_yuyue_yesno_text", qianyiYuyue.getQianyiYuyueYesnoText())
//            .notIn("qianyi_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QianyiYuyueEntity qianyiYuyueEntity = qianyiYuyueService.selectOne(queryWrapper);
        if(qianyiYuyueEntity==null){
            qianyiYuyue.setQianyiYuyueYesnoTypes(1);
            qianyiYuyue.setInsertTime(new Date());
            qianyiYuyue.setCreateTime(new Date());
        qianyiYuyueService.insert(qianyiYuyue);

            return R.ok();
        }else {
            if(qianyiYuyueEntity.getQianyiYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(qianyiYuyueEntity.getQianyiYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

