<template>
  <span>
    {{ displayText }}
    <span class="animate-blink" :class="cursorClass"></span>
  </span>
</template>

<script setup>
import { ref, toRefs, onMounted } from 'vue'

const props = defineProps({
  text: { type: [String, Array], required: true},
  // 打字机动画参数
  typingDelay: { type: String, default: '100' }, // 输入下一个字的延迟时间
  deletingDelay: { type: String, default: '60' }, // 删除下一个字的延迟时间
  preDeleteDelay: { type: String, default: '2500' }, // 输入完成后，准备删除前的停顿时间
  preNextTextDelay: { type: String, default: '1000' }, // 开始执行下一段文本前的停顿时间
  cursorClass: { type: String, default: 'pl-0.5 ml-0 bg-current' }, // 光标样式
  blinkTime: { type: String, default: '1300ms' } // 光标闪烁时间
})

const {
  text,
  typingDelay,
  deletingDelay,
  preDeleteDelay,
  preNextTextDelay,
  cursorClass,
  blinkTime
} = toRefs(props)

const textArr = ref(typeof text.value === 'string' ? [text.value] : text.value)
const displayText = ref('')
let titleIndex = 0
let isTyping = true

const typewriter = () => {
  const currentText = textArr.value[titleIndex]
  if (isTyping) {
    // 输入
    if (displayText.value.length < currentText.length) {
      displayText.value = currentText.substring(0, displayText.value.length + 1)
      setTimeout(typewriter, typingDelay.value)
    } else {
      isTyping = false
      setTimeout(typewriter, preDeleteDelay.value)
    }
  } else {
    // 删除
    if (displayText.value.length > 0) {
      displayText.value = displayText.value.substring(0, displayText.value.length - 1)
      setTimeout(typewriter, deletingDelay.value)
    } else {
      isTyping = true
      titleIndex = (titleIndex + 1) % textArr.value.length
      setTimeout(typewriter, preNextTextDelay.value)
    }
  }
}

onMounted(() => {
  typewriter()
})
</script>

<style scoped>
/* 光标闪烁动画 */
.animate-blink {
  animation: blink v-bind(blinkTime) step-end infinite;
}

@keyframes blink {
  0%, 50% {
    opacity: 1;
  }
  51%, 100% {
    opacity: 0;
  }
}
</style>