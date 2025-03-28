
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
 * 宽带开户
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kuandaiOrder")
public class KuandaiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(KuandaiOrderController.class);

    private static final String TABLE_NAME = "kuandaiOrder";

    @Autowired
    private KuandaiOrderService kuandaiOrderService;


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
    private KuandaiYuyueService kuandaiYuyueService;//宽带预约安装
    @Autowired
    private QianyiYuyueService qianyiYuyueService;//迁移申请
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
        PageUtils page = kuandaiOrderService.queryPage(params);

        //字典表数据转换
        List<KuandaiOrderView> list =(List<KuandaiOrderView>)page.getList();
        for(KuandaiOrderView c:list){
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
        KuandaiOrderEntity kuandaiOrder = kuandaiOrderService.selectById(id);
        if(kuandaiOrder !=null){
            //entity转view
            KuandaiOrderView view = new KuandaiOrderView();
            BeanUtils.copyProperties( kuandaiOrder , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(kuandaiOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 宽带
            //级联表
            KuandaiEntity kuandai = kuandaiService.selectById(kuandaiOrder.getKuandaiId());
            if(kuandai != null){
            BeanUtils.copyProperties( kuandai , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setKuandaiId(kuandai.getId());
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
    public R save(@RequestBody KuandaiOrderEntity kuandaiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kuandaiOrder:{}",this.getClass().getName(),kuandaiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            kuandaiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        kuandaiOrder.setCreateTime(new Date());
        kuandaiOrder.setInsertTime(new Date());
        kuandaiOrderService.insert(kuandaiOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KuandaiOrderEntity kuandaiOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,kuandaiOrder:{}",this.getClass().getName(),kuandaiOrder.toString());
        KuandaiOrderEntity oldKuandaiOrderEntity = kuandaiOrderService.selectById(kuandaiOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            kuandaiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            kuandaiOrderService.updateById(kuandaiOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<KuandaiOrderEntity> oldKuandaiOrderList =kuandaiOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        kuandaiOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<KuandaiOrderEntity> kuandaiOrderList = new ArrayList<>();//上传的东西
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
                            KuandaiOrderEntity kuandaiOrderEntity = new KuandaiOrderEntity();
//                            kuandaiOrderEntity.setKuandaiOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            kuandaiOrderEntity.setKuandaiId(Integer.valueOf(data.get(0)));   //宽带 要改的
//                            kuandaiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            kuandaiOrderEntity.setKuandaiOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            kuandaiOrderEntity.setInsertTime(date);//时间
//                            kuandaiOrderEntity.setCreateTime(date);//时间
                            kuandaiOrderList.add(kuandaiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("kuandaiOrderUuidNumber")){
                                    List<String> kuandaiOrderUuidNumber = seachFields.get("kuandaiOrderUuidNumber");
                                    kuandaiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> kuandaiOrderUuidNumber = new ArrayList<>();
                                    kuandaiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("kuandaiOrderUuidNumber",kuandaiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<KuandaiOrderEntity> kuandaiOrderEntities_kuandaiOrderUuidNumber = kuandaiOrderService.selectList(new EntityWrapper<KuandaiOrderEntity>().in("kuandai_order_uuid_number", seachFields.get("kuandaiOrderUuidNumber")));
                        if(kuandaiOrderEntities_kuandaiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(KuandaiOrderEntity s:kuandaiOrderEntities_kuandaiOrderUuidNumber){
                                repeatFields.add(s.getKuandaiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        kuandaiOrderService.insertBatch(kuandaiOrderList);
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
        PageUtils page = kuandaiOrderService.queryPage(params);

        //字典表数据转换
        List<KuandaiOrderView> list =(List<KuandaiOrderView>)page.getList();
        for(KuandaiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KuandaiOrderEntity kuandaiOrder = kuandaiOrderService.selectById(id);
            if(kuandaiOrder !=null){


                //entity转view
                KuandaiOrderView view = new KuandaiOrderView();
                BeanUtils.copyProperties( kuandaiOrder , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(kuandaiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    KuandaiEntity kuandai = kuandaiService.selectById(kuandaiOrder.getKuandaiId());
                if(kuandai != null){
                    BeanUtils.copyProperties( kuandai , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKuandaiId(kuandai.getId());
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
    public R add(@RequestBody KuandaiOrderEntity kuandaiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,kuandaiOrder:{}",this.getClass().getName(),kuandaiOrder.toString());
            KuandaiEntity kuandaiEntity = kuandaiService.selectById(kuandaiOrder.getKuandaiId());
            if(kuandaiEntity == null){
                return R.error(511,"查不到该宽带");
            }
            // Double kuandaiNewMoney = kuandaiEntity.getKuandaiNewMoney();

            if(false){
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            kuandaiOrder.setKuandaiOrderTypes(101); //设置订单状态为已开户
            kuandaiOrder.setYonghuId(userId); //设置订单支付人id
            kuandaiOrder.setKuandaiOrderUuidNumber(String.valueOf(new Date().getTime()));
            kuandaiOrder.setInsertTime(new Date());
            kuandaiOrder.setCreateTime(new Date());
                kuandaiOrderService.insert(kuandaiOrder);//新增订单
            //更新第一注册表
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


    /**
    * 取消开户
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            KuandaiOrderEntity kuandaiOrder = kuandaiOrderService.selectById(id);//当前表service
            Integer kuandaiId = kuandaiOrder.getKuandaiId();
            if(kuandaiId == null)
                return R.error(511,"查不到该宽带");
            KuandaiEntity kuandaiEntity = kuandaiService.selectById(kuandaiId);
            if(kuandaiEntity == null)
                return R.error(511,"查不到该宽带");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

                //计算金额
                //计算所获得积分
                Double buyJifen = 0.0;





            kuandaiOrder.setKuandaiOrderTypes(102);//设置订单状态为已取消开户
            kuandaiOrderService.updateById(kuandaiOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            kuandaiService.updateById(kuandaiEntity);//更新订单中宽带的信息

            return R.ok();
    }

}

