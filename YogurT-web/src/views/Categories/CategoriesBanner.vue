<template>
  <BannerContainer mode="content">
    <div class="relative h-96 bg-cover bg-center bg-(image:--banner-url)"
         v-tw:--banner-url="`url(${imgUrl})`"
    >
      <div class="absolute inset-0 bg-linear-to-r from-black/70 to-transparent"></div>
      <div class="absolute h-full flex items-center px-8 md:px-16">
        <div class="text-white max-w-2xl">
          <h1 class="text-5xl md:text-6xl font-bold mb-4">{{ title }}</h1>
          <p class="text-xl md:text-2xl opacity-90 mb-6">{{ subTitle }}</p>
          <div class="w-24 h-1 bg-white/60"></div>
          <p class="mt-4 text-sm opacity-75">共 {{ categoryCount }} 个分类</p>
        </div>
      </div>
    </div>
  </BannerContainer>
</template>

<script setup>
import BannerContainer from '@/components/Section/BannerContainer.vue'

const props = defineProps({
  imgUrl: { type: String },
  title: { type: String },
  subTitle: { type: String },
  categoryCount: { type: Number }
})
</script>

<style scoped>

</style>