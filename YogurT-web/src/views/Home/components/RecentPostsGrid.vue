<template>
  <div class="grid gap-2 md:gap-4 grid-cols-1 md:grid-cols-2 lg:grid-cols-2">
    <PostCard v-for="post in recentPosts" :key="post.id" :post="post"
              class="h-75 md:h-80 lg:h-85 xl:h-100"
              :layout="postCardProps.layout"
              :coverRatio="postCardProps.coverRatio"
              :contentRatio="postCardProps.contentRatio"
              :descriptionLineCount="postCardProps.descriptionLineCount"
              :enableReadTime="postCardProps.enableReadTime"
              :enableReadCount="postCardProps.enableReadCount"
              :enableLikeCount="postCardProps.enableLikeCount"
              :enableCommentCount="postCardProps.enableCommentCount"
    />
  </div>
</template>

<script setup>
import PostCard from '@/components/Business/Post/PostCard.vue'
import { onMounted, ref } from 'vue'
import { useResponsiveProps } from '@/composables/useResponsiveProps.js'

const postCardProps = useResponsiveProps({
  'xs': {
    layout: 'vertical',
    coverRatio: 55,
    contentRatio: 45,
    descriptionLineCount: 1,
    enableReadTime: true,
    enableReadCount: true,
    enableLikeCount: false,
    enableCommentCount: false
  },
  'lg': {
    layout: 'vertical',
    coverRatio: 55,
    contentRatio: 45,
    descriptionLineCount: 2,
    enableReadTime: true,
    enableReadCount: true,
    enableLikeCount: false,
    enableCommentCount: false
  },
  'xl': {
    layout: 'vertical',
    coverRatio: 55,
    contentRatio: 45,
    descriptionLineCount: 3,
    enableReadTime: true,
    enableReadCount: true,
    enableLikeCount: true,
    enableCommentCount: true
  }
})

const recentPosts = ref(null)

onMounted(() => {
  recentPosts.value = [
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
      coverUrl: '/images/post-cover/cover-2.png',
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
      coverUrl: '/images/post-cover/cover-3.jpg',
      date: '2022-02-28',
      readCount: 645,
      likeCount: 43,
      commentCount: 6,
      readTime: 12
    },
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
    },
    {
      id: '1005',
      title: '如何高效记笔记',
      description: '康奈尔笔记法+数字化工具分享',
      category: '学习',
      tags: [{ name: '学习笔记', color: 'oklch(68% 0.14 200)' }],
      coverUrl: '/images/post-cover/cover-5.jpg',
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
      coverUrl: '/images/post-cover/cover-6.png',
      date: '2024-12-20',
      readCount: 3200,
      likeCount: 210,
      commentCount: 45,
      readTime: 12
    },
    {
      id: '1007',
      title: '云南旅行攻略',
      description: '大理丽江七日游，预算与景点推荐',
      category: '旅行',
      tags: [{ name: '旅行摄影', color: 'oklch(72% 0.12 240)' }],
      coverUrl: '/images/post-cover/cover-7.jpg',
      date: '2025-02-05',
      readCount: 1800,
      likeCount: 134,
      commentCount: 29,
      readTime: 8
    },
    {
      id: 3001,
      title: '关于我头发掉光了这档子事',
      description: '不小心把脱毛膏当成洗发水了...',
      category: '胡说八道',
      tags: [{ name: '植发', color: 'oklch(70.7% 0.165 254.624 / .8)' }],
      coverUrl: '/images/post-cover/cover-8.png',
      date: '2024-12-04',
      readCount: 444,
      likeCount: 33,
      commentCount: 11,
      readTime: 4
    },
    {
      id: 4001,
      title: 'Java 从入门到放弃',
      description: '',
      category: '开发',
      tags: [
        { name: 'Java', color: 'oklch(70.4% 0.191 22.216 / .8)' }
      ],
      coverUrl: '/images/post-cover/cover-9.jpg',
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
      coverUrl: '/images/post-cover/cover-10.jpg',
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
      coverUrl: '/images/post-cover/cover-11.jpg',
      date: '2024-05-28',
      readCount: 643,
      likeCount: 123,
      commentCount: 0,
      readTime: 22
    }
  ]
})
</script>

<style scoped>

</style>