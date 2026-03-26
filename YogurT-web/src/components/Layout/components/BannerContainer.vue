<template>
  <Teleport defer :to="teleportTarget">
    <div class="relative"
         :class="mode === 'content' ? 'panel overflow-clip bg-transparent' : ''"
         v-bind="$attrs"
    >
      <img
        :src="imgUrl"
        :alt="imgAlt"
        class="absolute -z-100 inset-0 w-full h-full object-cover object-center"
        v-if="imgUrl"
      />
      <div v-if="showOverlay" class="absolute -z-99 inset-0 dot-mask backdrop-brightness-75 dark:backdrop-brightness-65 transition duration-500"></div>
      <div :class="contentClass">
        <slot />
      </div>
    </div>
  </Teleport>
</template>

<script setup>
import { useNavbarFloat } from '@/composables/useNavbarFloat.js'
import { computed, onMounted, onUnmounted, toRefs } from 'vue'

defineOptions({
  inheritAttrs: false
})

const props = defineProps({
  mode: { type: String, required: true, validator: v => ['immersive', 'content'].includes(v) },
  imgUrl: { type: String },
  imgAlt: { type: String, default: '' },
  showOverlay: { type: Boolean, default: true }
})

const { mode, imgUrl, imgAlt, showOverlay } = toRefs(props)

const teleportTarget = computed(() => {
  switch (mode.value) {
    case 'immersive': return '[data-role="immersive-banner"]'
    case 'content': return '[data-role="content-banner"]'
    default: return
  }
})

const contentClass = computed(() => mode.value === 'immersive' ? 'pt-16' : '')

const { setNavbarFloat } = useNavbarFloat()

onMounted(() => {
  if (mode.value === 'immersive') {
    setNavbarFloat(true)
  }
})

onUnmounted(() => {
  setNavbarFloat(false)
})
</script>

<style scoped>

</style>