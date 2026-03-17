<template>
  <div class="panel px-8 py-6 grid grid-cols-[auto_1fr_auto] items-center gap-x-4 gap-y-2">
    <div>
      <img class="size-14 rounded-full border-3 border-base-content/10 dark:border-base-content/20"
           :src="moment?.author.avatar"  alt="作者头像"
      />
    </div>

    <div class="col-span-2 lg:col-span-1">
      <div class="flex items-center gap-x-2">
        <span class="text-lg lg:text-xl text-base-content/90">{{ moment?.author.name }}</span>
        <span v-if="moment?.pinned" class="lg:hidden rounded-full border border-primary text-sm text-primary px-1.5 h-5.5">置顶</span>
      </div>
      <div class="mt-0.5 text-sm text-base-content/90">
        <span v-if="moment?.pinned" class="hidden lg:inline mr-2 rounded-full border border-primary text-sm text-primary px-1.5 py-0.5">置顶</span>
        <span v-if="moment?.createTime !== moment?.updateTime" class="mr-1">编辑于</span>
        <span>{{ moment?.updateTime }}</span>
      </div>
    </div>

    <!-- 右边空白占位 -->
    <div class="hidden lg:block lg:col-start-3 w-14"></div>

    <div class="col-span-3 lg:col-span-1 lg:col-start-2">
      <div class="text-base-content/90 lg:text-lg">
        {{ moment?.content }}
      </div>

      <div v-if="moment?.media" class="[&:has(>div:hover)]:[&>:not(:hover)]:brightness-50 mt-3 grid grid-cols-(--media-cols) gap-1"
           v-tw:--media-cols="`repeat(${moment?.media.length > 1 ? 2 : 1}, 1fr)`"
      >
        <div v-for="item in moment?.media"
             class="h-(--media-item-height) xl:h-(--media-item-height-xl) rounded-lg overflow-clip duration-500 border-2 border-base-content/10 hover:z-10"
             :class="moment?.media.length > 1 ? 'hover:scale-130 hover:brightness-100' : 'hover:scale-110'"
             v-tw:--media-item-height.spacing="moment?.media.length > 1 ? 30 : 60"
             v-tw:--media-item-height-xl.spacing="moment?.media.length > 1 ? 40 : 80"
        >
          <img v-if="item.type === 'image'"
               :src="item.url"  alt="配图"
               class="size-full object-cover object-center"
               @click.stop="openLightbox(item.url)"
          />
          <video v-if="item.type === 'video'" controls class="size-full object-cover object-center">
            <source :src="item.url" />
          </video>
        </div>

        <Lightbox v-model:show="showLightbox" :url="imgUrl" />
      </div>
    </div>

    <div class="mt-6 col-span-3 lg:col-span-1 lg:col-start-2 flex flex-row items-center gap-4 xl:gap-6 text-base-content/80">
      <div class="flex-1 h-0.5 rounded-full bg-base-content/10 dark:bg-base-content/20"></div>

      <div class="flex items-center hover:text-primary hover:scale-120 duration-300">
        <svg class="size-5 inline" fill="none" stroke-width="1.5" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
          <path stroke-linecap="round" stroke-linejoin="round" d="M21 8.25c0-2.485-2.099-4.5-4.688-4.5-1.935 0-3.597 1.126-4.312 2.733-.715-1.607-2.377-2.733-4.313-2.733C5.1 3.75 3 5.765 3 8.25c0 7.22 9 12 9 12s9-4.78 9-12Z"></path>
        </svg>
        <span class="ml-0.5">{{ moment?.likeCount }}</span>
      </div>

      <div class="w-10 xl:w-14 h-0.5 rounded-full bg-base-content/10 dark:bg-base-content/20"></div>

      <div class="flex items-center hover:text-primary hover:scale-120 duration-300">
        <svg class="size-5 inline" fill="none" stroke-width="1.5" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
          <path stroke-linecap="round" stroke-linejoin="round" d="M8.625 9.75a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0H8.25m4.125 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0H12m4.125 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0h-.375m-13.5 3.01c0 1.6 1.123 2.994 2.707 3.227 1.087.16 2.185.283 3.293.369V21l4.184-4.183a1.14 1.14 0 0 1 .778-.332 48.294 48.294 0 0 0 5.83-.498c1.585-.233 2.708-1.626 2.708-3.228V6.741c0-1.602-1.123-2.995-2.707-3.228A48.394 48.394 0 0 0 12 3c-2.392 0-4.744.175-7.043.513C3.373 3.746 2.25 5.14 2.25 6.741v6.018Z"></path>
        </svg>
        <span class="ml-1">{{ moment?.commentCount }}</span>
      </div>

      <div class="flex-1 h-0.5 rounded-full bg-base-content/10 dark:bg-base-content/20"></div>
    </div>
  </div>
</template>

<script setup>
import Lightbox from '@/components/Base/Lightbox.vue'
import { ref } from 'vue'

const props = defineProps({
  moment: { type: Object }
})

const showLightbox = ref(false)
const imgUrl = ref('')

const openLightbox = (url) => {
  showLightbox .value = true
  imgUrl.value = url
}
</script>

<style scoped>

</style>