/**
 * tailwind 默认定义了一些 css 变量,如 --spacing 等等
 * 由于 tw 无法动态拼接类名，同时为了统一单位与 tw 保持一致，定义了此指令
 */
export const vTw = {
  mounted(el, binding) {
    dispatcher(el, binding)
  },

  updated(el, binding) {
    if (binding.value !== binding.oldValue) {
      dispatcher(el, binding)
    }
  },
}

/**
 * 分发器
 * @param el - 元素对象
 * @param binding - 绑定对象
 */
const dispatcher = (el, binding) => {
  const { arg, value, modifiers } = binding

  if (!arg || value == null) return

  const hasModifiers = Object.keys(modifiers).length > 0
  if (!hasModifiers) {
    apply(el, arg, value)
    return
  }

  const firstModifier = Object.keys(modifiers)[0]
  switch (firstModifier) {
    case 'spacing':
      applySpacing(el, arg, value)
      break

    case 'grid-cols':
      applyGridCols(el, arg, value)
      break

    default:
      break
  }
}

/**
 * 直接应用样式值
 * @param el - 元素对象
 * @param {string} prop - CSS 属性名
 * @param {number} val - CSS 属性值
 */
const apply = (el, prop, val) => {

  el.style.setProperty(prop, val)
}

/**
 * 为元素应用 calc(值 * var(--spacing)) 样式
 * @param el - 元素对象
 * @param {string} prop - CSS 属性名
 * @param {number} val - CSS 属性值
 */
const applySpacing = (el, prop, val) => {
  if (isNaN(Number(val))) return

  el.style.setProperty(prop, `calc(${val} * var(--spacing))`)
}

/**
 * 为元素应用 repeat(值, minmax(0, 1fr)) 样式
 * @param el  - 元素对象
 * @param prop - CSS 属性名
 * @param val - CSS 属性值
 */
const applyGridCols = (el, prop, val) => {
  if (isNaN(Number(val))) return

  el.style.setProperty(prop, `repeat(${val}, minmax(0, 1fr))`)
}