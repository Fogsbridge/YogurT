<template>
  <div class="space-y-2 md:space-y-4">
    <SidebarContainer>
      <template #sticky>
        <CategoriesSidebar :currentCategory="currentCategory" />
      </template>
    </SidebarContainer>

    <InfoBar :title="currentCategory ? `分类 / ${currentCategory.name}` : ''"
             :description="categoryPosts?.length ? `共 ${categoryPosts?.length} 篇文章` : ''"
    />

    <CategoryPostsGrid :categoryPosts="categoryPosts" />
  </div>
</template>

<script setup>
import InfoBar from '@/components/Base/InfoBar.vue'
import SidebarContainer from '@/components/Layout/components/SidebarContainer.vue'
import CategoriesSidebar from '@/components/Business/Sidebar/CategoriesSidebar.vue'
import CategoryPostsGrid from '@/views/Categories/components/CategoryPostsGrid.vue'
import { onMounted, ref, toRefs, watch, watchEffect } from 'vue'

const props = defineProps({
  categoryName: { type: String }
})


const { categoryName } = toRefs(props)
const categories = ref(null)
const categoryPosts = ref(null)
const currentCategory = ref(null)

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
            id: '1001',
            title: '喝杯 Java',
            description: '80 一杯',
            category: '技术',
            tags: [
              { name: 'Java', color: 'oklch(70.4% 0.191 22.216 / .8)' }
            ],
            coverUrl: '/YogurT/images/post-cover/cover-1.png',
            date: '2024-03-22',
            readCount: 434,
            likeCount: 34,
            commentCount: 3,
            readTime: 3
          },
          {
            id: '1002',
            title: '从零开始学习Java',
            description: 'Java基础入门指南，适合初学者',
            category: '技术',
            tags: [
              { name: 'Java', color: 'oklch(70.4% 0.191 22.216 / .8)' }
            ],
            coverUrl: '/YogurT/images/post-cover/cover-1.png',
            date: '2024-03-22',
            readCount: 1234,
            likeCount: 89,
            commentCount: 23,
            readTime: 8
          },
          {
            id: '1003',
            title: 'Vue 从入门到放弃Vue 从入门到放弃Vue 从入门到放弃Vue从入门到放弃Vue 从入门到放弃',
            description: '这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉这是一段描述巴拉巴拉',
            category: '技术',
            tags: [
              { name: 'Vue', color: 'oklch(79.2% 0.209 151.711 / .8)' },
              { name: 'JavaScript', color: 'oklch(70.2% 0.183 293.541 / .8)' }
            ],
            coverUrl: '/YogurT/images/post-cover/cover-2.png',
            date: '2022-02-28',
            readCount: 645,
            likeCount: 43,
            commentCount: 6,
            readTime: 12
          }
        ]
        break
      case '生活':
        categoryPosts.value = [
          {
            id: '1004',
            title: '我的健身日常',
            description: '坚持健身100天，身体变化惊人',
            category: '生活',
            tags: [{ name: '健身', color: 'oklch(73% 0.17 120)' }],
            coverUrl: '/YogurT/images/post-cover/cover-4.jpg',
            date: '2025-03-01',
            readCount: 2100,
            likeCount: 156,
            commentCount: 34,
            readTime: 5
          },
        ]
        break
      case '学习':
        categoryPosts.value = [
          {
            id: '1005',
            title: '如何高效记笔记',
            description: '康奈尔笔记法+数字化工具分享',
            category: '学习',
            tags: [{ name: '学习笔记', color: 'oklch(68% 0.14 200)' }],
            coverUrl: '/YogurT/images/post-cover/cover-6.png',
            date: '2025-01-15',
            readCount: 1500,
            likeCount: 112,
            commentCount: 27,
            readTime: 9
          },
          {
            id: '1006',
            title: '考研复习计划',
            description: '三个月冲刺985，时间安排与心态调整',
            category: '学习',
            tags: [{ name: '学习笔记', color: 'oklch(68% 0.14 200)' }],
            coverUrl: '/YogurT/images/post-cover/cover-4.jpg',
            date: '2024-12-20',
            readCount: 3200,
            likeCount: 210,
            commentCount: 45,
            readTime: 12
          }
        ]
        break
      case '旅行':
        categoryPosts.value = [
          {
            id: '1007',
            title: '云南旅行攻略',
            description: '大理丽江七日游，预算与景点推荐',
            category: '旅行',
            tags: [{ name: '旅行摄影', color: 'oklch(72% 0.12 240)' }],
            coverUrl: '/YogurT/images/post-cover/cover-3.jpg',
            date: '2025-02-05',
            readCount: 1800,
            likeCount: 134,
            commentCount: 29,
            readTime: 8
          }
        ]
        break
      case '胡说八道':
        categoryPosts.value = [
          {
            id: 3001,
            title: '关于我头发掉光了这档子事',
            description: '不小心把脱毛膏当成洗发水了...',
            category: '胡说八道',
            tags: [{ name: '植发', color: 'oklch(70.7% 0.165 254.624 / .8)' }],
            coverUrl: '/YogurT/images/post-cover/cover-3.jpg',
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
            coverUrl: '/YogurT/images/post-cover/cover-4.jpg',
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
            coverUrl: '/YogurT/images/post-cover/cover-5.jpg',
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
            coverUrl: '/YogurT/images/post-cover/cover-6.png',
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