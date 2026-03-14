<template>
  <div>
    <ArchivesBanner />

    <SidebarContainer>
      <CategoriesSidebar />
      <TagsSidebar />
    </SidebarContainer>

    <div class="panel px-4 lg:px-12">
      <YearArchive :posts="posts" />
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import YearArchive from '@/views/Archives/components/YearArchive.vue'
import ArchivesBanner from '@/views/Archives/ArchivesBanner.vue'
import SidebarContainer from '@/components/Section/SidebarContainer.vue'
import CategoriesSidebar from '@/components/Sidebar/CategoriesSidebar.vue'
import TagsSidebar from '@/components/Sidebar/TagsSidebar.vue'

const posts = ref([
  {
    id: '1005',
    title: 'Vue 从入门到放弃',
    publishDate: '2026-02-19',
    author: '云桥雾',
    category: '前端',
    tags: [{ name: 'Vue', color: 'oklch(79.2% 0.209 151.711)' }, { name: 'JavaScript', color: 'oklch(75% 0.183 55.934)' }]
  },
  {
    id: '1004',
    title: 'Java 从入门到放弃',
    publishDate: '2026-02-15',
    author: '云桥雾',
    category: '后端',
    tags: [{ name: 'Java', color: 'oklch(70.4% 0.191 22.216)' }]
  },
  {
    id: '1003',
    title: 'Linux 从入门到放弃',
    publishDate: '2026-02-05',
    author: '云桥雾',
    category: '操作系统',
    tags: [{ name: 'Linux', color: 'oklch(78.9% 0.154 211.53)' }]
  },
  {
    id: '1002',
    title: 'Docker 从入门到放弃',
    publishDate: '2025-05-10',
    author: '云桥雾',
    category: '容器',
    tags: [{ name: 'Docker', color: 'oklch(70.7% 0.165 254.624)' }]
  },
  {
    id: '1001',
    title: 'Spring 从入门到放弃',
    publishDate: '2024-12-07',
    author: '云桥雾',
    category: '后端',
    tags: [{ name: 'Spring', color: 'oklch(79.2% 0.209 151.711)' }, { name: 'Java', color: 'oklch(70.4% 0.191 22.216)' }]
  },
  {
    id: '1000',
    title: 'JavaScript 从入门到放弃',
    publishDate: '2024-05-12',
    author: '云桥雾',
    category: '前端',
    tags: [{ name: 'JavaScript', color: 'oklch(75% 0.183 55.934)' }, { name: 'TypeScript', color: 'oklch(75% 0.183 55.934)' }]
  }
]);
</script>

<style scoped>

</style>