/**
 * 路由注册
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { router } from '@/router/index.js'

export function setupRouter(app) {
  app.use(router)
}
