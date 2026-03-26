<template>
  <div class="panel flex-none px-6 py-4 flex flex-col">
    <h2 class="font-bold border-l-4 border-primary pl-3 flex-none">本站信息</h2>
    <div class="flex flex-col md:flex-row gap-y-4 md:gap-x-14 xl:gap-x-18 md:mx-10 xl:mx-14 mb-6">
      <div class="flex flex-col items-center gap-6 md:gap-8 flex-none self-center mt-4 md:mt-0">
        <img src="/images/avatar-1.jpg" alt="云桥雾" class="size-26 rounded-full ring-offset-2 ring-offset-base-100 ring-3 ring-primary duration-300" />
        <span class="text-3xl font-bold text-base-content">云桥雾</span>
      </div>
      <div class="space-y-2.5 flex-1">
        <div class="border-b border-base-content/4 dark:border-base-content/8 pb-1">
          <div class="text-xs text-base-content/40 mb-0.5">站点名称</div>
          <div class="text-sm">云桥雾</div>
        </div>

        <div class="border-b border-base-content/4 dark:border-base-content/8 pb-1">
          <div class="text-xs text-base-content/40 mb-0.5">站点描述</div>
          <div class="text-sm line-clamp-2">记录技术与生活的点滴</div>
        </div>

        <div class="border-b border-base-content/4 dark:border-base-content/8 pb-1">
          <div class="text-xs text-base-content/40 mb-0.5">站点地址</div>
          <a href="http://localhost:5173" class="text-sm text-primary hover:underline line-clamp-none">http://localhost:5173</a>
        </div>

        <div class="border-b border-base-content/4 dark:border-base-content/8 pb-1">
          <div class="text-xs text-base-content/40 mb-0.5">头像地址</div>
          <a href="http://localhost:5173" target="_blank" class="text-sm text-primary hover:underline line-clamp-none">http://localhost:5173/images/avatar-1.jpg</a>
        </div>

        <div>
          <div class="text-xs text-base-content/40 mb-0.5">RSS订阅</div>
          <a href="http://localhost:5173" target="_blank" class="text-sm text-primary hover:underline line-clamp-none">http://localhost:5173</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>

</script>

<style scoped>

</style>