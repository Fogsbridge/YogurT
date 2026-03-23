<template>
  <div v-overlay-scroll.global class="h-full min-h-screen bg-base-200 transition duration-500">
    <LayoutHeader />

    <LayoutMain />

    <LayoutFooter />
  </div>
</template>

<script setup>
import LayoutHeader from '@/components/Layout/LayoutHeader.vue'
import LayoutMain from '@/components/Layout/LayoutMain.vue'
import LayoutFooter from '@/components/Layout/LayoutFooter.vue'
</script>

<style scoped>

</style>