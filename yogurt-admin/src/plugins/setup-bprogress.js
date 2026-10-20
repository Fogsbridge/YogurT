/**
 * BProgress 进度条配置
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { BProgress } from '@bprogress/core'
import '@/assets/bprogress.css'

export function setupBprogress() {
  BProgress.configure({
    indeterminate: false,
    showSpinner: false,
    speed: 300,
  })
}
