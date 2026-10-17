<!--
 * 封装 LogoWord
 * 依赖 shadcn ui 的 cn() 函数
 *
 * @author fogsbridge
 * @since 1.0.0
-->
<script setup>
import logoLight from '@/assets/logo/logo-word.png'
import logoDark from '@/assets/logo/logo-word-dark.png'
import { useColorMode } from '@vueuse/core'
import { computed } from 'vue'
import { cn } from '@/lib/utils.js'

const props = defineProps({
  class: {
    type: [Boolean, null, String, Object, Array],
    required: false,
    default: undefined,
    skipCheck: true,
  },
})

const color = useColorMode()
const source = computed(() => (color.value === 'light' ? logoLight : logoDark))
</script>

<template>
  <img :src="source" :class="cn('object-contain', props.class)" alt="" draggable="false" />
</template>
