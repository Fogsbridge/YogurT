<template>
  <BannerContainer mode="immersive">
    <div class="w-full h-full bg-center bg-cover bg-[url(/YogurT/images/banner/banner-2.jpg)]">
      <!-- 点阵遮罩 -->
      <div class="absolute inset-0 dot-mask backdrop-brightness-80 dark:backdrop-brightness-70 transition duration-500" ></div>
      <div class="absolute inset-0 dot-mask transition duration-500" ></div>

      <div class="min-h-screen h-full flex flex-col items-center">
        <div class="h-full flex flex-col justify-center items-center select-none text-white/95 dark:text-white/85 text-shadow-black/50 text-shadow-lg transition-all duration-500">
          <img :src="baseUrl + 'images/avatar-1.jpg'" alt="avatar" class="z-10 size-28 mb-8 rounded-full ring-base-100/20 ring-6 opacity-90 shadow-black/80 shadow-2xl" />
          <span class="z-10 text-3xl md:text-4xl lg:text-5xl mb-6 font-bold">云桥雾的Blog</span>
          <div class="z-10 h-5 md:h-6 lg:h-7.5 text-xl md:text-2xl lg:text-3xl mb-10">
            <Typewriter :text="titleArr" cursorTwClass="bg-blue-400 pl-0.5 ml-0.5" deletingDelay="40" preDeleteDelay="4000" preNextTextDelay="500" />
          </div>
        </div>

        <div class="z-10 p-2 mb-6 animate-bounce cursor-pointer" @click="scrollToMain">
          <svg class="size-10 fill-white/90 stroke-white/60 stroke-1 drop-shadow-xl drop-shadow-black/50" fill="currentColor" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
            <path clip-rule="evenodd" fill-rule="evenodd" d="M12.53 16.28a.75.75 0 0 1-1.06 0l-7.5-7.5a.75.75 0 0 1 1.06-1.06L12 14.69l6.97-6.97a.75.75 0 1 1 1.06 1.06l-7.5 7.5Z"></path>
          </svg>
        </div>
      </div>
    </div>
  </BannerContainer>
</template>

<script setup>
import BannerContainer from '@/components/Layout/components/BannerContainer.vue'
import Typewriter from '@/components/Base/Typewriter.vue'
import { ref } from 'vue'
import { useLayoutScroll } from '@/composables/useLayoutScroll.js'
const baseUrl = import.meta.env.BASE_URL


const { scrollToMain } = useLayoutScroll()

const titleArr = ref([
  'title标题1',
  'title标题2',
  'title标题3',
  'title标题4',
])
</script>

<style scoped>
/* 点阵遮罩 */
.dot-mask {
  background-image: radial-gradient(
    circle at 4px 4px,
    rgba(0, 0, 0, 0.1) 2px,
    transparent 1px
  );
  background-size: 8px 8px;
  animation: flow 20s linear infinite;
}

@keyframes flow {
  0% {
    background-position: 0 0;
  }
  100% {
    background-position: 200px 200px;
  }
}
</style>