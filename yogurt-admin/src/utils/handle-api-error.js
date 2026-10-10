/**
 * 统一处理 API 通用错误
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { toast } from 'vue-sonner'

export function handleApiError(error) {
  if (error.code === 'ECONNABORTED') {
    toast.error('请求超时')
    return true
  }

  if (error.code === 'ERR_NETWORK') {
    toast.error('网络异常')
    return true
  }

  // 如果响应体带有 message 则交给上层控制
  if (error.response?.data?.message) {
    return false
  }

  toast.error('操作失败')
  return true
}
