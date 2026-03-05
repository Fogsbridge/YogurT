<template>
  <div class="panel px-6 py-4 flex flex-row items-center">
    <template v-if="isLoading">
        <span class="skeleton w-12 h-8 rounded-lg"></span>
        <span class="text-2xl mx-3">·</span>
        <span class="skeleton w-35 h-6 rounded-lg"></span>
    </template>

    <!-- 如果是空对象则表示此分类不存在 -->
    <template v-else-if="!Object.keys(category).length">
      <span class="text-2xl font-bold text-base-content">未知分类</span>
      <span class="text-2xl mx-3">·</span>
      <span class="text-base-content/80">此分类不存在</span>
    </template>

    <template v-else>
      <div class="text-2xl font-bold text-base-content">{{ category.name }}</div>
      <div class="text-2xl mx-3">·</div>
      <div class="text-base-content/80 ">共 {{ category.postsCount }} 篇文章</div>
    </template>
  </div>
</template>

<script setup>
import { computed, toRefs } from 'vue'

const props = defineProps({
  category: { type: Object }
})

const { category } = toRefs(props)
const isLoading = computed(() => category.value === null)
</script>

<style scoped>

</style>