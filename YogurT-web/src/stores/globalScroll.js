import { defineStore } from 'pinia'
import { ref, computed } from 'vue'

export const useGlobalScrollStore = defineStore('scroll', () => {
  const osInstance = ref(null)
  const isInitialized = computed(() => osInstance.value !== null)
  const viewport = computed(() => osInstance.value ? osInstance.value.elements().viewport : null)

  // 响应式状态
  const scrollTop = ref(0)
  const scrollLeft = ref(0)
  const scrollHeight = ref(0)
  const scrollWidth = ref(0)
  const clientHeight = ref(0)
  const clientWidth = ref(0)

  let cleanupScrollListener = null

  // 更新状态
  const updateScrollState = (viewport) => {
    scrollTop.value = viewport.scrollTop
    scrollLeft.value = viewport.scrollLeft
    scrollHeight.value = viewport.scrollHeight
    scrollWidth.value = viewport.scrollWidth
    clientHeight.value = viewport.clientHeight
    clientWidth.value = viewport.clientWidth
  }

  // 重置状态
  const resetScrollState = () => {
    scrollTop.value = 0
    scrollLeft.value = 0
    scrollHeight.value = 0
    scrollWidth.value = 0
    clientHeight.value = 0
    clientWidth.value = 0
  }

  const setInstance = (instance) => {
    if (osInstance.value) {
      clearInstance()
    }

    osInstance.value = instance

    if (instance) {
      const { viewport } = instance.elements()
      const onScroll = () => {
        updateScrollState(viewport)
      }
      viewport.addEventListener('scroll', onScroll)
      cleanupScrollListener = () => {
        viewport.removeEventListener('scroll', onScroll)
      }
      updateScrollState(viewport)
    }
  }

  const clearInstance = () => {
    if (osInstance.value) {
      if (cleanupScrollListener) {
        cleanupScrollListener()
        cleanupScrollListener = null
      }
      osInstance.value = null
      resetScrollState()
    }
  }

  const scrollTo = (options) => {
    if (osInstance.value) {
      const { viewport } = osInstance.value.elements()
      viewport.scrollTo(options)
    }
  }

  const scrollToTop = () => {
    scrollTo({ top: 0, behavior: 'smooth' })
  }

  const scrollToMain = () => {
    const { scrollTop } = useGlobalScrollStore()
    const mainBounding = document.querySelector('[data-role="layout-main"]').getBoundingClientRect()
    const navBounding = document.querySelector('[data-role="layout-nav"] > div').getBoundingClientRect()

    if (!mainBounding || !navBounding) return 0

    const target = scrollTop + mainBounding.top - navBounding.height
    scrollTo( { top: target, behavior: 'smooth' })
  }

  return {
    osInstance,
    isInitialized,
    viewport,
    scrollTop,
    scrollLeft,
    scrollHeight,
    scrollWidth,
    clientHeight,
    clientWidth,
    setInstance,
    clearInstance,
    scrollTo,
    scrollToMain,
    scrollToTop
  }
})