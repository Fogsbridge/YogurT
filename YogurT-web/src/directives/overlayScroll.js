import { OverlayScrollbars } from 'overlayscrollbars'
import 'overlayscrollbars/overlayscrollbars.css'
import { useGlobalScrollStore } from '@/stores/globalScroll.js'

export const vOverlayScroll = {
  mounted(el, binding) {
    const config = binding.value || {
      scrollbars: {
        autoHide: 'move',
        clickScroll: true,
        theme: 'os-theme-custom'
      },
      cancel: {
        nativeScrollbarsOverlaid: true
      }
    }

    el.setAttribute('data-overlayscrollbars-initialize', '')

    const instance = OverlayScrollbars(el, config)

    el.__osInstance__ = instance

    if (binding.modifiers?.global) {
      const scrollStore = useGlobalScrollStore()
      scrollStore.setInstance(instance)
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

    const scrollStore = useGlobalScrollStore()
    if (scrollStore.osInstance === el.__osInstance__) {
      scrollStore.clearInstance()
    }

    el.removeAttribute('data-overlayscrollbars-initialize')
  },
}