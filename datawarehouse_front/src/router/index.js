import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/pages/HelloWorld'
import Test from '@/pages/Test'
import Actor from '@/pages/Actor'
import ActorandDirector from '@/pages/ActorandDirector'
import Compose from '@/pages/Compose'
import Director from '@/pages/Director'
import Moviename from '@/pages/Moviename'
import Movietype from '@/pages/Movietype'
import Time from '@/pages/Time'
import Userreview from '@/pages/Userreview'
import Compare from '@/pages/Compare'
import Popular from '@/pages/Popular'
import Source from '@/pages/Source'
Vue.use(Router)

export default new Router({
  routes: [{
      path: '/',
      redirect: '/Actor'
    },
    {
      path: '/test',
      name: 'Test',
      component: Test
    },
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld,
      children: [{
          path: '/Actor',
          component: Actor,
          meta: {
            name: '演员查询'
          }
        },
        {
          path: '/ActorandDirector',
          component: ActorandDirector,
          meta: {
            name: '导演演员查询'
          }
        },
        {
          path: '/Compose',
          component: Compose,
          meta: {
            name: '组合查询'
          }
        },
        {
          path: '/Director',
          component: Director,
          meta: {
            name: '电影导演查询'
          }
        },
        {
          path: '/Moviename',
          component: Moviename,
          meta: {
            name: '电影名称查询'
          }
        },
        {
          path: '/Time',
          component: Time,
          meta: {
            name: '时间查询'
          }
        },
        {
          path: '/Movietype',
          component: Movietype,
          meta: {
            name: '电影类型查询'
          }
        },
        {
          path: '/Userreview',
          component: Userreview,
          meta: {
            name: '用户评论查询'
          }
        },
        {
          path: "/Compare",
          component: Compare,
          meta: {
            name: "不同存储模型查询效率比较"
          }
        },
        {
          path: "/Popular",
          component: Popular,
          meta: {
            name: '欢迎度查询'
          }
        },
        {
          path: "/Source",
          component: Source,
          meta: {
            name: '溯源查询'
          }
        },
      ],
      props: true
    }
  ]
})
