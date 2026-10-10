/**
 * 认证相关接口封装
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { useMutation } from '@tanstack/vue-query'
import { authApi } from '@/api/auth.js'
import { handleApiError } from '@/utils/handle-api-error.js'
import { useDebounceFn } from '@vueuse/core'

export function useRegisterMutation(options = {}) {
  const { onError: errorOption, debounce = 400, ...rest } = options

  const mutation = useMutation({
    mutationFn: (data) => authApi.register(data),
    ...rest,
    onError: (error, variables, context) => {
      // 处理通用错误
      if (handleApiError(error)) return
      errorOption?.(error, variables, context)
    },
  })

  const debouncedMutate = useDebounceFn((data, mutateOptions) => {
    mutation.mutate(data, mutateOptions)
  }, debounce)

  return {
    ...mutation,
    debouncedMutate,
  }
}
