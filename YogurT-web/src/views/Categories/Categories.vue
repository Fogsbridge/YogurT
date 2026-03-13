<template>
  <div class="flex flex-col gap-2 md:gap-4 mb-20">
    <SidebarContainer>
      <CategorySidebar />
    </SidebarContainer>

    <InfoBar title="文章分类" :description="categories ? `共 ${categories.length} 条分类` : ''"/>

    <CardGrid :items="categories" v-slot="{ item }" class="grid-cols-1 md:grid-cols-2 lg:grid-cols-3">
      <CategoryCard :category="item" class="h-70" />
    </CardGrid>
  </div>
</template>

<script setup>
import CardGrid from '@/components/Base/CardGrid.vue'
import CategoryCard from '@/components/Category/CategoryCard.vue'
import SidebarContainer from '@/components/Section/SidebarContainer.vue'
import CategorySidebar from '@/components/Sidebar/CategorySidebar.vue'
import InfoBar from '@/components/Base/InfoBar.vue'
import { computed, onMounted, ref } from 'vue'

const categories = ref(null)
const InfoBarData = computed(() => {
  if (categories.value) {
    return { name: '文章分类', description: `共 ${categories.value.length} 条分类` }
  }
  return { name: '文章分类', description: '加载中' }
})

onMounted(() => {
  setTimeout(() => {
    categories.value = [
      { id: '1001', name: '技术', postsCount: 2, coverUrl: '/images/category-cover/cover-1.jpg'},
      { id: '1002', name: '日常', postsCount: 0, coverUrl: '/images/category-cover/cover-3.png'},
      { id: '1003', name: '胡说八道', postsCount: 1, coverUrl: '/images/category-cover/cover-4.jpg'},
      { id: '1004', name: '开发', postsCount: 3, coverUrl: ''}
    ]
  }, 500)
})
</script>

<style scoped>

</style>
