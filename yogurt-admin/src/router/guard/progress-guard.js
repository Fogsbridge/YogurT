/**
 * 进度条路由守卫
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { BProgress } from '@bprogress/core'

export function setupProgressGuard(router) {
  router.beforeEach(() => {
    BProgress.start()
  })

  router.afterEach(() => {
    BProgress.done()
  })

  router.onError(() => {
    BProgress.done()
  })
}
