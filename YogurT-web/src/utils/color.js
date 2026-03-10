/**
 * HSL 随机颜色生成
 */

const MAX_LIGHTNESS = 100 // 最大亮度百分比
const MAX_SATURATION = 100 // 最大饱和度百分比
const MAX_HUE = 360 // 最大色相值


/**
 * 生成一个指定亮度和饱和度的随机 HSL 色值对象
 *
 * @private
 * @param {Object} [options] - 配置
 * @param {number} [options.lightness=70] - 亮度值，取值范围 0 ~ 100
 * @param {number|{min:number, max:number}} [options.saturation={min:60, max:80}] - 饱和度：若为 number，则固定为该值,若为 {min, max} 对象，则在此范围内随机取值
 * @returns {{hue: number, saturation: number, lightness: number}} - 返回 HSL 色值
 */
const _generateRandomColor = (options = {}) => {
  const { lightness = 70, saturation = { min: 60, max: 80 } } = options

  // 处理亮度，确保亮度值在 0 ~ 100
  const safeLightness = Math.min(MAX_LIGHTNESS, Math.max(0, lightness))

  // 生成随机色相
  const hue = Math.floor(Math.random() * MAX_HUE)

  // 处理饱和度
  let sat
  if (typeof saturation === 'object') {
    const {min, max} = saturation
    sat = Math.floor(Math.random() * (max - min + 1)) + min
  } else {
    sat = saturation
  }
  sat = Math.min(MAX_SATURATION, Math.max(0, sat)) // 确保饱和度在 0~100 之间

  return { hue, saturation: sat, lightness: safeLightness }
}


/**
 * 生成一个随机的 HSL 颜色字符串
 *
 * @param {Object} [options] - 配置
 * @param {number} [options.lightness=70] - 亮度值
 * @param {number|number[]} [options.saturation=[60,100]] - 饱和度
 * @returns {string} HSL 色值字符串，例如 "hsl(120, 75%, 70%)"
 */
export const randomColor = (options) => {
  const { hue, saturation, lightness } = _generateRandomColor(options)

  return `hsl(${hue}, ${saturation}%, ${lightness}%)`
}


/**
 * 生成一组亮度 递增/递减，饱和度随机 HSL 颜色字符串数组
 *
 * 基于一个随机色值，根据指定步长生成多个 递增/递减 颜色。返回色系相近且亮度渐变的一组颜色。
 *
 * @param {Object} [options] - 配置
 * @param {number} [options.hueStep=5] - 色相步长，可正可负
 * @param {number} [options.lightness=0] - 起始亮度，取值范围 0 ~ 100
 * @param {number} [options.lightnessStep=5] - 亮度步长，可正可负
 * @param {number|{min:number, max:number}} [options.saturation={min:60, max:80}] - 饱和度：若为 number，则固定为该值,若为 {min, max} 对象，则在此范围内随机取值 * @returns {string[]} HSL 颜色字符串数组，按生成顺序排列。
 * @param {number} [options.count=2] - 生成的颜色数量
 */
export const randomColors = (options = {}) => {
  let { hueStep = 5, lightness = 0, lightnessStep = 5, count = 2 } = options

  // 处理亮度，确保亮度值在 0 ~ 100
  lightness = Math.min(MAX_LIGHTNESS, Math.max(0, lightness))

  // 计算最终亮度是否越界，越界则返回空数组
  const finalLightness = lightness + lightnessStep * (count - 1)
  if (finalLightness > MAX_LIGHTNESS || finalLightness < 0) return []


  const { hue: baseHue } = _generateRandomColor(options)
  let currentHue = baseHue
  let currentLightness = lightness
  const colors = []

  // 生成一组颜色
  for (let i = 0; i < count; i++) {
    const { saturation } = _generateRandomColor(options)

    colors.push(`hsl(${currentHue}, ${saturation}%, ${currentLightness}%)`)

    // 生成下一个颜色的色相
    currentHue = (currentHue + hueStep) % MAX_HUE

    // 生成下一个颜色的亮度
    currentLightness += lightnessStep
  }

  return colors
}