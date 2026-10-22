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
import { ApiResultCode } from '@/constants/api-result-code.js'

export const apiClient = axios.create({
  baseURL: import.meta.env.VITE_SERVER_API_URL,
  timeout: Number(import.meta.env.VITE_SERVER_API_TIMEOUT),
})

// 请求拦截器
apiClient.interceptors.request.use(
  (config) => {
    const authStore = useAuthStore()
    if (authStore.token) {
      config.headers.Authorization = `Bearer ${authStore.token}`
    }
    return config
  },
  (error) => Promise.reject(error),
)

// 响应拦截器
let isRedirecting = false
apiClient.interceptors.response.use(
  (response) => response,
  (error) => {
    // 拦截 401 错误
    if (error.response?.status === 401) {
      // Api 业务错误码
      const resultCode = error.response.data?.code

      // 此处处理非登录失败的其他 401 错误，如 token 过期、token 无效等
      // 登录失败 LOGIN_FAILED（用户名或密码错误）理应只有登录接口返回，
      // 如果登录失败，此处不做处理，由登录页处理后续逻辑
      if (resultCode !== ApiResultCode.LOGIN_FAILED.code && !isRedirecting) {
        // 多个请求（如首次页面加载时）在途时，可能同时返回 401，避免重复导航
        // 此标志保证并发时，只处理首次 401
        isRedirecting = true

        // 清理 token
        const authStore = useAuthStore()
        authStore.clearToken()

        // 保存当前路由路径
        const redirect = router.currentRoute.value.fullPath

        // 携带当前路由路径重定向至登录页，登录成功后，登录功能负责跳转到原路由
        router
          .replace({
            name: ROUTE_NAME.LOGIN,
            query: { redirect },
          })
          .finally(() => {
            isRedirecting = false
          })
      }
    }
    return Promise.reject(error)
  },
)
