import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    component: () => import('@/views/Layout/Layout.vue'),
    children: [
      {
        path: '',
        components: {
          default: () => import('@/views/Home/Home.vue'),
          banner: () => import('@/views/Home/HomeBanner.vue'),
          sidebar: () => import('@/components/Sidebar/Sidebar.vue')
        },
        meta: { title: '首页'}
      },
      {
        path: '/archives',
        components: {
          default: () => import('@/views/Archive/Archive.vue'),
          banner: () => import('@/views/Archive/ArchiveBanner.vue'),
          sidebar: () => import('@/components/Sidebar/Sidebar.vue')
        },
        meta: { title: '归档'}
      },
      {
        path: '/categories',
        component: () => import('@/views/Category/Category.vue'),
        meta: { title: '分类'}
      },
      {
        path: '/tags',
        component: () => import('@/views/Tag/Tag.vue'),
        meta: { title: '标签'}
      },
      {
        path: '/about',
        components: {
          default: () => import('@/views/About/About.vue'),
          banner: () => import('@/views/About/AboutBanner.vue')
        },
        meta: { title: '关于我'}
      },
      {
        path: ':pathMatch(.*)*',
        component: () => import('@/views/Errors/NotFound.vue'),
        meta: { title: '页面迷路了'}
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes: routes
})

router.beforeEach((to, from, next) => {
  document.title = `${to.meta.title} | 云桥雾的Blog`
  next()
})

export default router