/**
 * 认证相关接口封装
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { authApi } from '@/api/auth.js'
import { useMutation } from '@tanstack/vue-query'

export function useRegisterMutation() {
  return useMutation({
    mutationFn: authApi.register,
  })
}

export function useLoginMutation() {
  return useMutation({
    mutationFn: authApi.login,
  })
}

export function useLogoutMutation() {
  return useMutation({
    mutationFn: authApi.logout,
  })
}
