<template>
  <div class="space-y-2 md:space-y-4">
    <div class="grid grid-cols-1 lg:grid-cols-2 gap-2 md:gap-4">
      <SiteInfo />

      <AboutLinks />
    </div>

    <InfoBar title="友链" :description="links?.length ? `共 ${links?.length} 个站点` : ''"/>

    <ul class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-2 md:gap-4">
      <li v-for="link in links" :key="link.id">
        <FriendSiteCard :id="link.id" :name="link.name" :description="link.description" :siteUrl="link.siteUrl" :avatarUrl="link.avatarUrl" :types="link.types" :status="link.status" />
      </li>
    </ul>
  </div>
</template>

<script setup>
import SiteInfo from '@/views/Links/components/SiteInfo.vue'
import AboutLinks from '@/views/Links/components/AboutLinks.vue'
import InfoBar from '@/components/Base/InfoBar.vue'
import FriendSiteCard from '@/components/Business/Link/FriendSiteCard.vue'
import { onMounted, ref } from 'vue'

const links = ref(null)

// 随机重排数组
const shuffleArray = (arr) => {
  for (let i = arr.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1))
    const temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
  }
  return arr
}

onMounted(() => {
  setTimeout(() => {
    links.value = [
      {
        id: '1001',
        name: '前端技术栈',
        description: '分享前端开发经验',
        siteUrl: 'http://localhost:5173',
        avatarUrl: 'images/links-avatar/avatar-1.webp',
        email: 'fogsbridge@fogsbridge.com',
        types: ['技术', '设计'],
        status: 'online'
      },
      {
        id: '1002',
        name: '后端那些事',
        description: 'Java, Python, Go 等相关技术',
        siteUrl: 'http://localhost:5173',
        avatarUrl: 'images/links-avatar/avatar-2.webp',
        email: 'fogsbridge@fogsbridge.com',
        types: ['技术'],
        status: 'online'
      },
      {
        id: '1003',
        name: '摄影日记',
        description: '记录光影瞬间',
        siteUrl: 'http://localhost:5173',
        avatarUrl: 'images/links-avatar/avatar-3.webp',
        email: 'fogsbridge@fogsbridge.com',
        types: ['摄影', '生活'],
        status: 'offline'
      },
      {
        id: '1004',
        name: '旅行者笔记',
        description: '世界那么大，我想去看看',
        siteUrl: 'http://localhost:5173',
        avatarUrl: 'images/links-avatar/avatar-4.webp',
        email: 'fogsbridge@fogsbridge.com',
        types: ['生活'],
        status: 'offline'
      },
      {
        id: '1005',
        name: '机器学习实验室',
        description: 'AI/ML 学习心得与实践',
        siteUrl: 'http://localhost:5173',
        avatarUrl: 'images/links-avatar/avatar-5.jpg',
        email: 'fogsbridge@fogsbridge.com',
        types: ['技术'],
        status: 'online'
      },
      {
        id: '1006',
        name: '读书与思考',
        description: '书评与随笔分享',
        siteUrl: 'http://localhost:5173',
        avatarUrl: 'images/links-avatar/avatar-6.webp',
        email: 'fogsbridge@fogsbridge.com',
        types: ['阅读'],
        status: 'offline'
      },
      {
        id: '1007',
        name: '设计小站',
        description: 'UI/UX 设计经验谈',
        siteUrl: 'http://localhost:5173',
        avatarUrl: 'images/links-avatar/avatar-7.webp',
        email: 'fogsbridge@fogsbridge.com',
        types: ['设计'],
        status: 'online'
      },
      {
        id: '1008',
        name: '美食生活',
        description: '烹饪与美食探索',
        siteUrl: 'http://localhost:5173',
        avatarUrl: 'images/links-avatar/avatar-8.jpg',
        email: 'fogsbridge@fogsbridge.com',
        types: ['生活'],
        status: 'online'
      }
    ]

    shuffleArray(links.value)
  }, 300)
})
</script>

<style scoped>

</style>