/**
 * API 客户端
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import axios from 'axios'

export const apiClient = axios.create({
  baseURL: `${import.meta.env.VITE_SERVER_API_URL}${import.meta.env.VITE_SERVER_API_PREFIX}`,
  timeout: Number(import.meta.env.VITE_SERVER_API_TIMEOUT),
})
