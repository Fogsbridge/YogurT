/**
 * 认证相关接口
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { apiClient } from './api-client.js'

export const authApi = {
  register: (data) => apiClient.post('/auth/register', data),
}
