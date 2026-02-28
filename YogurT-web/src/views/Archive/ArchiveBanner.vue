<template>
  <PageBanner class="h-80 md:h-120 lg:h-140" imgSrc="/images/banner/banner-5.jpg">
    <div class="flex flex-col items-center text-white pt-10 md:pt-25 lg:pt-35 text-shadow-lg text-shadow-black/70">
      <h1 class="text-center text-5xl md:text-6xl lg:text-7xl mb-4 md:mb-6">归档</h1>
      <p class="text-center text-lg md:text-xl lg:text-2xl">66 篇文章</p>
      <slot />
    </div>
  </PageBanner>
</template>

<script setup>
import PageBanner from '@/components/Page/PageBanner.vue'
</script>

<style scoped>

</style>