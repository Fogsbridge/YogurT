<template>
  <Teleport defer :to="`[data-role='layout-${side}-sidebar']`">
    <div v-bind="$attrs" class="w-(--sidebar-width) h-full flex flex-col gap-y-4" v-tw:--sidebar-width.spacing="width">
      <slot name="default" />
      <div class="sticky top-20 w-full flex flex-col gap-y-4">
        <slot name="sticky" />
      </div>
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