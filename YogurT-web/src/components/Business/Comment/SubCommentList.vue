<template>
  <ol class="mt-4 md:mt-6 mb-1 md:mb-2 space-y-4 md:space-y-6 ml-1 border-l-2 border-dashed border-base-content/5 dark:border-base-content/10">
    <li v-for="c in subComments" :key="c.commentId" class="px-4 md:px-7" >
      <div class="flex flex-row items-center gap-2 md:gap-2">
        <img class="size-6 md:size-9 rounded-full ring-1 ring-base-content/40" :src="c.avatarUrl" :alt="c.name" />

        <div class="flex-1">
          <div class="text-xs md:text-sm">
            <span>{{ c.name }}</span>
            <span class="mx-1 text-base-content/50">回复</span>
            <a class="text-primary/80 hover:text-primary" :href="c.replyToUser.site" target="_blank">@{{ c.replyToUser.name }}</a>
          </div>
          <div class="mt-px md:mt-0.5 text-2xs text-base-content/70">{{ formatDate(c.createTime) }}</div>
        </div>
      </div>

      <p class="mt-1.5 md:mt-3 text-xs md:text-sm">{{ c.content }}</p>

      <div class="mt-1.5 md:mt-3 flex flex-row md:items-center justify-between">
        <div class="flex flex-col-reverse md:flex-row gap-1 md:gap-3.5 text-2xs md:text-xs text-base-content/55">
          <div>
            <div class="flex flex-row items-center gap-0.5 text-nowrap">
              <svg class="size-3 md:size-3" fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                <path clip-rule="evenodd" fill-rule="evenodd" d="m11.54 22.351.07.04.028.016a.76.76 0 0 0 .723 0l.028-.015.071-.041a16.975 16.975 0 0 0 1.144-.742 19.58 19.58 0 0 0 2.683-2.282c1.944-1.99 3.963-4.98 3.963-8.827a8.25 8.25 0 0 0-16.5 0c0 3.846 2.02 6.837 3.963 8.827a19.58 19.58 0 0 0 2.682 2.282 16.975 16.975 0 0 0 1.145.742ZM12 13.5a3 3 0 1 0 0-6 3 3 0 0 0 0 6Z"></path>
              </svg>
              <span class="h-3 md:h-3 leading-3 md:leading-3">
                {{ c.ipLocation }}
              </span>
            </div>
          </div>

          <div class="flex flex-row gap-2.5 md:gap-3.5">
            <div class="flex flex-row items-center gap-0.5 text-nowrap">
              <svg class="size-3 md:size-3" fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                <path clip-rule="evenodd" fill-rule="evenodd" d="M2.25 6a3 3 0 0 1 3-3h13.5a3 3 0 0 1 3 3v12a3 3 0 0 1-3 3H5.25a3 3 0 0 1-3-3V6Zm18 3H3.75v9a1.5 1.5 0 0 0 1.5 1.5h13.5a1.5 1.5 0 0 0 1.5-1.5V9Zm-15-3.75A.75.75 0 0 0 4.5 6v.008c0 .414.336.75.75.75h.008a.75.75 0 0 0 .75-.75V6a.75.75 0 0 0-.75-.75H5.25Zm1.5.75a.75.75 0 0 1 .75-.75h.008a.75.75 0 0 1 .75.75v.008a.75.75 0 0 1-.75.75H7.5a.75.75 0 0 1-.75-.75V6Zm3-.75A.75.75 0 0 0 9 6v.008c0 .414.336.75.75.75h.008a.75.75 0 0 0 .75-.75V6a.75.75 0 0 0-.75-.75H9.75Z"></path>
              </svg>
              <span class="h-3 md:h-3 leading-3 md:leading-3">
              {{ c.os }}
            </span>
            </div>

            <div class="flex flex-row items-center gap-0.5 text-nowrap">
              <svg class="size-3 md:size-3" fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                <path d="M21.721 12.752a9.711 9.711 0 0 0-.945-5.003 12.754 12.754 0 0 1-4.339 2.708 18.991 18.991 0 0 1-.214 4.772 17.165 17.165 0 0 0 5.498-2.477ZM14.634 15.55a17.324 17.324 0 0 0 .332-4.647c-.952.227-1.945.347-2.966.347-1.021 0-2.014-.12-2.966-.347a17.515 17.515 0 0 0 .332 4.647 17.385 17.385 0 0 0 5.268 0ZM9.772 17.119a18.963 18.963 0 0 0 4.456 0A17.182 17.182 0 0 1 12 21.724a17.18 17.18 0 0 1-2.228-4.605ZM7.777 15.23a18.87 18.87 0 0 1-.214-4.774 12.753 12.753 0 0 1-4.34-2.708 9.711 9.711 0 0 0-.944 5.004 17.165 17.165 0 0 0 5.498 2.477ZM21.356 14.752a9.765 9.765 0 0 1-7.478 6.817 18.64 18.64 0 0 0 1.988-4.718 18.627 18.627 0 0 0 5.49-2.098ZM2.644 14.752c1.682.971 3.53 1.688 5.49 2.099a18.64 18.64 0 0 0 1.988 4.718 9.765 9.765 0 0 1-7.478-6.816ZM13.878 2.43a9.755 9.755 0 0 1 6.116 3.986 11.267 11.267 0 0 1-3.746 2.504 18.63 18.63 0 0 0-2.37-6.49ZM12 2.276a17.152 17.152 0 0 1 2.805 7.121c-.897.23-1.837.353-2.805.353-.968 0-1.908-.122-2.805-.353A17.151 17.151 0 0 1 12 2.276ZM10.122 2.43a18.629 18.629 0 0 0-2.37 6.49 11.266 11.266 0 0 1-3.746-2.504 9.754 9.754 0 0 1 6.116-3.985Z"></path>
              </svg>
              <span class="h-3 md:h-3 leading-3 md:leading-3">
              {{ c.browser }}
            </span>
            </div>

          </div>
        </div>

        <div class="self-end flex flex-row items-center gap-5 md:gap-6 text-xs md:text-xs text-base-content/70">
          <button class="flex flex-row items-center gap-1 text-nowrap group hover:text-red-400 hover:scale-115 duration-200">
            <svg class="size-3.5 group-hover:stroke-2" fill="none" stroke-width="1.5" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" d="M21 8.25c0-2.485-2.099-4.5-4.688-4.5-1.935 0-3.597 1.126-4.312 2.733-.715-1.607-2.377-2.733-4.313-2.733C5.1 3.75 3 5.765 3 8.25c0 7.22 9 12 9 12s9-4.78 9-12Z"></path>
            </svg>
            <span v-if="c.totalLike && c.totalLike !== 0" class="h-3.5 leading-3.5">
              {{ c.totalLike }}
            </span>
          </button>

          <button class="text-nowrap group hover:text-blue-400 hover:scale-115 duration-200"
                  @click.stop="updateActiveCommentId(activeCommentId === c.commentId ? null : c.commentId)"
          >
            <svg class="size-3.5 group-hover:stroke-2" fill="none" stroke-width="1.5" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" d="M8.625 9.75a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0H8.25m4.125 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0H12m4.125 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0h-.375m-13.5 3.01c0 1.6 1.123 2.994 2.707 3.227 1.087.16 2.185.283 3.293.369V21l4.184-4.183a1.14 1.14 0 0 1 .778-.332 48.294 48.294 0 0 0 5.83-.498c1.585-.233 2.708-1.626 2.708-3.228V6.741c0-1.602-1.123-2.995-2.707-3.228A48.394 48.394 0 0 0 12 3c-2.392 0-4.744.175-7.043.513C3.373 3.746 2.25 5.14 2.25 6.741v6.018Z"></path>
            </svg>
          </button>
        </div>
      </div>

      <CommentForm :show="activeCommentId === c.commentId" @close="activeCommentId = null" class="mt-3 md:mt-5" :targetId="c.postId" targetType="comment" :parentId="c.parentId" />
    </li>
  </ol>
