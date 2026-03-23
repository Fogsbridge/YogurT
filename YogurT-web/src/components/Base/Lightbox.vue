<template>
  <Teleport :disabled="!show" to="body">
    <div ref="modalRef"
         v-bind="$attrs"
         class="fixed bg-black/65 inset-0 z-1000 before:backdrop-blur-xs before:absolute before:inset-0 before:-z-1"
         v-if="show"
    >
      <div class="z-1 absolute inset-x-0 top-0 h-14 rounded-xl w-fit px-4 mx-auto bg-black/65 dark:bg-white/70 flex items-center gap-5">
        <button @click.stop="zoom(7 / 5)" title="放大" class="text-5xl text-white/70 hover:text-white dark:text-black/60 dark:hover:text-black">
          <svg class="size-7" fill="currentColor" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11M13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0"/>
            <path d="M10.344 11.742q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1 6.5 6.5 0 0 1-1.398 1.4z"/>
            <path fill-rule="evenodd" d="M6.5 3a.5.5 0 0 1 .5.5V6h2.5a.5.5 0 0 1 0 1H7v2.5a.5.5 0 0 1-1 0V7H3.5a.5.5 0 0 1 0-1H6V3.5a.5.5 0 0 1 .5-.5"/>
          </svg>
        </button>

        <button @click.stop="zoom(5 / 7)" title="缩小" class="text-5xl text-white/70 hover:text-white dark:text-black/60 dark:hover:text-black">
          <svg class="size-7" fill="currentColor" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"/>
            <path d="M10.344 11.742c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1 6.538 6.538 0 0 1-1.398 1.4z"/>
            <path fill-rule="evenodd" d="M3 6.5a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5z"/>
          </svg>
        </button>

        <button @click.stop="rotate(-90)" title="逆时针旋转" class="text-5xl text-white/70 hover:text-white dark:text-black/60 dark:hover:text-black">
          <svg class="size-7" fill="currentColor" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M8 3a5 5 0 1 1-4.546 2.914.5.5 0 0 0-.908-.417A6 6 0 1 0 8 2v1z"/>
            <path d="M8 4.466V.534a.25.25 0 0 0-.41-.192L5.23 2.308a.25.25 0 0 0 0 .384l2.36 1.966A.25.25 0 0 0 8 4.466z"/>
          </svg>
        </button>

        <button @click.stop="rotate(90)" title="顺时针旋转" class="text-5xl text-white/70 hover:text-white dark:text-black/60 dark:hover:text-black">
          <svg class="size-7" fill="currentColor" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z"/>
            <path d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z"/>
          </svg>
        </button>

        <button @click.stop="close" title="关闭" class="text-5xl text-white/70 hover:text-white dark:text-black/60 dark:hover:text-black">
          <svg class="size-7" fill="currentColor"  viewBox="0 0 16 16">
            <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z"/>
          </svg>
        </button>
      </div>

      <div ref="wrapperRef" class="size-(--wrapper-size) rotate-(--rotate) max-w-none max-h-none pointer-events-none select-none content-center fixed cursor-move transition-[rotate,width,height,top,left,opacity] duration-(--duration)"
           v-tw:--wrapper-size="wrapperSize"
           v-tw:--rotate="`${rotateDegrees}deg`"
           v-tw:--duration="`${duration}ms`"
           :style="[style]"
           :class="{ 'opacity-0': !initialized }"
      >
        <img ref="imgRef" alt="image" class="m-auto pointer-events-auto" :src="url"
             @load="initialWrapper"
        />
      </div>
    </div>
  </Teleport>
</template>

<script setup>
import { nextTick, ref, useTemplateRef } from 'vue'
import { useDraggable, useEventListener, useThrottleFn, useWindowSize } from '@vueuse/core'

defineOptions({ inheritAttrs: false })
const show = defineModel('show', { required: true })
const props = defineProps({ url: { type: String, required: true } })

const modalRef = useTemplateRef('modalRef')
const wrapperRef = useTemplateRef('wrapperRef')
const wrapperSize = ref('')
const imgRef = useTemplateRef('imgRef')
const { width: viewportWidth, height: viewportHeight } = useWindowSize()
const initialized = ref(false)
const duration = ref(300)

const { x, y, style } = useDraggable(wrapperRef, {
  preventDefault: true,
  stopPropagation: true,
  // 拖动过程中取消过渡动画
  onStart: () => wrapperRef.value.classList.add('transition-none'),
  onEnd: () => wrapperRef.value.classList.remove('transition-none')
})

// 禁止触摸屏设备下的背景滚动，以解决触摸屏设备下拖动图片卡顿抖动的问题
useEventListener(modalRef, 'touchmove', e => e.preventDefault(), { passive: false })

// 使 wrapper 居中于屏幕
const centerWrapper = async () => {
  x.value = (viewportWidth.value - wrapperRef.value?.getBoundingClientRect().width) / 2
  y.value = (viewportHeight.value - wrapperRef.value?.getBoundingClientRect().height) / 2
}

// 初始化 wrapper
const initialWrapper = () => {
  // 设置图片外部 wrapper 的宽高
  // 无论宽屏或竖屏，使 wrapper 始终为一个正方形。如果是竖屏则 wrapper 宽度占满屏幕宽度，横屏则高度占满屏幕高度
  wrapperSize.value =  viewportWidth.value < viewportHeight.value ? '100lvw' : '100lvh'
  // 图片宽度小于高度（竖图）则添加 h-full，否则图片会被 wrapper 截断
  imgRef.value?.classList.toggle('h-full', imgRef.value?.naturalWidth <= imgRef.value?.naturalHeight)
  // 图片宽度大于高度（横图）则添加 w-full，否则放大无法超过图片真实尺寸
  imgRef.value?.classList.toggle('w-full', imgRef.value?.naturalWidth > imgRef.value?.naturalHeight)

  nextTick(() => {
    centerWrapper() // 居中 wrapper

    nextTick(() => {
      /*
        因为 initialWrapper 是 img 加载完成之后执行的，如果不通过额外的变量控制 img 的显示状态
        那么上述设置宽高以及居中的操作，会导致图片瞬间偏移。
        所以使用 initialized 控制显示状态，img 最初是透明的，等待初始化完成后，再使其不透明让 img 显示
      */
      initialized.value = true
    })
  })
}

const rotateDegrees = ref(0)

const rotate = (degrees) => rotateDegrees.value += degrees

/*
节流，缩放图片的过程中，过渡动画还未完成时，此时元素的大小和坐标还未到预定值。
防止在此过程中又一次执行此方法会导致宽高和坐标值混乱。
 */
const zoom = useThrottleFn((factor) => {
  const wrapperRect = wrapperRef.value.getBoundingClientRect()
  const currentWidth = wrapperRect.width
  const currentHeight = wrapperRect.height

  const newWidth = currentWidth * factor
  const newHeight = currentHeight * factor
  wrapperRef.value.style.width = newWidth + 'px'
  wrapperRef.value.style.height = newHeight + 'px'

  // 由于放大了图片，需要调整坐标值，以保持中心点不变
  const widthDiff = newWidth - currentWidth
  const heightDiff = newHeight - currentHeight

  x.value -= widthDiff / 2
  y.value -= heightDiff / 2
}, duration.value)

// 重置状态
const reset = () => {
  initialized.value = false
  rotateDegrees.value = 0
  wrapperSize.value = ''
}

const close = () => {
  show.value = false
  reset()
}
</script>

<style scoped>

</style>