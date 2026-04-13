<template>
  <div class="panel h-fit px-6 pt-4 pb-6 min-h-50 w-full space-y-4">
    <div class="text-lg font-bold text-base-content flex flex-row items-center gap-1.5">
      <svg class="size-5.5" fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
        <path clip-rule="evenodd" fill-rule="evenodd" d="M5.25 2.25a3 3 0 0 0-3 3v4.318a3 3 0 0 0 .879 2.121l9.58 9.581c.92.92 2.39 1.186 3.548.428a18.849 18.849 0 0 0 5.441-5.44c.758-1.16.492-2.629-.428-3.548l-9.58-9.581a3 3 0 0 0-2.122-.879H5.25ZM6.375 7.5a1.125 1.125 0 1 0 0-2.25 1.125 1.125 0 0 0 0 2.25Z"></path>
      </svg>
      <h2>标签</h2>
    </div>

    <ul v-if="isLoading" class="flex flex-col gap-y-1 text-lg">
      <li v-for="i in 3" class="skeleton inline-block rounded-xl w-full h-13 bg-base-300/60"></li>
    </ul>

    <div v-else-if="tags.length" class="relative bg-linear-to-t from-base-100 to-transparent ">
      <ul class="flex flex-wrap flex-row gap-2"
          :class="tags.length > maxItems ? 'after:absolute after:bottom-10.5 after:h-40 after:bg-linear-to-t after:from-base-100 after:to-transparent after:w-full after:pointer-events-none' : ''"
      >
        <li class="group hover:scale-110 rounded-lg text-base-content/75 hover:bg-(--tag-color) hover:text-white px-2.5 py-1 cursor-pointer transition duration-200"
            v-for="tag in tags.slice(0, maxItems)"
            :key="tag.id"
            :class="[{ 'bg-(--tag-color) text-white': isActive(tag) }, isActive(tag) ? 'bg-(--tag-color)' : 'bg-base-200/80']"
            v-tw:--tag-color="tag.color"
            @click="$router.push({ name: 'TagDetail', params: { tagName: tag.name } })"
        >
          <span class="mr-0.5 text-base-content/40 group-hover:text-white duration-300" :class="{ 'text-white': isActive(tag) }">#</span>
          <span>{{ tag.name }}</span>
        </li>
      </ul>

      <div>
        <div class="mt-4 text-center font-bold py-1.5 rounded-xl border border-base-content/20 text-base-content/60 hover:bg-primary hover:text-white duration-300 cursor-pointer"
             :class="tags.length <= maxItems ? 'hidden' : ''"
             @click.stop="$router.push({ name:'Tags' })"
        >
          更多标签
        </div>
      </div>
    </div>

    <div v-else class="mt-12">
      <p class="w-full text-center text-lg text-base-content/70">
        暂无标签
      </p>
    </div>
  </div>
</template>

<script setup>
import { computed, onMounted, ref, toRefs } from 'vue'

const props = defineProps({
  currentTag: { type: Object },
  maxItems: { type: Number, default: 24 }
})

const { currentTag, maxItems } = toRefs(props)
const tags = ref(null)

onMounted(() => {
  setTimeout(() => {
    tags.value = [
      { id: '1001', name: 'Java', postsCount: 2, color: 'oklch(70.4% 0.191 22.216)' },
      { id: '1002', name: 'Python', postsCount: 14, color: 'oklch(75% 0.18 145)' },
      { id: '1003', name: 'JavaScript', postsCount: 10, color: 'oklch(80% 0.15 85)' },
      { id: '1004', name: '旅行摄影', postsCount: 7, color: 'oklch(72% 0.12 240)' },
      { id: '1005', name: '美食探店', postsCount: 8, color: 'oklch(78% 0.2 40)' },
      { id: '1006', name: '学习笔记', postsCount: 3, color: 'oklch(68% 0.14 200)' },
      { id: '1007', name: '健身', postsCount: 1, color: 'oklch(73% 0.17 120)' },
      { id: '1008', name: '阅读', postsCount: 21, color: 'oklch(76% 0.13 280)' },
      { id: '1009', name: '科技', postsCount: 22, color: 'oklch(69% 0.16 300)' },
      { id: '1010', name: '心情', postsCount: 6, color: 'oklch(82% 0.1 30)' },
      { id: '1012', name: 'Vue', postsCount: 9, color: 'oklch(79.2% 0.209 151.711 / .8)' },
      { id: '1013', name: '植发', postsCount: 12, color: 'oklch(70.7% 0.165 254.624 / .8)' },
      { id: '1014', name: 'Spring', postsCount: 5, color: 'oklch(79.2% 0.209 151.711 / .8)' }
    ]
  }, 500)
})

const isLoading = computed(() => tags.value === null)

const isActive = (tag) => currentTag.value?.id === tag.id
</script>

<style scoped>

</style>