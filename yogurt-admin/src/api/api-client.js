/**
 * API 客户端，配置 axios
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import axios from 'axios'
import { useAuthStore } from '@/stores/auth.js'
import { router } from '@/router/index.js'
import { ROUTE_NAME } from '@/constants/route-name.js'
import { toast } from 'vue-sonner'

// 认证端点
const AUTH_ENDPOINTS = ['/auth/login', '/auth/register']

// 判断 url 是否是认证端点
function isAuthEndpoint(url) {
  if (!url) return false

  let path = url.split('?')[0].split('#')[0] // 去除查询参数和哈希
  while (path.endsWith('/')) path = path.slice(0, -1) // 去除尾部 ‘/’ 斜杠
  return AUTH_ENDPOINTS.some((endpoint) => path.endsWith(endpoint))
}

export const apiClient = axios.create({
  baseURL: import.meta.env.VITE_SERVER_API_URL,
  timeout: Number(import.meta.env.VITE_SERVER_API_TIMEOUT),
})

// 请求拦截器
apiClient.interceptors.request.use(
  (config) => {
    const authStore = useAuthStore()
    // 添加 Authorization 头，携带 token
    if (authStore.isAuthenticated) {
      config.headers.Authorization = `Bearer ${authStore.token}`
    }
    return config
  },
  (error) => Promise.reject(error),
)

// 响应拦截器
apiClient.interceptors.response.use(
  (response) => response,
  (error) => {
    // 处理 Token 过期：
    // 只处理非认证接口的 401，认证接口的 401 是业务错误（密码错误等），由登录页自己处理
    if (error.response?.status === 401 && !isAuthEndpoint(error.config?.url)) {
      const authStore = useAuthStore()
      // 只有首个已认证状态的 401 能抢到处理权，返回 true
      // 后来者（状态已过期）、迟到者（finally 已更新为未认证）、未登录用户均返回 false
      if (!authStore.tryMarkExpired()) return Promise.reject(error)

      // 清理 Token
      authStore.clearToken()

      // 保存当前路由路径
      const redirect = router.currentRoute.value.fullPath

      // toast 提示，接口如果有错误信息，则采用接口，否则使用默认值
      toast.warning(error.response?.data?.message || '登录状态已失效，请重新登录')

      // 携带当前路由路径重定向至登录页，登录成功后，登录功能负责跳转到原路由
      router
        .replace({
          name: ROUTE_NAME.LOGIN,
          query: { redirect },
        })
        .finally(() => {
          // 重定向登录页后，清除已过期状态，转为未认证状态
          // 登录成功会执行 authStore.setToken()：存入 Token、更新状态为已认证
          authStore.resetExpired()
        })
    }

    return Promise.reject(error)
  },
)
