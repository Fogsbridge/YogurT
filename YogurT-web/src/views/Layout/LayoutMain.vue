<template>
  <main data-role="layout-main" class="max-w-8xl mx-auto p-4 md:px-6 min-h-3/5 flex flex-row gap-4">
    <RouterView class="flex-1" />

    <RouterView name="sidebar" class="flex-none w-70 hidden lg:block" />
  </main>
</template>

<script setup>

</script>

<style scoped>

</style>