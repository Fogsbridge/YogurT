<template>
  <div class="flex flex-col gap-2 md:gap-4">
    <SidebarContainer>
      <template #sticky>
        <CategorySidebar :currentCategory="currentCategory" />
      </template>
    </SidebarContainer>

    <InfoBar :title="currentCategory ? currentCategory.name : ''"
             :description="categoryPosts?.length ? `共 ${categoryPosts?.length} 篇文章` : ''"
    />

    <CardGrid :items="categoryPosts" v-slot="{ item }" class="grid-cols-1 md:grid-cols-2 lg:grid-cols-1">
      <PostCard :post="item" class="h-82 lg:h-62"
                :layout="postCardProps.layout"
                :coverRatio="postCardProps.coverRatio"
                :contentRatio="postCardProps.contentRatio"
                :descriptionLineCount="postCardProps.descriptionLineCount"
                :enableLikeCount="postCardProps.enableLikeCount"
                :enableCommentCount="postCardProps.enableCommentCount"
      />
    </CardGrid>
  </div>
</template>

<script setup>
import SidebarContainer from '@/components/Section/SidebarContainer.vue'
import CategorySidebar from '@/components/Sidebar/CategorySidebar.vue'
import CardGrid from '@/components/Base/CardGrid.vue'
import PostCard from '@/components/Post/PostCard.vue'
import { onMounted, ref, toRefs, watch, watchEffect } from 'vue'
import InfoBar from '@/components/Base/InfoBar.vue'
import { useResponsiveProps } from '@/composables/useResponsiveProps.js'

const props = defineProps({
  categoryName: { type: String }
})

const postCardProps = useResponsiveProps({
  'xs': {
    layout: 'vertical',
    coverRatio: 55,
    contentRatio: 45,
    descriptionLineCount: 1,
    enableLikeCount: false,
    enableCommentCount: false
  },
  'lg': {
    layout: 'horizontal',
    coverRatio: 35,
    contentRatio: 65,
    descriptionLineCount: 4,
    enableLikeCount: true,
    enableCommentCount: true
  }
})

const { categoryName } = toRefs(props)
const categories = ref(null)
const categoryPosts = ref(null)
const currentCategory = ref(null)

onMounted(() => {
  setTimeout(() => {
    categories.value = [
      { id: '1001', name: '技术', postsCount: 2, coverUrl: '/images/category-cover/cover-1.jpg'},
      { id: '1002', name: '日常', postsCount: 0, coverUrl: ''},
      { id: '1003', name: '胡说八道', postsCount: 1, coverUrl: '/images/category-cover/cover-4.jpg'},
      { id: '1004', name: '开发', postsCount: 3, coverUrl: ''}
    ]
  }, 500)
})

watchEffect(() => {
  if (categories.value === null)
    return

  const foundCategory = categories.value.find(item => item.name === categoryName.value);
  currentCategory.value = foundCategory || {}; // 未找到时设为空对象
})

// 当前分类变化时，获取此分类下的文章数据
watch(currentCategory, (newCategory) => {
  categoryPosts.value = null
  if (newCategory === null)
    return

  setTimeout(() => {
    switch (newCategory.name) {
      case '技术':
        categoryPosts.value = [
          {
            id: 1001,
            title: '喝杯 Java',
            description: '80 一杯',
            category: '技术',
            tags: [
              { name: 'Java', color: 'oklch(70.4% 0.191 22.216)' }
            ],
            coverUrl: '/images/post-cover/cover-1.png',
            date: '2024-03-22',
            readCount: 434,
            likeCount: 34,
            commentCount: 3,
            readTime: 3
          },
          {
            id: 1002,
            title: 'Vue 从入门到放弃Vue 从入门到放弃Vue 从入门到放弃Vue从入门到放弃Vue 从入门到放弃',
            description: '这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉',
            category: '技术',
            tags: [
              { name: 'Vue', color: 'oklch(79.2% 0.209 151.711 / .8)' },
              { name: 'JavaScript', color: 'oklch(70.2% 0.183 293.541 / .8)' }
            ],
            coverUrl: '/images/post-cover/cover-2.png',
            date: '2022-02-28',
            readCount: 645,
            likeCount: 43,
            commentCount: 6,
            readTime: 12
          }
        ]
        break
      case '生活':
        categoryPosts.value = []
        break
      case '胡说八道':
        categoryPosts.value = [
          {
            id: 3001,
            title: '关于我头发掉光了这档子事',
            description: '不小心把脱毛膏当成洗发水了...',
            category: '胡说八道',
            tags: [{ name: '植发', color: 'oklch(70.7% 0.165 254.624 / .8)' }],
            coverUrl: '/images/post-cover/cover-3.jpg',
            date: '2024-12-04',
            readCount: 444,
            likeCount: 33,
            commentCount: 11,
            readTime: 4
          }
        ]
        break
      case '开发':
        categoryPosts.value = [
          {
            id: 4001,
            title: 'Java 从入门到放弃',
            description: '',
            category: '开发',
            tags: [
              { name: 'Java', color: 'oklch(70.4% 0.191 22.216 / .8)' }
            ],
            coverUrl: '/images/post-cover/cover-4.jpg',
            date: '2025-03-01',
            readCount: 123,
            likeCount: 31,
            commentCount: 5,
            readTime: 8
          },
          {
            id: 4002,
            title: 'Spring 从入门到放弃',
            description: '这是一段描述巴拉巴拉',
            category: '开发',
            tags: [
              { name: 'Spring', color: 'oklch(79.2% 0.209 151.711 / .8)' },
              { name: 'Java', color: 'oklch(70.4% 0.191 22.216 / .8)' }
            ],
            coverUrl: '/images/post-cover/cover-5.jpg',
            date: '2025-02-28',
            readCount: 441,
            likeCount: 22,
            commentCount: 8,
            readTime: 12
          },
          {
            id: 4003,
            title: 'JavaScript 从入门到放弃',
            description: '这是一段描述巴拉巴拉',
            category: '开发',
            tags: [
              { name: 'JavaScript', color: 'oklch(70.2% 0.183 293.541 / .8)' }
            ],
            coverUrl: '/images/post-cover/cover-6.png',
            date: '2024-05-28',
            readCount: 643,
            likeCount: 123,
            commentCount: 0,
            readTime: 22
          }
        ]
        break
      default:
        categoryPosts.value = []
    }
  }, 1000)
}, { immediate: true })
</script>

<style scoped>

</style>