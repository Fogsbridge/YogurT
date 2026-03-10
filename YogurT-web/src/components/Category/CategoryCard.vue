<template>
  <div class="group relative h-(--card-height) w-(--card-width) panel bg-clip-padding overflow-clip cursor-pointer
          hover:shadow-2xl transition-all duration-300 transform hover:-translate-y-1 bg-linear-to-br from-(--from-color) to-(--to-color)"
       v-tw:--card-height.spacing="height"
       v-tw:--card-width.spacing="width"
       v-tw:--from-color="startColor"
       v-tw:--to-color="endColor"
       @click.stop="$router.push({ name:'CategoryDetail', params: { categoryName: category.name } })"
  >
    <!-- 分类封面 -->
    <div class="absolute inset-0 bg-cover bg-center bg-(image:--cover-url) transition-transform duration-500 group-hover:scale-115"
         v-tw:--cover-url="`url(${category.coverUrl})`"
    >
    </div>

    <!-- 遮罩 -->
    <div v-if="category.coverUrl" class="absolute inset-0 bg-linear-to-t from-black/70 via-black/30 dark:from-black/80 dark:via-black/40 to-transparent"></div>
    <div v-else class="absolute inset-0 bg-linear-to-t from-black/45 via-black/10 dark:from-black/55 dark:via-black/20 to-transparent"></div>

    <!-- 分类信息 -->
    <div class="absolute inset-0 flex flex-col justify-end p-6 text-white">
      <h2 class="text-2xl font-bold mb-1">{{ category.name }}</h2>
      <p class="text-sm text-white/85 mb-3">{{ category.postsCount }} 篇文章</p>
      <span class="inline-flex items-center text-sm font-medium text-white/85 group-hover:text-white transition">
        <span class="mr-1">前往分类</span>
        <svg class="w-4 h-4 transition-transform duration-500 group-hover:translate-x-1" fill="none" stroke="currentColor" viewBox="0 0 24 24">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7"></path>
        </svg>
      </span>
    </div>
  </div>
</template>

<script setup>
import { randomColors } from '@/utils/color.js'
import { ref } from 'vue'

const props = defineProps({
  category: { type: Object },
  width: { type: Number },
  height: { type: Number }
})

const startColor = ref('')
const endColor = ref('')
const [s, e] = randomColors({
  lightness: 55,
  saturation: { min: 55, max: 65 },
  lightnessStep: -10,
  hueStep: 80,
  count: 2
})

startColor.value = s
endColor.value= e
</script>

<style scoped>

</style>