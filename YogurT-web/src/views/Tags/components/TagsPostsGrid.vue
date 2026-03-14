<template>
  <div class="grid gap-2 md:gap-4 grid-cols-1 md:grid-cols-2 lg:grid-cols-1">
    <PostCard v-for="post in tagPosts" :key="post.id" :post="post"
              class="h-82 lg:h-62"
              :layout="postCardProps.layout"
              :coverRatio="postCardProps.coverRatio"
              :contentRatio="postCardProps.contentRatio"
              :descriptionLineCount="postCardProps.descriptionLineCount"
              :enableLikeCount="postCardProps.enableLikeCount"
              :enableCommentCount="postCardProps.enableCommentCount"
    />
  </div>
</template>

<script setup>
import PostCard from '@/components/Business/Post/PostCard.vue'
import { useResponsiveProps } from '@/composables/useResponsiveProps.js'

const props = defineProps({
  tagPosts: { type: Array }
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
</script>

<style scoped>

</style>