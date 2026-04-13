<template>
  <div class="panel">
    <HomeBanner />
    <SidebarContainer>
      <AuthorInfoSidebar />
      <CategoriesSidebar />
      <TagsSidebar />
    </SidebarContainer>
    <h1 class="text-center text-5xl">Home</h1>
  </div>
</template>

<script setup>
import HomeBanner from '@/views/Home/HomeBanner.vue'
import SidebarContainer from '@/components/Layout/components/SidebarContainer.vue'
import CategoriesSidebar from '@/components/Business/Sidebar/CategoriesSidebar.vue'
import TagsSidebar from '@/components/Business/Sidebar/TagsSidebar.vue'
import AuthorInfoSidebar from '@/components/Business/Sidebar/AuthorInfoSidebar.vue'
</script>

<style scoped>

</style>