/**
 * TanStack Vue Query 注册
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { QueryClient, VueQueryPlugin } from '@tanstack/vue-query'

export const queryClient = new QueryClient({
  defaultOptions: {
    mutations: {
      networkMode: 'always',
    },
  },
})

export function setupVueQuery(app) {
  app.use(VueQueryPlugin, { queryClient })
}
