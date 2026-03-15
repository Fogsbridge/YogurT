<template>
  <BannerContainer mode="immersive">
    <div class="h-60 md:h-80 lg:h-100 bg-center bg-cover bg-[url(/images/banner/banner-5.jpg)]">
      <div class="absolute inset-0 bg-black/15 dark:bg-black/30 transition duration-500">
        <div class="flex flex-col items-center text-white pt-10 md:pt-25 lg:pt-35 text-shadow-lg text-shadow-black/70">
          <h1 class="text-center text-5xl md:text-6xl lg:text-7xl mb-4 md:mb-6">归档</h1>
          <p class="text-center text-lg md:text-xl lg:text-2xl">66 篇文章</p>
        </div>
      </div>
    </div>
  </BannerContainer>
</template>

<script setup>
import BannerContainer from '@/components/Layout/components/BannerContainer.vue'
</script>

<style scoped>

</style>