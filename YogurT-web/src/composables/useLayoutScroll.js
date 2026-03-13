import { useWindowScroll } from '@vueuse/core'

export function useLayoutScroll() {
  const { y } = useWindowScroll({ behavior: 'smooth' })

  const getMainScrollY = () => {
    const mainBounding = document.querySelector('[data-role="layout-main"]').getBoundingClientRect()
    const navBounding = document.querySelector('[data-role="layout-nav"] > div').getBoundingClientRect()

    return window.scrollY + mainBounding.top - navBounding.height
  }

  const scrollToMain = () => {
    y.value = getMainScrollY()
  }

  const scrollToTop = () => {
    y.value = 0
  }

  return { getMainScrollY, scrollToMain, scrollToTop }
}