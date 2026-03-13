<template>
  <footer class="pt-8 md:pt-14 lg:pt-20 bg-linear-to-b from-transparent to-30% to-base-100 transition duration-500">
    <div class="max-w-8xl mx-auto flex flex-col lg:flex-row justify-around gap-6 px-8 lg:px-18 py-8 lg:py-16">
        <div class="hidden lg:block lg:max-w-1/7">
          <div class="text-lg font-bold text-base-content mb-1 lg:mb-4">页面</div>
          <ul class="space-y-2">
            <li class="hover:scale-110 duration-200"><RouterLink to="/" class="hover:text-primary text-sm text-base-content/70">归档</RouterLink></li>
            <li class="hover:scale-110 duration-200"><RouterLink to="/" class="hover:text-primary text-sm text-base-content/70">全部分类</RouterLink></li>
            <li class="hover:scale-110 duration-200"><RouterLink to="/" class="hover:text-primary text-sm text-base-content/70">全部标签</RouterLink></li>
            <li class="hover:scale-110 duration-200"><RouterLink to="/" class="hover:text-primary text-sm text-base-content/70">动态</RouterLink></li>
            <li class="hover:scale-110 duration-200"><RouterLink to="/" class="hover:text-primary text-sm text-base-content/70">关于我</RouterLink></li>
          </ul>
        </div>

        <div class="lg:max-w-3/7">
          <div class="text-lg font-bold text-base-content mb-1 lg:mb-4">最新文章</div>
          <ul class="space-y-2">
            <li class="hover:scale-110 duration-200">
              <RouterLink to="/" class="hover:text-primary text-sm text-base-content/70">关于我头发掉光了这档子事</RouterLink>
            </li>
            <li class="hover:scale-110 duration-200">
              <RouterLink to="/" class="hover:text-primary text-sm text-base-content/70">Java 从入门到放弃</RouterLink>
            </li>
            <li class="hover:scale-110 duration-200">
              <RouterLink to="/" class="hover:text-primary text-sm text-base-content/70">Vue 从入门到放弃</RouterLink>
            </li>
            <li class="hover:scale-110 duration-200">
              <RouterLink to="/" class="hover:text-primary text-sm text-base-content/70">Spring 从入门到放弃</RouterLink>
            </li>
          </ul>
        </div>

        <div class="shrink-0 lg:max-w-2/7">
          <div class="text-lg font-bold text-base-content mb-2 lg:mb-4">热门标签</div>
          <div class="flex flex-wrap gap-2 max-h-50 overflow-auto p-2">
            <RouterLink to="/" class="hover:scale-110 duration-200 px-3 py-1 bg-gray-100 text-base-content/70 hover:bg-purple-400  hover:text-white dark:bg-gray-700 rounded-full text-sm cursor-pointer">
              生活
            </RouterLink>
            <RouterLink to="/" class="hover:scale-110 duration-200 px-3 py-1 bg-gray-100 text-base-content/70 hover:bg-blue-400  hover:text-white dark:bg-gray-700 rounded-full text-sm cursor-pointer">
              Linux
            </RouterLink>
            <RouterLink to="/" class="hover:scale-110 duration-200 px-3 py-1 bg-gray-100 text-base-content/70 hover:bg-amber-400  hover:text-white dark:bg-gray-700 rounded-full text-sm cursor-pointer">
              Java
            </RouterLink>
            <RouterLink to="/" class="hover:scale-110 duration-200 px-3 py-1 bg-gray-100 text-base-content/70 hover:bg-lime-400  hover:text-white dark:bg-gray-700 rounded-full text-sm cursor-pointer">
              JavaScript
            </RouterLink>
            <RouterLink to="/" class="hover:scale-110 duration-200 px-3 py-1 bg-gray-100 text-base-content/70 hover:bg-cyan-400  hover:text-white dark:bg-gray-700 rounded-full text-sm cursor-pointer">
              Vue
            </RouterLink>
            <RouterLink to="/" class="hover:scale-110 duration-200 px-3 py-1 bg-gray-100 text-base-content/70 hover:bg-pink-400  hover:text-white dark:bg-gray-700 rounded-full text-sm cursor-pointer">
              Vite
            </RouterLink>
            <RouterLink to="/" class="hover:scale-110 duration-200 px-3 py-1 bg-gray-100 text-base-content/70 hover:bg-rose-400  hover:text-white dark:bg-gray-700 rounded-full text-sm cursor-pointer">
              Pinia
            </RouterLink>
            <RouterLink to="/" class="hover:scale-110 duration-200 px-3 py-1 bg-gray-100 text-base-content/70 hover:bg-teal-400  hover:text-white dark:bg-gray-700 rounded-full text-sm cursor-pointer">
              Spring
            </RouterLink>
          </div>
        </div>
      </div>


    <!-- 分隔线 -->
    <div class="border-t border-base-content/3 dark:border-base-content/15"></div>

    <div class="bg-base-100 duration-500">
      <div class="max-w-8xl mx-auto flex flex-col lg:flex-row justify-between items-center px-6 py-4">
        <div>
          <div class="text-base flex flex-col lg:flex-row items-center gap-x-3 mb-4 lg:mb-1">
          <span>Copyright &copy; 2026 - {{ currentYear }} By
            <RouterLink to="/" class="link link-primary no-underline">云桥雾</RouterLink>
          </span>
            <span class="hidden lg:block">·</span>
            <span>Powered by
            <a href="https://github.com/Fogsbridge/YogurT" target="_blank" class="link link-secondary no-underline">
              YogurT
            </a>
          </span>
          </div>

          <div class="text-sm text-base-content/60 flex flex-col lg:flex-row items-center gap-x-3 gap-y-1">
          <span>
            <a class="link no-underline" href="">
              xICP备12345678号
            </a>
          </span>
            <span class="hidden lg:block">·</span>
            <span>
            <a class="link no-underline" href="">
              xICP备12345678号
            </a>
          </span>
            <span class="hidden lg:block">·</span>
            <span>
            本站已运行<span class="text-primary"> x </span>天<span class="text-primary"> x </span>时<span class="text-primary"> x </span>分<span class="text-primary"> x </span>秒
          </span>
          </div>
        </div>

        <div class="flex flex-wrap justify-center text-lg gap-x-12 my-4 lg:my-0">
          <RouterLink to="/" class="hover:scale-120 duration-200 link no-underline hover:text-primary">留言</RouterLink>
          <RouterLink to="/rss" class="hover:scale-120 duration-200 link no-underline hover:text-primary">RSS</RouterLink>
          <RouterLink to="/about" class="hover:scale-120 duration-200 link no-underline hover:text-primary">关于</RouterLink>
        </div>
      </div>
    </div>
  </footer>
</template>

<script setup>
import { ref } from 'vue'

const currentYear = ref(new Date().getFullYear())
</script>

<style scoped>

</style>