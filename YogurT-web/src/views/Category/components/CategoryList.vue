<template>
  <div class="flex-none panel w-full px-2 py-2 xl:w-70 xl:h-fit xl:px-6 xl:py-4 xl:sticky xl:top-19">
    <h2 class="text-2xl font-bold text-base-content mb-4 hidden xl:block">
      分类
    </h2>

    <div v-if="isLoading" class="flex xl:flex-col gap-2 px-2 xl:px-0">
      <div v-for="i in 3" class="skeleton w-full text-center py-2 text-base-content/60">
        <span class="skeleton skeleton-text px-2">加载中...</span>
      </div>
    </div>

    <ul v-else-if="categories.length" class="flex flex-wrap xl:flex-col gap-x-1 xl:gap-x-0 gap-y-1">
      <li
        class="
          inline-block text-base-content/80 hover:bg-base-content/3 px-3 py-1 rounded-lg cursor-pointer transition-colors duration-300
          xl:flex xl:items-center xl:justify-between xl:px-4 xl:py-3
        "
        v-for="category in categories"
        :key="category.id"
        :class="{ 'active': isActive(category) }"
        @click="router.push({ name: 'categories', params: { categoryName: category.name } })"
      >
        <span class="text-lg">{{ category.name }}</span>
        <span class="hidden bg-base-content/7 dark:bg-base-content/17 text-sm size-6 rounded-full text-center leading-6.5 shrink-0 xl:block">
          {{ category.postsCount }}
        </span>
      </li>
    </ul>

    <div v-else class="xl:h-50 py-2">
      <p class="text-center text-xl text-base-content/70 xl:pt-15">
        暂无分类
      </p>
    </div>
  </div>
</template>

<script setup>
import { computed, toRefs } from 'vue'
import { useRouter } from 'vue-router'

const props = defineProps({
  categories: { type: Array },
  currentCategory: { type: Object }
})

const { categories, currentCategory } = toRefs(props)
const router = useRouter()
const isLoading = computed(() => categories.value === null)

const isActive = (category) => currentCategory.value?.name === category.name
</script>

<style scoped>
@reference "@/assets/styles/index.css";
.active {
  @apply bg-primary text-primary-content font-bold;
  & > span:last-child {
    @apply bg-primary-content text-primary;
  }
}
</style>