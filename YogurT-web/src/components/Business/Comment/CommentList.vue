<template>
  <ol class="space-y-3 md:space-y-5">
    <li v-for="c in comments" :key="c.commentId" class="px-3.5 py-3 md:px-8 md:py-6 border border-base-content/6 dark:border-base-content/12 bg-base-200/40 rounded-xl md:rounded-2xl" >
      <div class="flex flex-row items-center gap-2 md:gap-3">
        <img class="size-9 md:size-11 rounded-full ring-1 ring-base-content/40" :src="c.avatarUrl" :alt="c.name" />

        <div class="flex-1">
          <div class="text-sm md:text-base">{{ c.name }}</div>
          <div class="mt-1 text-2xs md:text-xs text-base-content/70">{{ formatDate(c.createTime) }}</div>
        </div>
      </div>

      <p class="mt-3 md:mt-5 text-sm md:text-base">{{ c.content }}</p>

      <div class="mt-3 md:mt-5 flex flex-row md:items-center justify-between">
        <div class="flex flex-col-reverse md:flex-row gap-2 md:gap-4 text-xs md:text-sm text-base-content/55">
          <div>
            <div class="flex flex-row items-center gap-0.5 text-nowrap">
              <svg class="size-3 md:size-4" fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                <path clip-rule="evenodd" fill-rule="evenodd" d="m11.54 22.351.07.04.028.016a.76.76 0 0 0 .723 0l.028-.015.071-.041a16.975 16.975 0 0 0 1.144-.742 19.58 19.58 0 0 0 2.683-2.282c1.944-1.99 3.963-4.98 3.963-8.827a8.25 8.25 0 0 0-16.5 0c0 3.846 2.02 6.837 3.963 8.827a19.58 19.58 0 0 0 2.682 2.282 16.975 16.975 0 0 0 1.145.742ZM12 13.5a3 3 0 1 0 0-6 3 3 0 0 0 0 6Z"></path>
              </svg>
              <span class="h-3 md:h-4 leading-3 md:leading-4">
              {{ c.ipLocation }}
            </span>
            </div>
          </div>

          <div class="flex flex-row gap-3 md:gap-4">
            <div class="flex flex-row items-center gap-0.5 text-nowrap">
              <svg class="size-3 md:size-4" fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                <path clip-rule="evenodd" fill-rule="evenodd" d="M2.25 6a3 3 0 0 1 3-3h13.5a3 3 0 0 1 3 3v12a3 3 0 0 1-3 3H5.25a3 3 0 0 1-3-3V6Zm18 3H3.75v9a1.5 1.5 0 0 0 1.5 1.5h13.5a1.5 1.5 0 0 0 1.5-1.5V9Zm-15-3.75A.75.75 0 0 0 4.5 6v.008c0 .414.336.75.75.75h.008a.75.75 0 0 0 .75-.75V6a.75.75 0 0 0-.75-.75H5.25Zm1.5.75a.75.75 0 0 1 .75-.75h.008a.75.75 0 0 1 .75.75v.008a.75.75 0 0 1-.75.75H7.5a.75.75 0 0 1-.75-.75V6Zm3-.75A.75.75 0 0 0 9 6v.008c0 .414.336.75.75.75h.008a.75.75 0 0 0 .75-.75V6a.75.75 0 0 0-.75-.75H9.75Z"></path>
              </svg>
              <span class="h-3 md:h-4 leading-3 md:leading-4">
              {{ c.os }}
            </span>
            </div>

            <div class="flex flex-row items-center gap-0.5 text-nowrap">
              <svg class="size-3 md:size-4" fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                <path d="M21.721 12.752a9.711 9.711 0 0 0-.945-5.003 12.754 12.754 0 0 1-4.339 2.708 18.991 18.991 0 0 1-.214 4.772 17.165 17.165 0 0 0 5.498-2.477ZM14.634 15.55a17.324 17.324 0 0 0 .332-4.647c-.952.227-1.945.347-2.966.347-1.021 0-2.014-.12-2.966-.347a17.515 17.515 0 0 0 .332 4.647 17.385 17.385 0 0 0 5.268 0ZM9.772 17.119a18.963 18.963 0 0 0 4.456 0A17.182 17.182 0 0 1 12 21.724a17.18 17.18 0 0 1-2.228-4.605ZM7.777 15.23a18.87 18.87 0 0 1-.214-4.774 12.753 12.753 0 0 1-4.34-2.708 9.711 9.711 0 0 0-.944 5.004 17.165 17.165 0 0 0 5.498 2.477ZM21.356 14.752a9.765 9.765 0 0 1-7.478 6.817 18.64 18.64 0 0 0 1.988-4.718 18.627 18.627 0 0 0 5.49-2.098ZM2.644 14.752c1.682.971 3.53 1.688 5.49 2.099a18.64 18.64 0 0 0 1.988 4.718 9.765 9.765 0 0 1-7.478-6.816ZM13.878 2.43a9.755 9.755 0 0 1 6.116 3.986 11.267 11.267 0 0 1-3.746 2.504 18.63 18.63 0 0 0-2.37-6.49ZM12 2.276a17.152 17.152 0 0 1 2.805 7.121c-.897.23-1.837.353-2.805.353-.968 0-1.908-.122-2.805-.353A17.151 17.151 0 0 1 12 2.276ZM10.122 2.43a18.629 18.629 0 0 0-2.37 6.49 11.266 11.266 0 0 1-3.746-2.504 9.754 9.754 0 0 1 6.116-3.985Z"></path>
              </svg>
              <span class="h-3 md:h-4 leading-3 md:leading-4">
              {{ c.browser }}
            </span>
            </div>
          </div>
        </div>

        <div class="self-end flex flex-row items-center gap-5 md:gap-6 text-xs md:text-sm text-base-content/70">
          <button class="flex flex-row items-center gap-1 text-nowrap group hover:text-red-400 hover:scale-115 duration-200">
            <svg class="size-4.5 group-hover:stroke-2" fill="none" stroke-width="1.5" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" d="M21 8.25c0-2.485-2.099-4.5-4.688-4.5-1.935 0-3.597 1.126-4.312 2.733-.715-1.607-2.377-2.733-4.313-2.733C5.1 3.75 3 5.765 3 8.25c0 7.22 9 12 9 12s9-4.78 9-12Z"></path>
            </svg>
            <span v-if="c.totalLike && c.totalLike !== 0" class="h-4.5 leading-4.5">
              {{ c.totalLike }}
            </span>
          </button>

          <button class="flex flex-row items-center gap-1 text-nowrap group hover:text-blue-400 hover:scale-115 duration-200"
               @click.stop="activeCommentId = activeCommentId === c.commentId ? null : c.commentId"
          >
            <svg class="size-4.5 group-hover:stroke-2" fill="none" stroke-width="1.5" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" d="M8.625 9.75a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0H8.25m4.125 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0H12m4.125 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0h-.375m-13.5 3.01c0 1.6 1.123 2.994 2.707 3.227 1.087.16 2.185.283 3.293.369V21l4.184-4.183a1.14 1.14 0 0 1 .778-.332 48.294 48.294 0 0 0 5.83-.498c1.585-.233 2.708-1.626 2.708-3.228V6.741c0-1.602-1.123-2.995-2.707-3.228A48.394 48.394 0 0 0 12 3c-2.392 0-4.744.175-7.043.513C3.373 3.746 2.25 5.14 2.25 6.741v6.018Z"></path>
            </svg>
            <span v-if="c.totalReply && c.totalReply !== 0" class="h-4.5 leading-4.5">
              {{ c.totalReply }}
            </span>
          </button>
        </div>
      </div>

      <CommentForm :show="activeCommentId === c.commentId" @close="activeCommentId = null" class="mt-3 md:mt-5" :targetId="c.postId" targetType="post" :parentId="c.commentId" variant="subComment" />

      <SubCommentList targetType="post" :targetId="c.postId" />
    </li>
  </ol>
