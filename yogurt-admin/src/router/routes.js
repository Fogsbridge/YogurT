/**
 * 路由配置
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { ROUTE_NAME } from '@/constants/route-name.js'

export const routes = [
  {
    path: '/',
    name: ROUTE_NAME.INDEX,
    component: () => import('@/layouts/DefaultLayout.vue'),
  },
  {
    path: '/register',
    name: ROUTE_NAME.REGISTER,
    component: () => import('@/views/register/RegisterView.vue'),
  },
]
