/**
 * 插件统一入口
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { setupPinia } from '@/plugins/setup-pinia.js'
import { setupRouter } from '@/plugins/setup-router.js'
import { setupVueQuery } from '@/plugins/setup-vue-query.js'
import { setupBprogress } from '@/plugins/setup-bprogress.js'

export function setupPlugins(app) {
  setupPinia(app)
  setupRouter(app)
  setupVueQuery(app)
  setupBprogress()
}
