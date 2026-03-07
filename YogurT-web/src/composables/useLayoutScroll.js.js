import { useWindowScroll } from '@vueuse/core'

export function useLayoutScroll() {
  const { y } = useWindowScroll({ behavior: 'smooth' })

  const scrollToMain = () => {
    const mainBounding = document.querySelector('[data-role="layout-main"]').getBoundingClientRect()
    const navBounding = document.querySelector('[data-role="layout-nav"] > div').getBoundingClientRect()

    y.value = window.scrollY + mainBounding.top - navBounding.height
  }

  const scrollToTop = () => {
    y.value = 0
  }
  return { scrollToMain, scrollToTop }
}