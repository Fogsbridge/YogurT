<template>
  <Teleport defer :to="teleportTarget">
    <div class="relative" :class="mode === 'content' ? 'panel overflow-clip' : ''"
         v-bind="$attrs"
    >
      <slot />
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
  mode: { type: String, required: true, validator: v => ['immersive', 'content'].includes(v) }
})

const { mode } = toRefs(props)

const teleportTarget = computed(() => {
  switch (mode.value) {
    case 'immersive': return '[data-role="immersive-banner"]'
    case 'content': return '[data-role="content-banner"]'
    default: return
  }
})

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