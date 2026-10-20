/**
 * 认证守卫
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { useAuthStore } from '@/stores/auth.js'
import { storeToRefs } from 'pinia'
import { ROUTE_NAME } from '@/constants/route-name.js'
import { START_LOCATION } from 'vue-router'

const AUTH_ROUTES = [ROUTE_NAME.REGISTER, ROUTE_NAME.LOGIN]

export function setupAuthGuard(router) {
  router.beforeEach((to, from) => {
    const authStore = useAuthStore()
    const { isAuthenticated } = storeToRefs(authStore)

    const isToAuthRoute = AUTH_ROUTES.includes(to.name)
    const isFromAuthRoute = AUTH_ROUTES.includes(from.name)

    // 如果没有认证并且不是前往认证页（登录/注册），则重定向登录页
    if (!isAuthenticated.value && !isToAuthRoute) {
      return { name: ROUTE_NAME.LOGIN }
    }

    // 已经认证且前往认证页（登录/注册），则退回原路由
    if (isAuthenticated.value && isToAuthRoute) {
      // 如果不是初始路由位置并且原路由不是认证页，则退回原页，否则重定向首页
      if (from !== START_LOCATION && !isFromAuthRoute) {
        return from
      }
      return { name: ROUTE_NAME.INDEX }
    }
  })
}