</template>

<script setup>
import CommentForm from '@/components/Business/Comment/CommentForm.vue'
import { onMounted, ref, inject } from 'vue'

const props = defineProps({
  targetType: {type: String, required:true, validator: v => ['post', 'guestbook'].includes(v) },
  targetId: { type: String, required: true }
})

const { activeCommentId, updateActiveCommentId } = inject('activeCommentId')

const subComments = ref(null)

const formatDate = (dateStr) => new Date(dateStr).toISOString().split("T")[0]

onMounted(() => {
  subComments.value = [
    {
      postId: '1001',
      commentId: '1011',
      name: '码农阿飞',
      avatarUrl: '/images/avatar-2.jpg',
      content: '关于并发处理的 Actor 模型解释得非常清晰，结合 Rust 的 tokio 讲解就更好了。期待作者更多实践分享！',
      imageUrls: ['/images/comment-img-1.jpg'],
      createTime: '2025-01-10 10:23:11',
      ipLocation: '北京',
      os: 'macOS 14.2',
      browser: 'Chrome 120.0',
      totalLike: 280,
      totalReply: 3,
      replyToUser: { id: '1001', name: '不吃香菜', site: 'http://127.0.0.1:5173' },
      parentId: null
    },
    {
      postId: '1001',
      commentId: '2001',
      name: 'Rustacean',
      avatarUrl: '/images/avatar-2.jpg',
      content: '确实，如果用 tokio 的 example 来对比就更直观了，期待作者续篇。另外请教一下，Actor 模型在游戏服务器中常见吗？',
      imageUrls: [],
      createTime: '2025-01-10 11:10:05',
      ipLocation: '上海',
      os: 'Windows 11',
      browser: 'Chrome 120.0',
      totalLike: 12,
      totalReply: 0,
      replyToUser: { id: '1001', name: '不吃香菜', site: 'http://127.0.0.1:5173' },
      parentId: '1001'
    },
    {
      postId: '1001',
      commentId: '2002',
      name: '并发爱好者',
      avatarUrl: '/images/avatar-3.jpg',
      content: 'Actor 模型和 CSP 模型对比分析很到位，受益匪浅！特别是信箱调度那块让我恍然大悟。',
      imageUrls: [],
      createTime: '2025-01-10 13:05:40',
      ipLocation: '广州',
      os: 'macOS 14.2',
      browser: 'Safari 17.1',
      totalLike: 8,
      totalReply: 1,
      replyToUser: { id: '1001', name: '不吃香菜', site: 'http://127.0.0.1:5173' },
      parentId: '1001'
    },
    {
      postId: '1001',
      commentId: '3001',
      name: 'Gopher',
      avatarUrl: '/images/avatar-4.jpg',
      content: '补充一下，Go 语言中的 goroutine 也是 CSP 风格的，可以对比着学习。两者各有千秋，适合不同场景。',
      imageUrls: [],
      createTime: '2025-01-10 14:20:18',
      ipLocation: '成都',
      os: 'Linux (Ubuntu 22.04)',
      browser: 'Firefox 115.0',
      totalLike: 3,
      totalReply: 0,
      replyToUser: { id: '1001', name: '不吃香菜', site: 'http://127.0.0.1:5173' },
      parentId: '2002'
    }
  ]
})
</script>

<style scoped>

</style>