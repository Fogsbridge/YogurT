<template>
  <div class="panel">
    <HomeBanner />
    <SidebarContainer side="left">
      <Sidebar />
    </SidebarContainer>
    <h1 class="text-center text-5xl">Home</h1>
  </div>
</template>

<script setup>
import HomeBanner from '@/views/Home/HomeBanner.vue'
import SidebarContainer from '@/components/Page/SidebarContainer.vue'
import Sidebar from '@/components/Sidebar/Sidebar.vue'
</script>

<style scoped>

</style>