<template>
  <div class="-mb-20">
    <div class="relative size-full bg-cover bg-center" :style="{ 'background-image': `url(${imgSrc})` }">
      <div class="absolute inset-0 bg-black/15 dark:bg-black/30 transition duration-500"></div>
      <div class="absolute inset-0 bg-linear-to-b from-transparent from-90% to-base-200 transition duration-500"></div>
      <div class="relative pt-15">
        <slot />
      </div>
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  imgSrc: { type: String, default: '/images/banner/banner-5.jpg' }
})
</script>

<style scoped>

</style>