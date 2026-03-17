import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'Layout',
    component: () => import('@/components/Layout/Layout.vue'),
    children: [
      {
        path: '',
        name: 'Home',
        meta: { title: '首页' },
        component: () => import('@/views/Home/Home.vue')
      },
      {
        path: '/archives',
        name: 'Archives',
        meta: { title: '归档' },
        component: () => import('@/views/Archives/Archives.vue')
      },
      {
        path: '/categories',
        name: 'Categories',
        meta: { title: '分类' },
        component: () => import('@/views/Categories/Categories.vue')
      },
      {
        path: '/categories/:categoryName',
        name: 'CategoryDetail',
        meta: { title: '分类' },
        props: true,
        component: () => import('@/views/Categories/CategoryDetail.vue')
      },
      {
        path: '/tags',
        name: 'Tags',
        meta: { title: '标签' },
        component: () => import('@/views/Tags/Tags.vue')
      },
      {
        path: '/tags/:tagName',
        name: 'TagDetail',
        meta: { title: '标签' },
        props: true,
        component: () => import('@/views/Tags/TagDetail.vue')
      },
      {
        path: '/moments',
        name: 'Moments',
        meta: { title: '瞬间' },
        component: () => import('@/views/Moments/Moments.vue')
      },
      // {
      //   path: '/links',
      //   name: 'Links',
      //   meta: { title: '友链' },
      //   component: () => import('@/views/Links/Links.vue')
      // },
      // {
      //   path: '/messages',
      //   name: 'Messages',
      //   meta: { title: '留言' },
      //   component: () => import('@/views/Messages/Messages.vue')
      // },
      {
        path: '/about',
        name: 'About',
        meta: { title: '关于' },
        component: () => import('@/views/About/About.vue')
      },
      {
        path: ':pathMatch(.*)*',
        name: 'NotFound',
        meta: { title: '页面未找到' },
        component: () => import('@/views/Errors/NotFound.vue')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes: routes,
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    }

    return { top: 0, behavior: 'smooth' }
  }
})

router.beforeEach((to, from, next) => {
  document.title = to.meta.title ? `${to.meta.title} | 云桥雾的Blog` : '云桥雾的Blog'
  next()
})

export default router