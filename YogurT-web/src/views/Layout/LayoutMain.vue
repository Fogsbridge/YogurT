<template>
  <main class="max-w-8xl mx-auto p-2 sm:p-4 lg:p-6 min-h-3/5 flex flex-row gap-4">
    <RouterView class="w-full" />

    <RouterView name="sidebar" class="hidden md:block w-95" />
  </main>
</template>

<script setup>

</script>

<style scoped>

</style>