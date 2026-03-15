<template>
  <div class="flex flex-col lg:flex-row panel overflow-hidden">
    <!-- 左侧 -->
    <div class="relative w-full lg:w-1/2 h-auto bg-center bg-cover bg-no-repeat"
         style="background-image: url('/YogurT/images/banner/m-banner-1.jpg');">
      <div class="absolute inset-0 bg-linear-to-br from-primary/40 via-primary/20 to-transparent"></div>

      <div class="relative h-full flex flex-col items-center justify-center text-center text-white/95 p-4 sm:p-6 md:p-8">
        <div class="text-7xl sm:text-8xl md:text-9xl font-bold tracking-wider">
          404
        </div>
        <div class="text-4xl sm:text-5xl md:text-6xl font-bold mb-6 lg:mb-14 tracking-tighter">
          (𖦹.𖦹)
        </div>
        <div class="text-2xl sm:text-3xl md:text-4xl lg:mb-6">
          页面迷路了
        </div>
        <div class="text-white/90 text-base sm:text-lg md:text-xl px-4 lg:px-10">
          找不到您要的页面。可能它去度假了，或者从未存在过。
        </div>
      </div>
    </div>

    <!-- 右侧 -->
    <div class="flex-1 bg-linear-to-br from-base-100 to-base-200 p-4 sm:p-6 md:p-8">
      <div class="h-full flex flex-col justify-center items-center">
        <div class="w-full">
          <div class="text-center mb-4 sm:mb-6 md:mb-8">
            <h2 class="text-3xl sm:text-4xl lg:text-5xl font-bold text-base-content">
              看看其他内容吧~
            </h2>
          </div>

          <div class="grid gap-2 grid-cols-1 sm:grid-cols-2">
            <RouterLink to="/" class="group">
              <div class="flex items-center justify-start p-4 rounded-xl bg-base-100 hover:bg-base-200 border border-base-content/15 hover:border-primary/70 transition-all duration-200 gap-2">
                <div class="size-10 rounded-full bg-primary/5 flex items-center justify-center group-hover:bg-primary/15 transition-colors">
                  <svg class="size-6 text-primary" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6"/>
                  </svg>
                </div>
                <div class="font-bold text-base-content text-sm sm:text-base">前往首页</div>
              </div>
            </RouterLink>

            <RouterLink to="/" class="group">
              <div class="flex items-center justify-start p-4 rounded-xl bg-base-100 hover:bg-base-200 border border-base-content/15 hover:border-primary/70 transition-all duration-200 gap-2">
                <div class="size-10 rounded-full bg-primary/5 flex items-center justify-center group-hover:bg-primary/15 transition-colors">
                  <svg class="size-6 text-primary" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 14l-7 7m0 0l-7-7m7 7V3"/>
                  </svg>
                </div>
                <div class="font-bold text-base-content text-sm sm:text-base">随机一篇文章</div>
              </div>
            </RouterLink>

            <div class="group sm:col-span-2 p-4 rounded-xl bg-base-100 hover:bg-base-200 border border-base-content/15 hover:border-primary/70 transition-all duration-200 gap-2">
              <div class="flex items-center gap-2 mb-3">
                <div class="size-10 rounded-full bg-primary/5 flex items-center justify-center group-hover:bg-primary/15 transition-colors">
                  <svg class="size-6 text-primary" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"/>
                  </svg>
                </div>
                <div class="font-bold text-base-content text-sm sm:text-base">搜索文章</div>
              </div>
              <div class="relative">
                <input type="text" placeholder="输入关键词搜索" class="input w-full pl-10 pr-4 py-5 h-10 text-sm focus:border-primary/60 focus:ring-2 focus:ring-primary/20 outline-none transition-all duration-300" />
                <svg class="absolute left-3 top-1/2 transform -translate-y-1/2 w-4 h-4 text-base-content/50" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"/>
                </svg>
              </div>
            </div>

            <RouterLink to="/" class="h-40 group sm:col-span-2 p-4 rounded-xl bg-base-100 hover:bg-base-200 border border-base-content/15 hover:border-primary/70 transition-all duration-200 gap-2">
              文章链接1
            </RouterLink>
            <RouterLink to="/" class="h-40 group sm:col-span-2 p-4 rounded-xl bg-base-100 hover:bg-base-200 border border-base-content/15 hover:border-primary/70 transition-all duration-200 gap-2">
              文章链接2
            </RouterLink>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>

</script>

<style scoped>

</style>