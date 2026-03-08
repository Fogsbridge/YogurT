<template>
  <div class="flex-none panel w-70 h-fit px-6 py-4 sticky top-19">
    <h2 class="text-2xl font-bold text-base-content mb-4 hidden xl:block">
      分类
    </h2>

    <ul v-if="isLoading" class="flex flex-col gap-y-1 text-lg">
      <li class="skeleton inline-block rounded-xl w-full h-13"></li>
      <li class="skeleton inline-block rounded-xl w-full h-13 bg-base-300/60"></li>
      <li class="skeleton inline-block rounded-xl w-full h-13 bg-base-300/60"></li>
    </ul>

    <ul v-else-if="categories.length" class="flex flex-wrap xl:flex-col gap-x-1 xl:gap-x-0 gap-y-1">
      <li
        class="
          inline-block text-base-content/80 hover:bg-base-content/3 px-3 py-1 rounded-lg cursor-pointer transition-colors duration-300
          xl:flex xl:items-center xl:justify-between xl:rounded-xl xl:px-4 xl:py-3
        "
        v-for="category in categories"
        :key="category.id"
        :class="{ 'active': isActive(category) }"
        @click="router.push({ name: 'CategoryDetail', params: { categoryName: category.name } })"
      >
        <span class="text-lg">{{ category.name }}</span>
        <span class="hidden bg-base-content/7 dark:bg-base-content/17 text-sm size-6 rounded-full text-center leading-6.5 shrink-0 xl:block">
          {{ category.postsCount }}
        </span>
      </li>
    </ul>

    <div v-else class="flex items-center py-2 h-9 xl:h-50">
      <p class="w-full text-center text-lg text-base-content/70">
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