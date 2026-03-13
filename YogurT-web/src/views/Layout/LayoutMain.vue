<template>
  <main data-role="layout-main" class="max-w-8xl mx-auto space-y-4 p-4 md:px-6 lg:px-8 min-h-3/5">
    <div data-role="content-banner" class="hidden has-[*]:block"></div>

    <div class="flex flex-row gap-4">
      <LayoutLeftSidebar class="flex-none" />

      <RouterView class="flex-1" />

      <LayoutRightSidebar class="flex-none" />
    </div>
  </main>
</template>

<script setup>
import LayoutRightSidebar from '@/views/Layout/LayoutRightSidebar.vue'
import LayoutLeftSidebar from '@/views/Layout/LayoutLeftSidebar.vue'
</script>

<style scoped>

</style>