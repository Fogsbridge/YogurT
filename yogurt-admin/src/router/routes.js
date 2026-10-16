/**
 * 路由配置
 *
 * @author fogsbridge
 * @since 1.0.0
 */
export const ROUTE = {
  REGISTER: { name: 'register', path: '/register' },
  INDEX: { name: 'index', path: '/' },
}

export const routes = [
  {
    path: ROUTE.INDEX.path,
    name: ROUTE.INDEX.name,
    component: () => import('@/layouts/DefaultLayout.vue'),
  },
  {
    path: ROUTE.REGISTER.path,
    name: ROUTE.REGISTER.name,
    component: () => import('@/views/register/RegisterView.vue'),
  },
]
