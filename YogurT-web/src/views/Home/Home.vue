<template>
  <div class="space-y-2 md:space-y-4">
    <HomeBanner />
    <SidebarContainer>
      <AuthorInfoSidebar />
      <CategoriesSidebar />
      <TagsSidebar />
    </SidebarContainer>

    <InfoBar title="近期文章" />
    <RecentPostsGrid />
  </div>
</template>

<script setup>
import HomeBanner from '@/views/Home/HomeBanner.vue'
import SidebarContainer from '@/components/Layout/components/SidebarContainer.vue'
import CategoriesSidebar from '@/components/Business/Sidebar/CategoriesSidebar.vue'
import TagsSidebar from '@/components/Business/Sidebar/TagsSidebar.vue'
import AuthorInfoSidebar from '@/components/Business/Sidebar/AuthorInfoSidebar.vue'
import RecentPostsGrid from '@/views/Home/components/RecentPostsGrid.vue'
import InfoBar from '@/components/Base/InfoBar.vue'
</script>

<style scoped>

</style>