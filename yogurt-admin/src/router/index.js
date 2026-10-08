import { createRouter, createWebHistory } from 'vue-router'
import { ROUTE_NAMES } from '@/constants/routes.js'

const routes = [
  {
    path: '/register',
    name: ROUTE_NAMES.REGISTER,
    component: () => import('@/views/register/RegisterPage.vue'),
  },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: routes,
})

export default router
