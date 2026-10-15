<!--
 * 侧边栏
 *
 * @author fogsbridge
 * @since 1.0.0
-->
<script setup>
import {
  Sidebar,
  SidebarContent,
  SidebarFooter,
  SidebarHeader,
  SidebarRail,
} from '@/components/ui/sidebar'
import BrandLogo from '@/components/app-sidebar/components/BrandLogo.vue'
import NavMain from '@/components/app-sidebar/components/NavMain.vue'
import UserMenu from '@/components/app-sidebar/components/UserMenu.vue'
import NavSecondary from '@/components/app-sidebar/components/NavSecondary.vue'
import {
  brandData,
  navMainData,
  navSecondaryData,
  userData,
} from '@/components/app-sidebar/sidebar-config.js'
</script>

<template>
  <Sidebar collapsible="icon">
    <SidebarHeader>
      <BrandLogo :brand="brandData" />
    </SidebarHeader>
    <SidebarContent>
      <NavMain :items="navMainData" />
      <NavSecondary :items="navSecondaryData" class="mt-auto" />
    </SidebarContent>
    <SidebarFooter>
      <UserMenu :user="userData" />
    </SidebarFooter>
    <SidebarRail />
  </Sidebar>
</template>
