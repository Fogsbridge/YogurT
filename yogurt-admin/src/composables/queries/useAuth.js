/**
 * 认证相关接口封装
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { useBaseMutation } from '@/composables/queries/base/useBaseMutation.js'
import { authApi } from '@/api/auth.js'

export function useRegisterMutation(options = {}) {
  return useBaseMutation(authApi.register, options)
}

export function useLoginMutation(options = {}) {
  return useBaseMutation(authApi.login, options)
}
