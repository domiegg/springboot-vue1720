import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import baoxiu from '@/views/modules/baoxiu/list'
    import baoxiuCommentback from '@/views/modules/baoxiuCommentback/list'
    import baoxiuFenpei from '@/views/modules/baoxiuFenpei/list'
    import dictionary from '@/views/modules/dictionary/list'
    import feiyong from '@/views/modules/feiyong/list'
    import forum from '@/views/modules/forum/list'
    import gonggao from '@/views/modules/gonggao/list'
    import kuandai from '@/views/modules/kuandai/list'
    import kuandaiCollection from '@/views/modules/kuandaiCollection/list'
    import kuandaiLiuyan from '@/views/modules/kuandaiLiuyan/list'
    import kuandaiOrder from '@/views/modules/kuandaiOrder/list'
    import kuandaiYuyue from '@/views/modules/kuandaiYuyue/list'
    import qianyiYuyue from '@/views/modules/qianyiYuyue/list'
    import yewurenyuan from '@/views/modules/yewurenyuan/list'
    import yonghu from '@/views/modules/yonghu/list'
    import config from '@/views/modules/config/list'
    import dictionaryBaoxiu from '@/views/modules/dictionaryBaoxiu/list'
    import dictionaryBaoxiuZhuangtai from '@/views/modules/dictionaryBaoxiuZhuangtai/list'
    import dictionaryFeiyong from '@/views/modules/dictionaryFeiyong/list'
    import dictionaryFeiyongZhuangtai from '@/views/modules/dictionaryFeiyongZhuangtai/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryKuandai from '@/views/modules/dictionaryKuandai/list'
    import dictionaryKuandaiCollection from '@/views/modules/dictionaryKuandaiCollection/list'
    import dictionaryKuandaiOrder from '@/views/modules/dictionaryKuandaiOrder/list'
    import dictionaryKuandaiYuyueYesno from '@/views/modules/dictionaryKuandaiYuyueYesno/list'
    import dictionaryQianyiYuyueYesno from '@/views/modules/dictionaryQianyiYuyueYesno/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import fenpei from '@/views/modules/baoxiuFenpei/add-or-update'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryBaoxiu',
        name: '报修类型',
        component: dictionaryBaoxiu
    }
    ,{
        path: '/dictionaryBaoxiuZhuangtai',
        name: '报修状态',
        component: dictionaryBaoxiuZhuangtai
    }
    ,{
        path: '/dictionaryFeiyong',
        name: '缴费类型',
        component: dictionaryFeiyong
    }
    ,{
        path: '/dictionaryFeiyongZhuangtai',
        name: '缴费状态',
        component: dictionaryFeiyongZhuangtai
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryKuandai',
        name: '宽带类型',
        component: dictionaryKuandai
    }
    ,{
        path: '/dictionaryKuandaiCollection',
        name: '收藏表类型',
        component: dictionaryKuandaiCollection
    }
    ,{
        path: '/dictionaryKuandaiOrder',
        name: '订单类型',
        component: dictionaryKuandaiOrder
    }
    ,{
        path: '/dictionaryKuandaiYuyueYesno',
        name: '报名状态',
        component: dictionaryKuandaiYuyueYesno
    }
    ,{
        path: '/dictionaryQianyiYuyueYesno',
        name: '报名状态',
        component: dictionaryQianyiYuyueYesno
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/baoxiu',
        name: '报修',
        component: baoxiu
      }

        ,{
            path: '/fenpei',
            name: '报修分配',
            component: fenpei
        }
    ,{
        path: '/baoxiuCommentback',
        name: '报修评价',
        component: baoxiuCommentback
      }
    ,{
        path: '/baoxiuFenpei',
        name: '报修分配',
        component: baoxiuFenpei
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/feiyong',
        name: '宽带缴费',
        component: feiyong
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/kuandai',
        name: '宽带',
        component: kuandai
      }
    ,{
        path: '/kuandaiCollection',
        name: '宽带收藏',
        component: kuandaiCollection
      }
    ,{
        path: '/kuandaiLiuyan',
        name: '宽带留言',
        component: kuandaiLiuyan
      }
    ,{
        path: '/kuandaiOrder',
        name: '宽带开户',
        component: kuandaiOrder
      }
    ,{
        path: '/kuandaiYuyue',
        name: '宽带预约安装',
        component: kuandaiYuyue
      }
    ,{
        path: '/qianyiYuyue',
        name: '迁移申请',
        component: qianyiYuyue
      }
    ,{
        path: '/yewurenyuan',
        name: '业务人员',
        component: yewurenyuan
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
