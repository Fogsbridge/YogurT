<template>
  <div
    ref="card"
    class="relative transform-3d cursor-pointer transition"
    @click="toggle"
  >
    <div class="absolute backface-hidden w-full h-full">
      <slot name="front" />
    </div>
    <div class="absolute backface-hidden w-full h-full" :class="flipClass">
      <slot name="back" />
    </div>
  </div>
</template>

<script setup>
import { computed, toRefs, useTemplateRef } from 'vue'

const props = defineProps({
  axis: { type: String, default: 'y' },
})

const { axis } = toRefs(props)
const card = useTemplateRef('card')

const flipClass = computed(() => axis.value === 'y' ? 'rotate-y-180' : 'rotate-x-180')

const toggle = () => card.value.classList.toggle(flipClass.value)
</script>

<style scoped>

</style>