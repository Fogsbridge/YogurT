<template>
  <Teleport defer :to="`[data-role='layout-${side}-sidebar']`">
    <div v-bind="$attrs" :style="{'width': width}">
      <slot />
    </div>
  </Teleport>
</template>

<script setup>
defineOptions({
  inheritAttrs: false
})

const props = defineProps({
  side: { type: String, default: 'right', validator: v => ['left', 'right'].includes(v) },
  width: { type: String, default: '280px' }
})
</script>

<style scoped>

</style>