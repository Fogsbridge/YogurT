<!--
 * 侧边栏次导航
 *
 * @author fogsbridge
 * @since 1.0.0
-->
<script setup>
import {
  SidebarGroup,
  SidebarGroupContent,
  SidebarMenu,
  SidebarMenuItem,
} from '@/components/ui/sidebar/index.js'
import NavMenuButton from '@/components/app-sidebar/components/NavMenuButton.vue'
import { isExternalUrl } from '@/utils/is-external-url.js'

defineProps({
  items: { type: Array, default: () => [] },
})
</script>

<template>
  <SidebarGroup>
    <SidebarGroupContent>
      <SidebarMenu>
        <SidebarMenuItem v-for="item in items" :key="item.title">
          <NavMenuButton :isExternal="isExternalUrl(item.url)" :item="item" :tooltip="item.title" />
        </SidebarMenuItem>
      </SidebarMenu>
    </SidebarGroupContent>
  </SidebarGroup>
</template>
