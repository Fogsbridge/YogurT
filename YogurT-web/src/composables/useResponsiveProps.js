import { useBreakpoints, breakpointsTailwind } from '@vueuse/core'
import { computed } from 'vue'

/**
 * 根据当前断点匹配 props
 * @param {Object} propsMap - 定义的 props
 * @returns {Object} 匹配的 props
 */
export function useResponsiveProps(propsMap) {
  // 定义断点
  const breakpoints = { 'xs': 0, ...breakpointsTailwind }
  const bp = useBreakpoints(breakpoints)

  // 当前的断点
  const currentBreakpoint = bp.active()

  // 根据断点从小到大排序的键的集合
  const sortedBreakpointKeys = Object.keys(breakpoints).sort(
    (a, b) => breakpoints[a] - breakpoints[b]
  )

  // 定义的 props 键的集合
  const definedKeys = sortedBreakpointKeys.filter(key => key in propsMap)

  return computed(() => {
    const currentWidth = breakpoints[currentBreakpoint.value]

    // 匹配当前断点中在定义的 props 中最大的断点
    let matchedKey = null
    for (let i = definedKeys.length - 1; i >= 0; i--) {
      const key = definedKeys[i]
      if (breakpoints[key] <= currentWidth) {
        matchedKey = key
        break
      }
    }

    // 如果没有匹配到则取第一个也就是最小的 props
    if (!matchedKey) {
      matchedKey = definedKeys[0]
    }

    return propsMap[matchedKey]
  })
}