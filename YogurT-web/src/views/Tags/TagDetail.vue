<template>
  <div class="space-y-2 md:space-y-4">
    <SidebarContainer>
      <template #sticky>
        <TagsSidebar :currentTag="currentTag" />
      </template>
    </SidebarContainer>

    <InfoBar :title="currentTag ? `标签 / ${currentTag.name}` : ''"
             :description="tagPosts?.length ? `共 ${tagPosts?.length} 篇文章` : ''"
    />

    <CardGrid :items="tagPosts" v-slot="{ item }" class="grid-cols-1 md:grid-cols-2 lg:grid-cols-1">
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
import TagsSidebar from '@/components/Sidebar/TagsSidebar.vue'
import InfoBar from '@/components/Base/InfoBar.vue'
import PostCard from '@/components/Post/PostCard.vue'
import CardGrid from '@/components/Base/CardGrid.vue'
import { onMounted, ref, toRefs, watch, watchEffect } from 'vue'
import { useResponsiveProps } from '@/composables/useResponsiveProps.js'

const props = defineProps({
  tagName: { type: String }
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

const { tagName } = toRefs(props)
const tags = ref(null)
const tagPosts = ref(null)
const currentTag = ref(null)

onMounted(() => {
  setTimeout(() => {
    tags.value = [
      { id: '1001', name: 'Java', postsCount: 2, color: 'oklch(70.4% 0.191 22.216)' },
      { id: '1002', name: 'Python', postsCount: 14, color: 'oklch(75% 0.18 145)' },
      { id: '1003', name: 'JavaScript', postsCount: 10, color: 'oklch(80% 0.15 85)' },
      { id: '1004', name: '旅行摄影', postsCount: 7, color: 'oklch(72% 0.12 240)' },
      { id: '1005', name: '美食探店', postsCount: 8, color: 'oklch(78% 0.2 40)' },
      { id: '1006', name: '学习笔记', postsCount: 3, color: 'oklch(68% 0.14 200)' },
      { id: '1007', name: '健身', postsCount: 1, color: 'oklch(73% 0.17 120)' },
      { id: '1008', name: '阅读', postsCount: 21, color: 'oklch(76% 0.13 280)' },
      { id: '1009', name: '科技', postsCount: 22, color: 'oklch(69% 0.16 300)' },
      { id: '1010', name: '心情', postsCount: 6, color: 'oklch(82% 0.1 30)' },
      { id: '1012', name: 'Vue', postsCount: 9, color: 'oklch(79.2% 0.209 151.711 / .8)' },
      { id: '1013', name: '植发', postsCount: 12, color: 'oklch(70.7% 0.165 254.624 / .8)' },
      { id: '1014', name: 'Spring', postsCount: 5, color: 'oklch(79.2% 0.209 151.711 / .8)' }
    ]
  }, 500)
})

watchEffect(() => {
  if (tags.value === null)
    return

  const foundTag = tags.value.find(item => item.name === tagName.value);
  currentTag.value = foundTag || {}; // 未找到时设为空对象
})

// 当前分类变化时，获取此分类下的文章数据
watch(currentTag, (newTag) => {
  tagPosts.value = null
  if (newTag === null)
    return

  setTimeout(() => {
    switch (newTag.name) {
      case 'Java':
        tagPosts.value = [
          {
            id: '1001',
            title: '喝杯 Java',
            description: '80 一杯',
            category: '技术',
            tags: [
              { name: 'Java', color: 'oklch(70.4% 0.191 22.216 / .8)' }
            ],
            coverUrl: '/images/post-cover/cover-1.png',
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
            coverUrl: '/images/post-cover/cover-1.png',
            date: '2024-03-22',
            readCount: 1234,
            likeCount: 89,
            commentCount: 23,
            readTime: 8
          },
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
          }
        ]
        break
      case 'Vue':
        tagPosts.value = [
          {
            id: '1003',
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
      case 'JavaScript':
        tagPosts.value = [
          {
            id: '1003',
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
      case '健身':
        tagPosts.value = [
          {
            id: '1004',
            title: '我的健身日常',
            description: '坚持健身100天，身体变化惊人',
            category: '生活',
            tags: [{ name: '健身', color: 'oklch(73% 0.17 120)' }],
            coverUrl: '/images/post-cover/cover-4.jpg',
            date: '2025-03-01',
            readCount: 2100,
            likeCount: 156,
            commentCount: 34,
            readTime: 5
          }
        ]
        break
      case '学习笔记':
        tagPosts.value = [
          {
            id: '1005',
            title: '如何高效记笔记',
            description: '康奈尔笔记法+数字化工具分享',
            category: '学习',
            tags: [{ name: '学习笔记', color: 'oklch(68% 0.14 200)' }],
            coverUrl: '/images/post-cover/cover-6.png',
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
            coverUrl: '/images/post-cover/cover-4.jpg',
            date: '2024-12-20',
            readCount: 3200,
            likeCount: 210,
            commentCount: 45,
            readTime: 12
          }
        ]
        break
      case '旅行摄影':
        tagPosts.value = [
          {
            id: '1007',
            title: '云南旅行攻略',
            description: '大理丽江七日游，预算与景点推荐',
            category: '旅行',
            tags: [{ name: '旅行摄影', color: 'oklch(72% 0.12 240)' }],
            coverUrl: '/images/post-cover/cover-3.jpg',
            date: '2025-02-05',
            readCount: 1800,
            likeCount: 134,
            commentCount: 29,
            readTime: 8
          }
        ]
        break
      case '植发':
        tagPosts.value = [
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
      case 'Spring':
        tagPosts.value = [
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
          }
        ]
        break
      default:
        tagPosts.value = []
    }
  }, 500)
}, { immediate: true })
</script>


<style scoped>

</style>