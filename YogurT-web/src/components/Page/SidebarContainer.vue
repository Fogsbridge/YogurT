<template>
  <Teleport defer :to="`[data-role='layout-${side}-sidebar']`">
    <div v-bind="$attrs" class="w-(--sidebar-width)" v-tw:--sidebar-width.spacing="width">
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
  width: { type: Number, default: 70 }
})
</script>

<style scoped>

</style>