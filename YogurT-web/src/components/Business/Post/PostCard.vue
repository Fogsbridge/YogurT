<template>
  <div class="flex w-full panel overflow-clip group hover:border-primary hover:ring-1 hover:ring-primary/60 hover:cursor-pointer transition duration-300"
       :class="[
         layout === 'horizontal'
         ? enableReverse ? 'flex-row-reverse' : 'flex-row'
         : !enableReverse ? 'flex-col' : 'flex-col-reverse'
       ]"
       @click="router.push({ name: 'Posts', params: { postId: post.id } })"
  >
    <!-- 封面 -->
    <div class="min-w-0 min-h-0 basis-(--cover-ratio)"
         v-tw:--cover-ratio="`${coverRatio}%`"
    >
      <div v-if="post" class="relative overflow-clip">
        <img :src="post.coverUrl"
             class="w-full h-full object-cover group-hover:scale-115 duration-500 ease-in-out"
             alt="文章封面"
             loading="lazy"
        />
        <div class="absolute inset-0 dot-mask backdrop-brightness-90 dark:backdrop-brightness-80 transition duration-500"></div>
      </div>

      <!-- 封面骨架屏 -->
      <div v-else class="skeleton h-full w-full rounded-none">
        <div class="skeleton skeleton-text text-base-content/20 text-xl h-full flex justify-center items-center">加载中</div>
      </div>
    </div>

    <!-- 文章信息 -->
    <div class="min-w-0 min-h-0 basis-(--content-ratio)"
         v-tw:--content-ratio="`${contentRatio}%`"
    >
      <div v-if="post" class="w-full h-full py-4 px-6 flex flex-col gap-1 justify-between">
        <div>
          <div class="flex flex-row items-center text-sm gap-2">
            <CategoryButton class="px-2 flex-none" :categoryName="post.category" />
            <div class="flex items-center">
              <TagButton class="px-1" v-for="tag in post.tags.slice(0, 3)" :key="tag.name" :tag="tag" />
            </div>
          </div>

          <!-- 文章标题 -->
          <!-- 如果关闭描述，则标题占两行 -->
          <h3 class="text-lg text-base-content/85 dark:text-base-content/95 font-bold mt-1 group-hover:text-primary duration-300"
              :class="{ 'line-clamp-2': !enableDescription, 'truncate': enableDescription }"
          >
            {{ post.title }}
          </h3>
        </div>

        <!-- 文章描述 -->
        <p class="text-base-content/50 text-sm -mt-3 group-hover:text-primary/80 duration-300 line-clamp-(--description-line-count)"
           v-tw:--description-line-count="descriptionLineCount"
           v-if="enableDescription"
        >
          {{ post.description }}
        </p>

        <!-- 文章信息 -->
        <div class="flex items-center gap-3 text-base-content/60 text-sm font-bold group-hover:text-primary/80 duration-300">
          <!-- 日期 -->
          <div>
            <svg class="size-4 inline mb-0.5" fill="none" stroke-width="1.5" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" d="M6.75 3v2.25M17.25 3v2.25M3 18.75V7.5a2.25 2.25 0 0 1 2.25-2.25h13.5A2.25 2.25 0 0 1 21 7.5v11.25m-18 0A2.25 2.25 0 0 0 5.25 21h13.5A2.25 2.25 0 0 0 21 18.75m-18 0v-7.5A2.25 2.25 0 0 1 5.25 9h13.5A2.25 2.25 0 0 1 21 11.25v7.5m-9-6h.008v.008H12v-.008ZM12 15h.008v.008H12V15Zm0 2.25h.008v.008H12v-.008ZM9.75 15h.008v.008H9.75V15Zm0 2.25h.008v.008H9.75v-.008ZM7.5 15h.008v.008H7.5V15Zm0 2.25h.008v.008H7.5v-.008Zm6.75-4.5h.008v.008h-.008v-.008Zm0 2.25h.008v.008h-.008V15Zm0 2.25h.008v.008h-.008v-.008Zm2.25-4.5h.008v.008H16.5v-.008Zm0 2.25h.008v.008H16.5V15Z"></path>
            </svg>
            <span class="ml-1">{{ post.date }}</span>
          </div>

          <div class="flex-1"></div>

          <!-- 阅读时长 -->
          <div v-if="enableReadTime">
            <svg class="size-4 inline mb-0.5" fill="none" stroke-width="1.5" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" d="M12 6v6h4.5m4.5 0a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z"></path>
            </svg>
            <span class="ml-1">{{ post.readTime }}分钟</span>
          </div>

          <!-- 访问量 -->
          <div v-if="enableReadCount">
            <svg class="size-4 inline mb-0.5" fill="none" stroke-width="1.5" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" d="M2.036 12.322a1.012 1.012 0 0 1 0-.639C3.423 7.51 7.36 4.5 12 4.5c4.638 0 8.573 3.007 9.963 7.178.07.207.07.431 0 .639C20.577 16.49 16.64 19.5 12 19.5c-4.638 0-8.573-3.007-9.963-7.178Z"></path>
              <path stroke-linecap="round" stroke-linejoin="round" d="M15 12a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z"></path>
            </svg>
            <span class="ml-1">{{ post.readCount }}</span>
          </div>

          <!-- 点赞量 -->
          <div v-if="enableLikeCount">
            <svg class="size-4 inline mb-0.5" fill="none" stroke-width="1.5" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" d="M21 8.25c0-2.485-2.099-4.5-4.688-4.5-1.935 0-3.597 1.126-4.312 2.733-.715-1.607-2.377-2.733-4.313-2.733C5.1 3.75 3 5.765 3 8.25c0 7.22 9 12 9 12s9-4.78 9-12Z"></path>
            </svg>
            <span class="ml-1">{{ post.likeCount }}</span>
          </div>

          <!-- 评论量 -->
          <div v-if="enableCommentCount">
            <svg class="size-4 inline mb-0.5" fill="none" stroke-width="1.5" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" d="M8.625 9.75a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0H8.25m4.125 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0H12m4.125 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0h-.375m-13.5 3.01c0 1.6 1.123 2.994 2.707 3.227 1.087.16 2.185.283 3.293.369V21l4.184-4.183a1.14 1.14 0 0 1 .778-.332 48.294 48.294 0 0 0 5.83-.498c1.585-.233 2.708-1.626 2.708-3.228V6.741c0-1.602-1.123-2.995-2.707-3.228A48.394 48.394 0 0 0 12 3c-2.392 0-4.744.175-7.043.513C3.373 3.746 2.25 5.14 2.25 6.741v6.018Z"></path>
            </svg>
            <span class="ml-1">{{ post.commentCount }}</span>
          </div>
        </div>
      </div>

      <!-- 文章信息骨架屏 -->
      <div v-else class="w-full h-full rounded-none py-4 px-6 flex flex-col justify-between">
        <div class="skeleton rounded-xl h-1/4 w-3/4"></div>
        <div class="skeleton rounded-xl h-1/4 w-full"></div>
        <div class="flex flex-row gap-8 h-1/4">
          <div class="skeleton rounded-xl w-full"></div>
          <div class="skeleton rounded-xl w-full"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import CategoryButton from '@/components/Business/Category/CategoryButton.vue'
import TagButton from '@/components/Business/Tag/TagButton.vue'
import { useRouter } from 'vue-router'

const props = defineProps({
  post: { type: Object },
  // 控制封面和文章内容 横向/纵向 布局
  layout: { type: String, default: 'vertical', validator: v => ['horizontal', 'vertical'].includes(v) },
  coverRatio: { type: Number, default: 55 }, // 控制卡片封面占比大小
  contentRatio: { type: Number, default: 45 }, // 控制卡片文章内容占比大小
  enableReverse: { type: Boolean, default: false }, // 反转排列顺序
  enableDescription: { type: Boolean, default: true }, // 启用文章描述
  descriptionLineCount: { type: Number, default: 2 }, // 文章描述的行数
  enableReadTime: { type: Boolean, default: true }, // 启用阅读时长
  enableReadCount: { type: Boolean, default: true }, // 启用阅读量
  enableLikeCount: { type: Boolean, default: false }, // 启用点赞量
  enableCommentCount: { type: Boolean, default: false } // 启用评论量
})

const router = useRouter()
</script>

<style scoped>

</style>