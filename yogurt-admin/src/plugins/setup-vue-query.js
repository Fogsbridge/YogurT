/**
 * TanStack Vue Query 注册
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { VueQueryPlugin } from '@tanstack/vue-query'

export function setupVueQuery(app) {
  app.use(VueQueryPlugin)
}
