
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
 * 业务人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yewurenyuan")
public class YewurenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(YewurenyuanController.class);

    private static final String TABLE_NAME = "yewurenyuan";

    @Autowired
    private YewurenyuanService yewurenyuanService;


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
    private QianyiYuyueService qianyiYuyueService;//迁移申请
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
        PageUtils page = yewurenyuanService.queryPage(params);

        //字典表数据转换
        List<YewurenyuanView> list =(List<YewurenyuanView>)page.getList();
        for(YewurenyuanView c:list){
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
        YewurenyuanEntity yewurenyuan = yewurenyuanService.selectById(id);
        if(yewurenyuan !=null){
            //entity转view
            YewurenyuanView view = new YewurenyuanView();
            BeanUtils.copyProperties( yewurenyuan , view );//把实体数据重构到view中
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
    public R save(@RequestBody YewurenyuanEntity yewurenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yewurenyuan:{}",this.getClass().getName(),yewurenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YewurenyuanEntity> queryWrapper = new EntityWrapper<YewurenyuanEntity>()
            .eq("username", yewurenyuan.getUsername())
            .or()
            .eq("yewurenyuan_phone", yewurenyuan.getYewurenyuanPhone())
            .or()
            .eq("yewurenyuan_id_number", yewurenyuan.getYewurenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YewurenyuanEntity yewurenyuanEntity = yewurenyuanService.selectOne(queryWrapper);
        if(yewurenyuanEntity==null){
            yewurenyuan.setCreateTime(new Date());
            yewurenyuan.setPassword("123456");
            yewurenyuanService.insert(yewurenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者业务人员手机号或者业务人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YewurenyuanEntity yewurenyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yewurenyuan:{}",this.getClass().getName(),yewurenyuan.toString());
        YewurenyuanEntity oldYewurenyuanEntity = yewurenyuanService.selectById(yewurenyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(yewurenyuan.getYewurenyuanPhoto()) || "null".equals(yewurenyuan.getYewurenyuanPhoto())){
                yewurenyuan.setYewurenyuanPhoto(null);
        }

            yewurenyuanService.updateById(yewurenyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YewurenyuanEntity> oldYewurenyuanList =yewurenyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yewurenyuanService.deleteBatchIds(Arrays.asList(ids));

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
            List<YewurenyuanEntity> yewurenyuanList = new ArrayList<>();//上传的东西
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
                            YewurenyuanEntity yewurenyuanEntity = new YewurenyuanEntity();
//                            yewurenyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //yewurenyuanEntity.setPassword("123456");//密码
//                            yewurenyuanEntity.setYewurenyuanName(data.get(0));                    //业务人员姓名 要改的
//                            yewurenyuanEntity.setYewurenyuanPhone(data.get(0));                    //业务人员手机号 要改的
//                            yewurenyuanEntity.setYewurenyuanIdNumber(data.get(0));                    //业务人员身份证号 要改的
//                            yewurenyuanEntity.setYewurenyuanPhoto("");//详情和图片
//                            yewurenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            yewurenyuanEntity.setNewMoney(data.get(0));                    //余额 要改的
//                            yewurenyuanEntity.setYewurenyuanEmail(data.get(0));                    //业务人员邮箱 要改的
//                            yewurenyuanEntity.setCreateTime(date);//时间
                            yewurenyuanList.add(yewurenyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //业务人员手机号
                                if(seachFields.containsKey("yewurenyuanPhone")){
                                    List<String> yewurenyuanPhone = seachFields.get("yewurenyuanPhone");
                                    yewurenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> yewurenyuanPhone = new ArrayList<>();
                                    yewurenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("yewurenyuanPhone",yewurenyuanPhone);
                                }
                                //业务人员身份证号
                                if(seachFields.containsKey("yewurenyuanIdNumber")){
                                    List<String> yewurenyuanIdNumber = seachFields.get("yewurenyuanIdNumber");
                                    yewurenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yewurenyuanIdNumber = new ArrayList<>();
                                    yewurenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("yewurenyuanIdNumber",yewurenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<YewurenyuanEntity> yewurenyuanEntities_username = yewurenyuanService.selectList(new EntityWrapper<YewurenyuanEntity>().in("username", seachFields.get("username")));
                        if(yewurenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YewurenyuanEntity s:yewurenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //业务人员手机号
                        List<YewurenyuanEntity> yewurenyuanEntities_yewurenyuanPhone = yewurenyuanService.selectList(new EntityWrapper<YewurenyuanEntity>().in("yewurenyuan_phone", seachFields.get("yewurenyuanPhone")));
                        if(yewurenyuanEntities_yewurenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YewurenyuanEntity s:yewurenyuanEntities_yewurenyuanPhone){
                                repeatFields.add(s.getYewurenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [业务人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //业务人员身份证号
                        List<YewurenyuanEntity> yewurenyuanEntities_yewurenyuanIdNumber = yewurenyuanService.selectList(new EntityWrapper<YewurenyuanEntity>().in("yewurenyuan_id_number", seachFields.get("yewurenyuanIdNumber")));
                        if(yewurenyuanEntities_yewurenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YewurenyuanEntity s:yewurenyuanEntities_yewurenyuanIdNumber){
                                repeatFields.add(s.getYewurenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [业务人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yewurenyuanService.insertBatch(yewurenyuanList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        YewurenyuanEntity yewurenyuan = yewurenyuanService.selectOne(new EntityWrapper<YewurenyuanEntity>().eq("username", username));
        if(yewurenyuan==null || !yewurenyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(yewurenyuan.getId(),username, "yewurenyuan", "业务人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","业务人员");
        r.put("username",yewurenyuan.getYewurenyuanName());
        r.put("tableName","yewurenyuan");
        r.put("userId",yewurenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody YewurenyuanEntity yewurenyuan, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<YewurenyuanEntity> queryWrapper = new EntityWrapper<YewurenyuanEntity>()
            .eq("username", yewurenyuan.getUsername())
            .or()
            .eq("yewurenyuan_phone", yewurenyuan.getYewurenyuanPhone())
            .or()
            .eq("yewurenyuan_id_number", yewurenyuan.getYewurenyuanIdNumber())
            ;
        YewurenyuanEntity yewurenyuanEntity = yewurenyuanService.selectOne(queryWrapper);
        if(yewurenyuanEntity != null)
            return R.error("账户或者业务人员手机号或者业务人员身份证号已经被使用");
        yewurenyuan.setNewMoney(0.0);
        yewurenyuan.setCreateTime(new Date());
        yewurenyuanService.insert(yewurenyuan);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        YewurenyuanEntity yewurenyuan = yewurenyuanService.selectById(id);
        yewurenyuan.setPassword("123456");
        yewurenyuanService.updateById(yewurenyuan);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        YewurenyuanEntity yewurenyuan = yewurenyuanService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(yewurenyuan.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(yewurenyuan.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        yewurenyuan.setPassword(newPassword);
		yewurenyuanService.updateById(yewurenyuan);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        YewurenyuanEntity yewurenyuan = yewurenyuanService.selectOne(new EntityWrapper<YewurenyuanEntity>().eq("username", username));
        if(yewurenyuan!=null){
            yewurenyuan.setPassword("123456");
            yewurenyuanService.updateById(yewurenyuan);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrYewurenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        YewurenyuanEntity yewurenyuan = yewurenyuanService.selectById(id);
        if(yewurenyuan !=null){
            //entity转view
            YewurenyuanView view = new YewurenyuanView();
            BeanUtils.copyProperties( yewurenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = yewurenyuanService.queryPage(params);

        //字典表数据转换
        List<YewurenyuanView> list =(List<YewurenyuanView>)page.getList();
        for(YewurenyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YewurenyuanEntity yewurenyuan = yewurenyuanService.selectById(id);
            if(yewurenyuan !=null){


                //entity转view
                YewurenyuanView view = new YewurenyuanView();
                BeanUtils.copyProperties( yewurenyuan , view );//把实体数据重构到view中

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
    public R add(@RequestBody YewurenyuanEntity yewurenyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yewurenyuan:{}",this.getClass().getName(),yewurenyuan.toString());
        Wrapper<YewurenyuanEntity> queryWrapper = new EntityWrapper<YewurenyuanEntity>()
            .eq("username", yewurenyuan.getUsername())
            .or()
            .eq("yewurenyuan_phone", yewurenyuan.getYewurenyuanPhone())
            .or()
            .eq("yewurenyuan_id_number", yewurenyuan.getYewurenyuanIdNumber())
//            .notIn("yewurenyuan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YewurenyuanEntity yewurenyuanEntity = yewurenyuanService.selectOne(queryWrapper);
        if(yewurenyuanEntity==null){
            yewurenyuan.setCreateTime(new Date());
            yewurenyuan.setPassword("123456");
        yewurenyuanService.insert(yewurenyuan);

            return R.ok();
        }else {
            return R.error(511,"账户或者业务人员手机号或者业务人员身份证号已经被使用");
        }
    }

}

