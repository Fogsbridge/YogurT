/**
 * 路由配置
 *
 * @author fogsbridge
 * @since 1.0.0
 */
export const ROUTE = {
  REGISTER: { name: 'register', path: '/register' },
}

export const routes = [
  {
    path: ROUTE.REGISTER.path,
    name: ROUTE.REGISTER.name,
    component: () => import('@/views/register/RegisterView.vue'),
  },
]
