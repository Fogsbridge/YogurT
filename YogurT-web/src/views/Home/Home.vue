<template>
  <div class="panel">
    <HomeBanner />
    <SidebarContainer>
      <CategorySidebar />
    </SidebarContainer>
    <h1 class="text-center text-5xl">Home</h1>
  </div>
</template>

<script setup>
import HomeBanner from '@/views/Home/HomeBanner.vue'
import SidebarContainer from '@/components/Section/SidebarContainer.vue'
import CategorySidebar from '@/components/Sidebar/CategorySidebar.vue'
</script>

<style scoped>

</style>