</template>

<script setup>
import CommentForm from '@/components/Business/Comment/CommentForm.vue'
import SubCommentList from '@/components/Business/Comment/SubCommentList.vue'
import { onMounted, ref, provide } from 'vue'

const props = defineProps({
  targetType: {type: String, required:true, validator: v => ['post', 'guestbook'].includes(v) },
  targetId: { type: String, required: true }
})

const comments = ref(null)
const activeCommentId = ref(null)
const updateActiveCommentId = (id) => activeCommentId.value = id

provide('activeCommentId', { activeCommentId, updateActiveCommentId })

const formatDate = (dateStr) => new Date(dateStr).toISOString().split("T")[0]

onMounted(() => {
  comments.value = [
    {
      postId: '1001',
      commentId: '1001',
      name: '不吃香菜',
      avatarUrl: '/images/avatar-2.jpg',
      content: '这篇文章写得太好了！尤其是关于并发处理的部分，让我豁然开朗。',
      imageUrls: ['/images/comment-img-1.jpg'],
      createTime: '2025-01-04 15:43:44',
      ipLocation: '上海',
      os: 'Windows 11',
      browser: 'Edge 121.0',
      totalLike: 4200,
      totalReply: 3,
      replyToUser: null,
      parentId: null
    },
    {
      postId: '1001',
      commentId: '1002',
      name: '摸鱼办主任',
      avatarUrl: '/images/avatar-2.jpg',
      content: '确实，作者对锁的讲解也很透彻，学习了！',
      imageUrls: [],
      createTime: '2025-01-04 16:12:03',
      ipLocation: '北京',
      os: 'iOS 15.0',
      browser: 'Safari 15.0',
      totalLike: 0,
      totalReply: 0,
      replyToUser: 'guest1',
      parentId: '1001'
    },
    {
      postId: '1001',
      commentId: '1003',
      name: '尊嘟假嘟',
      avatarUrl: '/images/avatar-3.jpg',
      content: '有没有推荐的进一步阅读资料呀？',
      imageUrls: [],
      createTime: '2025-01-04 17:01:22',
      ipLocation: '广东',
      os: 'macOS 14.2',
      browser: 'Chrome 120.0',
      totalLike: 2,
      totalReply: 0,
      replyToUser: 'guest1',
      parentId: '1001'
    },
    {
      postId: '1001',
      commentId: '1004',
      name: '你算哪块小饼干',
      avatarUrl: '/images/avatar-2.jpg',
      content: '@lily 可以看《Java并发编程实战》第5章，很有帮助',
      imageUrls: [],
      createTime: '2025-01-04 18:30:15',
      ipLocation: '上海',
      os: 'Windows 11',
      browser: 'Edge 121.0',
      totalLike: 8,
      totalReply: 0,
      replyToUser: 'lily',
      parentId: '1001'
    },
    {
      postId: '1001',
      commentId: '1005',
      name: 'coder123',
      avatarUrl: '/images/avatar-3.jpg',
      content: 'markdown 排版真舒服，博主继续加油！',
      imageUrls: [],
      createTime: '2025-01-05 09:13:27',
      ipLocation: '美国',
      os: 'Ubuntu 22.04',
      browser: 'Firefox 121.0',
      totalLike: 3,
      totalReply: 0,
      replyToUser: null,
      parentId: null
    },
    {
      postId: '1001',
      commentId: '1006',
      name: '佛系随缘',
      avatarUrl: '/images/avatar-4.jpg',
      content: '配图很精美，请问是用什么工具画的？',
      imageUrls: ['/images/comment-img-2.jpg', '/images/comment-img-3.jpg'],
      createTime: '2025-01-05 11:20:44',
      ipLocation: '浙江',
      os: 'Windows 10',
      browser: 'Chrome 119.0',
      totalLike: 7,
      totalReply: 2,
      replyToUser: null,
      parentId: null
    },
    {
      postId: '1001',
      commentId: '1007',
      name: '碳水教父',
      avatarUrl: '/images/avatar-4.jpg',
      content: '用的 draw.io，免费又强大，推荐',
      imageUrls: [],
      createTime: '2025-01-05 12:05:33',
      ipLocation: '北京',
      os: 'macOS 13.5',
      browser: 'Safari 16.5',
      totalLike: 12,
      totalReply: 0,
      replyToUser: 'designer_wang',
      parentId: '1006'
    },
    {
      postId: '1001',
      commentId: '1008',
      name: 'newbie',
      avatarUrl: '/images/avatar-3.jpg',
      content: '谢谢博主，刚好需要画架构图',
      imageUrls: [],
      createTime: '2025-01-05 14:48:12',
      ipLocation: '四川',
      os: 'Android 13',
      browser: 'Chrome 120.0',
      totalLike: 1,
      totalReply: 0,
      replyToUser: 'blogger',
      parentId: '1006'
    },
    {
      postId: '1001',
      commentId: '1009',
      name: '输了一整晚',
      avatarUrl: '/images/avatar-2.jpg',
      content: '部分代码示例不够完整，新手可能看不懂，建议补充完整可运行的 demo。',
      imageUrls: [],
      createTime: '2025-01-06 08:30:19',
      ipLocation: '湖北',
      os: 'Windows 11',
      browser: 'Edge 120.0',
      totalLike: 15,
      totalReply: 1,
      replyToUser: null,
      parentId: null
    },
    {
      postId: '1001',
      commentId: '1010',
      name: '废物点心',
      avatarUrl: '/images/avatar-4.jpg',
      content: '感谢反馈！我会尽快补全示例代码，并放到 GitHub 仓库中。',
      imageUrls: [],
      createTime: '2025-01-06 09:47:56',
      ipLocation: '北京',
      os: 'macOS 14.1',
      browser: 'Chrome 120.0',
      totalLike: 20,
      totalReply: 0,
      replyToUser: 'reader99',
      parentId: '1009'
    },
    {
      postId: '1001',
      commentId: '1011',
      name: 'roaming_geek',
      avatarUrl: '/images/avatar-4.jpg',
      content: '非常实用的技术文章，已经收藏！期待下一篇关于微服务的。',
      imageUrls: [],
      createTime: '2025-01-07 21:05:33',
      ipLocation: '日本',
      os: 'Windows 10',
      browser: 'Firefox 121.0',
      totalLike: 4,
      totalReply: 0,
      replyToUser: null,
      parentId: null
    }
  ]
})
</script>

<style scoped>

</style>