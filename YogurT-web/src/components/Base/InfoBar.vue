<template>
  <div class="panel h-14 md:h-15 lg:h-16 px-6 md:px-8 flex flex-row items-center">
    <div class="text-xl md:text-2xl lg:text-3xl font-bold text-base-content">{{ title }}</div>
    <div class="size-1 rounded-full bg-base-content mx-3 md:mx-4"></div>
    <div class="text-sm md:text-base lg:text-lg text-base-content/80">{{ description }}</div>
  </div>
</template>

<script setup>
const props = defineProps({
  title: { type: String, required: true },
  description: { type: String }
})
</script>

<style scoped>

</style>