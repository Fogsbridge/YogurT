<template>
  <div class="panel">
    <HomeBanner />
    <SidebarContainer>
      <CategoriesSidebar />
      <TagsSidebar />
    </SidebarContainer>
    <h1 class="text-center text-5xl">Home</h1>
  </div>
</template>

<script setup>
import HomeBanner from '@/views/Home/HomeBanner.vue'
import SidebarContainer from '@/components/Section/SidebarContainer.vue'
import CategoriesSidebar from '@/components/Sidebar/CategoriesSidebar.vue'
import TagsSidebar from '@/components/Sidebar/TagsSidebar.vue'
</script>

<style scoped>

</style>