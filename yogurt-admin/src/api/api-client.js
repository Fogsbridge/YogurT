/**
 * API 客户端
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import axios from 'axios'
import { useAuthStore } from '@/stores/auth.js'

export const apiClient = axios.create({
  baseURL: `${import.meta.env.VITE_SERVER_API_URL}${import.meta.env.VITE_SERVER_API_PREFIX}`,
  timeout: Number(import.meta.env.VITE_SERVER_API_TIMEOUT),
})

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
