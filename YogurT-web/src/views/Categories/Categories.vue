<template>
  <div class="space-y-2 md:space-y-4">
    <InfoBar title="文章分类" :description="categories ? `共 ${categories.length} 条分类` : ''"/>

    <CategoriesGrid :categories="categories" />
  </div>
</template>

<script setup>
import InfoBar from '@/components/Base/InfoBar.vue'
import CategoriesGrid from '@/views/Categories/components/CategoriesGrid.vue'
import { onMounted, ref } from 'vue'

const categories = ref(null)

onMounted(() => {
  setTimeout(() => {
    categories.value = [
      { id: '1001', name: '技术', postsCount: 3, coverUrl: '/YogurT/images/category-cover/cover-1.jpg'},
      { id: '1002', name: '生活', postsCount: 1, coverUrl: '/YogurT/images/category-cover/cover-2.jpg'},
      { id: '1003', name: '学习', postsCount: 2, coverUrl: '/YogurT/images/category-cover/cover-3.png' },
      { id: '1004', name: '旅行', postsCount: 1, coverUrl: '/YogurT/images/category-cover/cover-4.jpg' },
      { id: '1005', name: '胡说八道', postsCount: 1, coverUrl: '/YogurT/images/category-cover/cover-5.png'},
      { id: '1006', name: '开发', postsCount: 3, coverUrl: ''}
    ]
  }, 500)
})
</script>

<style scoped>

</style>
