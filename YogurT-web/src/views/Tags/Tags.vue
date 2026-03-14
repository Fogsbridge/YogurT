<template>
  <div class="space-y-2 md:space-y-4">
    <InfoBar title="标签云" :description="tags ? `共 ${tags.length} 个标签` : ''"/>

    <TagsFlex :tags="tags" />
  </div>
</template>

<script setup>
import InfoBar from '@/components/Base/InfoBar.vue'
import TagsFlex from '@/views/Tags/components/TagsFlex.vue'
import { onMounted, ref } from 'vue'

const tags = ref(null)

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
</script>

<style scoped>

</style>