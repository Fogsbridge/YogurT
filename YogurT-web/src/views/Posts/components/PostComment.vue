<template>
  <div class="panel px-4 pt-2 pb-4 md:px-10 md:py-8 space-y-2 md:space-y-6">
    <div class="flex flex-row items-center gap-1.5 md:gap-2">
      <svg class="size-5 md:size-6" fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
        <path d="M4.913 2.658c2.075-.27 4.19-.408 6.337-.408 2.147 0 4.262.139 6.337.408 1.922.25 3.291 1.861 3.405 3.727a4.403 4.403 0 0 0-1.032-.211 50.89 50.89 0 0 0-8.42 0c-2.358.196-4.04 2.19-4.04 4.434v4.286a4.47 4.47 0 0 0 2.433 3.984L7.28 21.53A.75.75 0 0 1 6 21v-4.03a48.527 48.527 0 0 1-1.087-.128C2.905 16.58 1.5 14.833 1.5 12.862V6.638c0-1.97 1.405-3.718 3.413-3.979Z"></path>
        <path d="M15.75 7.5c-1.376 0-2.739.057-4.086.169C10.124 7.797 9 9.103 9 10.609v4.285c0 1.507 1.128 2.814 2.67 2.94 1.243.102 2.5.157 3.768.165l2.782 2.781a.75.75 0 0 0 1.28-.53v-2.39l.33-.026c1.542-.125 2.67-1.433 2.67-2.94v-4.286c0-1.505-1.125-2.811-2.664-2.94A49.392 49.392 0 0 0 15.75 7.5Z"></path>
      </svg>
      <span class="text-lg md:text-xl font-bold">发表评论</span>
    </div>

    <CommentForm targetType="post" :targetId="postId" variant="subtle" />

    <div class="flex flex-row items-center gap-1.5 md:gap-2 mt-6 md:mt-12">
      <svg class="size-5 md:size-6" fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
        <path d="M4.913 2.658c2.075-.27 4.19-.408 6.337-.408 2.147 0 4.262.139 6.337.408 1.922.25 3.291 1.861 3.405 3.727a4.403 4.403 0 0 0-1.032-.211 50.89 50.89 0 0 0-8.42 0c-2.358.196-4.04 2.19-4.04 4.434v4.286a4.47 4.47 0 0 0 2.433 3.984L7.28 21.53A.75.75 0 0 1 6 21v-4.03a48.527 48.527 0 0 1-1.087-.128C2.905 16.58 1.5 14.833 1.5 12.862V6.638c0-1.97 1.405-3.718 3.413-3.979Z"></path>
        <path d="M15.75 7.5c-1.376 0-2.739.057-4.086.169C10.124 7.797 9 9.103 9 10.609v4.285c0 1.507 1.128 2.814 2.67 2.94 1.243.102 2.5.157 3.768.165l2.782 2.781a.75.75 0 0 0 1.28-.53v-2.39l.33-.026c1.542-.125 2.67-1.433 2.67-2.94v-4.286c0-1.505-1.125-2.811-2.664-2.94A49.392 49.392 0 0 0 15.75 7.5Z"></path>
      </svg>
      <span class="text-lg md:text-xl font-bold">评论区</span>
      <span class="ml-1 md:self-end text-sm md:text-base text-base-content/60">
        {{ totalComments }}
        <span class="text-xs md:text-sm text-base-content/60">条评论</span>
      </span>
    </div>

    <CommentList targetType="post" :targetId="postId" />
  </div>
</template>

<script setup>
import CommentForm from '@/components/Business/Comment/CommentForm.vue'
import CommentList from '@/components/Business/Comment/CommentList.vue'
import { onMounted, ref } from 'vue'

const props = defineProps({
  postId: { type: String, required: true }
})

const totalComments = ref(null)

onMounted(() => {
  totalComments.value = 15
})
</script>

<style scoped>

</style>