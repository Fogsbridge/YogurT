<template>
  <ul class="grid gap-2 md:gap-4 grid-cols-1 md:grid-cols-2 lg:grid-cols-3">
    <CategoryCard v-for="category in categories" :key="category.id" :category="category" class="h-70 xl:h-80" />
  </ul>
</template>

<script setup>
import CategoryCard from '@/components/Business/Category/CategoryCard.vue'

const props = defineProps({
  categories: { type: Array }
})
</script>

<style scoped>

</style>