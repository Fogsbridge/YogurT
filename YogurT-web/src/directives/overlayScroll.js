import { OverlayScrollbars } from 'overlayscrollbars'
import 'overlayscrollbars/overlayscrollbars.css'

export const vOverlayScroll = {
  mounted(el, binding) {
    const config = binding.value || {
      scrollbars: {
        autoHide: 'move',
        clickScroll: true,
        theme: 'os-theme-custom'
      },
    }

    el.setAttribute('data-overlayscrollbars-initialize', '')

    const instance = OverlayScrollbars(el, config)

    el.__osInstance__ = instance

    if (binding.modifiers?.global) {
      window.__osInstance__ = instance
    }

    if (config.scrollReady && typeof config.scrollReady === 'function') {
      config.scrollReady(instance)
    }
  },

  unmounted(el) {
    if (el.__osInstance__) {
      el.__osInstance__.destroy()
      el.__osInstance__ = undefined
    }

    if (window.__osInstance__ === el.__osInstance__) {
      window.__osInstance__ = undefined
    }

    el.removeAttribute('data-overlayscrollbars-initialize')
  },
}