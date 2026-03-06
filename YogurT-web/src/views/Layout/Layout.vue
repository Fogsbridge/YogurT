<template>
  <div class="min-h-screen bg-base-200 transition duration-500">
    <LayoutHeader />

    <LayoutMain />

    <LayoutFooter />
  </div>
</template>

<script setup>
import LayoutHeader from '@/views/Layout/LayoutHeader.vue'
import LayoutMain from '@/views/Layout/LayoutMain.vue'
import LayoutFooter from '@/views/Layout/LayoutFooter.vue'
</script>

<style scoped>

</style>