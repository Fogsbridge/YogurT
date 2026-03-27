<template>
  <Teleport defer :disabled="placement === 'content'" :to="teleportTarget">
    <div class="relative"
         :class="bannerClass"
         v-bind="$attrs"
    >
      <img
        :src="imgUrl"
        :alt="imgAlt"
        class="absolute -z-100 inset-0 w-full h-full object-cover object-center"
        v-if="imgUrl"
      />
      <div v-if="showOverlay" class="absolute -z-99 inset-0 dot-mask backdrop-brightness-75 dark:backdrop-brightness-65 transition duration-500"></div>
      <div :class="slotClass">
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
  placement: { type: String, required: true, validator: v => ['header', 'main', 'content'].includes(v) },
  imgUrl: { type: String },
  imgAlt: { type: String, default: '' },
  showOverlay: { type: Boolean, default: true }
})

const { placement, imgUrl, imgAlt, showOverlay } = toRefs(props)

const teleportTarget = computed(() => {
  switch (placement.value) {
    case 'header': return '[data-role="header-banner"]'
    case 'main': return '[data-role="main-banner"]'
    default: return null
  }
})

const bannerClass = computed(() =>
  placement.value === 'main' || placement.value === 'content'
    ? 'panel overflow-clip bg-transparent'
    : ''
)
const slotClass = computed(() => placement.value === 'header' ? 'pt-16' : '')

const { setNavbarFloat } = useNavbarFloat()

onMounted(() => {
  if (placement.value === 'header') {
    setNavbarFloat(true)
  }
})

onUnmounted(() => {
  setNavbarFloat(false)
})
</script>

<style scoped>

</style>