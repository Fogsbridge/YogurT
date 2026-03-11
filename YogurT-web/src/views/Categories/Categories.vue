<template>
  <div class="mb-20">
<!--    <CategoriesBanner :imgUrl="categoriesPageConfig?.bannerImgUrl"-->
<!--                      :title="categoriesPageConfig?.title"-->
<!--                      :subTitle="categoriesPageConfig?.subTitle"-->
<!--                      :categoryCount="categoriesPageConfig?.categoryCount"-->
<!--    />-->

<!--    <SidebarContainer v-if="categoriesPageConfig"-->
<!--                      :side="categoriesPageConfig.sidebar.side"-->
<!--                      :width="categoriesPageConfig.sidebar.width"-->
<!--    >-->
<!--      <div v-if="categoriesPageConfig.sidebar.modules.includes('LatestPosts')" class="panel h-100 sticky top-19">近期文章</div>-->
<!--      <div v-if="categoriesPageConfig.sidebar.modules.includes('Tags')" class="panel h-60">标签</div>-->
<!--      <div v-if="categoriesPageConfig.sidebar.modules.includes('Categories')" class="panel h-80">分类</div>-->
<!--    </SidebarContainer>-->


<!--    <div class="py-10">-->
<!--      <h1 class="text-base-content text-center text-4xl font-bold mb-6">文章分类</h1>-->
<!--&lt;!&ndash;      <p>testtes</p>&ndash;&gt;-->
<!--    </div>-->

    <div class="px-6 py-10 mb-8">
      <h2 class="text-4xl font-bold text-base-content">
        {{ categoriesPageConfig?.title }}
        <span class="text-lg text-base-content/60 ml-2">
          共 {{ categoriesPageConfig?.categoryCount }} 个分类
        </span>
      </h2>
    </div>

    <CardGrid :items="categories" v-slot="{ item }" :cols="1" :mdCols="2" :lgCols="2" :xlCols="2">
      <CategoryCard :category="item" :height="90" />
    </CardGrid>
  </div>
</template>

<script setup>
import CategoriesBanner from '@/views/Categories/CategoriesBanner.vue'
import CardGrid from '@/components/Base/CardGrid.vue'
import CategoryCard from '@/components/Category/CategoryCard.vue'
import SidebarContainer from '@/components/Section/SidebarContainer.vue'
import { onMounted, ref } from 'vue'

const categoriesPageConfig = ref(null)
const categories = ref(null)

onMounted(() => {
  setTimeout(() => {
    categoriesPageConfig.value = {
      title: '文章分类',
      subTitle: 'Categories',
      bannerImgUrl: '/images/banner/banner-7.jpg',
      categoryCount: 6,
      sidebar: {
        side: 'right',
        width: 70,
        modules: ['Categories', 'Tags', 'LatestPosts']
      }
    }
    categories.value = [
      { id: '1001', name: '技术', postsCount: 2, coverUrl: '/images/category-cover/cover-1.jpg'},
      // { id: '1002', name: '日常', postsCount: 0, coverUrl: ''},
      // { id: '1002', name: '日常日常日常日常日常日常日常日常日常日常日常日常日常日常日常日常日常日常日常日常', postsCount: 0},
      // { id: '1002', name: '日常', postsCount: 0, coverUrl: '/images/category-cover/cover-1.jpg'},
      // { id: '1002', name: '日常', postsCount: 0, coverUrl: '/images/category-cover/cover-1.jpg'},
      // { id: '1002', name: '日常', postsCount: 0, coverUrl: '/images/category-cover/cover-1.jpg'},
      { id: '1002', name: '日常', postsCount: 0, coverUrl: '/images/category-cover/cover-3.png'},
      { id: '1003', name: '胡说八道', postsCount: 1, coverUrl: '/images/category-cover/cover-4.jpg'},
      { id: '1004', name: '开发', postsCount: 3, coverUrl: ''}
    ]
  }, 500)
})

</script>

<style scoped>

</style>
