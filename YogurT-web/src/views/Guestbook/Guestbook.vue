<template>
  <div class="space-y-2 md:space-y-4">
    <InfoBar title="留言" description="共 6 条留言" />

    <CommentForm targetType="guestbook" />

    <GuestbookEntryGrid :guestbookEntries="guestbookEntries" />
  </div>
</template>

<script setup>
import CommentForm from '@/components/Business/Comment/CommentForm.vue'
import InfoBar from '@/components/Base/InfoBar.vue'
import GuestbookEntryGrid from '@/views/Guestbook/components/GuestbookEntryGrid.vue'
import { onMounted, ref } from 'vue'

const guestbookEntries = ref(null)

onMounted(() => {
  guestbookEntries.value = [
    {
      id: '1001',
      name: '张小凡',
      content: '博主的文章太有用了，学到了很多 Tailwind 的技巧！',
      date: '2026-04-15',
      likeCount: 12
    },
    {
      id: '1002',
      name: '李思思',
      content: '留言板设计得好可爱，卡片风格超喜欢~',
      date: '2026-04-14',
      likeCount: 8
    },
    {
      id: '1003',
      name: '王小明',
      content: '请问这个博客主题是自己写的吗？前端功底很强！',
      date: '2026-04-12',
      likeCount: 5
    },
    {
      id: '1004',
      name: '陈小喵',
      content: '从知乎过来的，关注了，期待更多技术分享！',
      date: '2026-04-10',
      likeCount: 9
    },
    {
      id: '1005',
      name: '赵大勇',
      content: '留言板功能我也想加一个，这个便签墙思路真不错。',
      date: '2026-04-08',
      likeCount: 3
    },
    {
      id: '1006',
      name: '林静雅',
      content: '配色和排版都很舒服，读完心情都变好了。',
      date: '2026-04-05',
      likeCount: 15
    },
    {
      id: '1007',
      name: '周子衡',
      content: '大佬，能不能出一期关于 Vue 组合式 API 的教程？',
      date: '2026-04-01',
      likeCount: 7
    },
    {
      id: '1008',
      name: '吴迪',
      content: '干货满满，已三连！希望博主继续保持更新~',
      date: '2026-04-16',
      likeCount: 21
    },
    {
      id: '1009',
      name: '郑子琪',
      content: '这个留言板的交互设计给了我很多灵感，谢谢分享！',
      date: '2026-04-13',
      likeCount: 6
    },
    {
      id: '1010',
      name: '孙一凡',
      content: '刚接触前端，博主的文章通俗易懂，对我帮助很大。',
      date: '2026-04-11',
      likeCount: 4
    },
    {
      id: '1011',
      name: '宋佳怡',
      content: '能不能加一个回复功能？想和其他小伙伴交流~',
      date: '2026-04-09',
      likeCount: 11
    },
    {
      id: '1012',
      name: '唐雅昕',
      content: '背景和卡片的层次感做得真好，看着很舒服。',
      date: '2026-04-07',
      likeCount: 5
    },
    {
      id: '1013',
      name: '沈乐怡',
      content: '从 B 站来的，up 主的视频也很棒，加油！',
      date: '2026-04-06',
      likeCount: 14
    },
    {
      id: '1014',
      name: '彭子轩',
      content: '请问这个留言板是用的什么后端？Firebase 还是自己写的？',
      date: '2026-04-04',
      likeCount: 2
    },
    {
      id: '1015',
      name: '陆明远',
      content: '已收藏，会经常来逛逛的。',
      date: '2026-04-03',
      likeCount: 3
    },
    {
      id: '1016',
      name: '宁致远',
      content: '建议增加表情包功能，留言会更有趣哈哈',
      date: '2026-04-02',
      likeCount: 8
    },
    {
      id: '1017',
      name: '欧阳若曦',
      content: '代码写得很优雅，向你学习！',
      date: '2026-03-31',
      likeCount: 10
    }
  ]
})
</script>

<style scoped>

</style>