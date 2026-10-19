/**
 * 通用 Mutation 封装
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { useMutation } from '@tanstack/vue-query'
import { handleApiError } from '@/utils/handle-api-error.js'

export function useBaseMutation(mutationFn, options = {}) {
  const {
    onSuccess,
    onError: errorOption,
    onSettled,
    ...rest
  } = options

  return useMutation({
    mutationFn,
    onSuccess,
    onError: (error, variables, context) => {
      // 处理通用错误
      if (handleApiError(error)) return
      errorOption?.(error, variables, context)
    },
    onSettled,
    ...rest,
  })
}
