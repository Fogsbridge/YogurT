<template>
  <div class="panel h-fit px-6 py-6 min-h-50 w-full space-y-4">
    <h2 class="text-xl font-bold text-base-content">
      分类
    </h2>

    <ul v-if="isLoading" class="flex flex-col gap-y-1 text-lg">
      <li v-for="i in 3" class="skeleton inline-block rounded-xl w-full h-13 bg-base-300/60"></li>
    </ul>

    <div v-else-if="categories.length" class="relative">
      <ul class="flex flex-wrap flex-col gap-y-2"
          :class="categories.length > maxItems ? 'after:absolute after:bottom-14 after:h-40 after:bg-linear-to-t after:from-base-100 after:to-transparent after:w-full after:pointer-events-none' : ''"
      >
        <li class="group w-full flex items-center justify-between rounded-xl text-base-content/75 bg-base-200/80 hover:pr-8 hover:bg-primary hover:text-white px-5 py-2.5 cursor-pointer transition-all duration-300"
            v-for="category in categories.slice(0, maxItems)"
            :key="category.id"
            :class="{ 'active': isActive(category) }"
            @click="$router.push({ name: 'CategoryDetail', params: { categoryName: category.name } })"
        >
          <span class="flex-1 text-lg truncate group-hover:font-bold">{{ category.name }}</span>
          <div class="flex-none size-6 bg-base-content/5 dark:bg-base-content/15 rounded-full group-hover:bg-transparent group-hover:w-fit text-base-content/40 dark:text-base-content/50 group-hover:text-white text-center group-hover:scale-130">
            <span class="group-hover:font-bold text-xs leading-6.5 duration-300">
              {{ category.postsCount }}
              <span class="group-hover:inline" :class="isActive(category) ? 'inline' : 'hidden'">篇文章</span>
            </span>
          </div>
        </li>
      </ul>

      <div>
        <div class="mt-4 text-center font-bold py-3 rounded-xl border border-base-content/20 text-base-content/60 hover:bg-primary hover:text-white duration-300 cursor-pointer"
             :class="categories.length <= maxItems ? 'hidden' : ''"
             @click.stop="$router.push({ name:'Categories' })"
        >
          更多分类
        </div>
      </div>
    </div>

    <div v-else class="mt-12">
      <p class="w-full text-center text-lg text-base-content/70">
        暂无分类
      </p>
    </div>
  </div>
</template>

<script setup>
import { computed, onMounted, ref, toRefs } from 'vue'

const props = defineProps({
  currentCategory: { type: Object },
  maxItems: { type: Number, default: 6 }
})

const { currentCategory, maxItems } = toRefs(props)
const categories = ref(null)

onMounted(() => {
  setTimeout(() => {
    categories.value = [
      { id: '1001', name: '技术', postsCount: 3, coverUrl: '/images/category-cover/cover-1.jpg'},
      { id: '1002', name: '生活', postsCount: 1, coverUrl: '/images/category-cover/cover-2.jpg'},
      { id: '1003', name: '学习', postsCount: 2, coverUrl: '/images/category-cover/cover-3.png' },
      { id: '1004', name: '旅行', postsCount: 1, coverUrl: '/images/category-cover/cover-4.jpg' },
      { id: '1005', name: '胡说八道', postsCount: 1, coverUrl: '/images/category-cover/cover-5.png'},
      { id: '1006', name: '开发', postsCount: 3, coverUrl: ''}
    ]
  }, 500)
})

const isLoading = computed(() => categories.value === null)

const isActive = (category) => currentCategory.value?.id === category.id
</script>

<style scoped>
@reference "@/assets/styles/index.css";

.active {
  @apply bg-primary text-primary-content font-bold pr-8;
  & > div:last-child {
    @apply w-fit scale-130 font-bold text-white bg-transparent;
  }
}
</style>