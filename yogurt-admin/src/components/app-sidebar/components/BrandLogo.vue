<!--
 * 图片 + 文字 logo 标识，点击跳转首页
 *
 * @author fogsbridge
 * @since 1.0.0
-->
<script setup>
import { SidebarMenu, SidebarMenuButton, SidebarMenuItem } from '@/components/ui/sidebar/index.js'

defineProps({
  brand: { type: Object, required: true },
})
</script>

<template>
  <SidebarMenu>
    <SidebarMenuItem>
      <SidebarMenuButton size="lg" tooltip="首页" as-child>
        <RouterLink to="/" class="flex items-center gap-2">
          <div
            class="flex items-center justify-center rounded-lg aspect-square size-8 bg-sidebar-primary text-sidebar-primary-foreground"
          >
            <Component :is="brand.logo" class="size-6" />
          </div>
          <Component :is="brand.logoWord" class="h-6 mt-0.5" />
        </RouterLink>
      </SidebarMenuButton>
    </SidebarMenuItem>
  </SidebarMenu>
</template>
