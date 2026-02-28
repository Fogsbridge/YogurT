<template>
  <main class="max-w-8xl mx-auto p-2 sm:p-4 lg:p-6 min-h-3/5 flex flex-row gap-4 isolate">
    <RouterView class="grow" />

    <RouterView name="sidebar" class="hidden lg:block w-70" />
  </main>
</template>

<script setup>

</script>

<style scoped>

</style>