<!--
 * 导航菜单按钮
 *
 * @author fogsbridge
 * @since 1.0.0
-->
<script setup>
import { ExternalLinkIcon } from '@lucide/vue'
import { SidebarMenuButton, SidebarMenuSubButton } from '@/components/ui/sidebar/index.js'

defineProps({
  item: { type: Object, required: true },
  tooltip: { type: String, required: false, default: undefined },
  isActive: { type: Boolean, required: false },
  isExternal: { type: Boolean, required: true },
  sub: { type: Boolean, default: false },
})
</script>

<template>
  <component
    :is="sub ? SidebarMenuSubButton : SidebarMenuButton"
    :is-active="isActive"
    :tooltip="tooltip"
    as-child
  >
    <!-- 站外链接 -->
    <a
      v-if="isExternal"
      :href="item.url"
      target="_blank"
      rel="noopener noreferrer"
      class="flex items-center gap-2"
    >
      <Component :is="item.icon" v-if="item.icon" />
      <span>{{ item.title }}</span>
      <ExternalLinkIcon class="w-4 h-4 ml-auto" />
    </a>
    <!-- 站内链接 -->
    <RouterLink v-else :to="item.url || '/'" class="flex items-center gap-2">
      <Component :is="item.icon" v-if="item.icon" />
      <span>{{ item.title }}</span>
    </RouterLink>
  </component>
</template>
