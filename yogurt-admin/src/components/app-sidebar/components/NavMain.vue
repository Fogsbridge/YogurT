<!--
 * 侧边栏主导航
 *
 * @author fogsbridge
 * @since 1.0.0
-->
<script setup>
import {
  SidebarGroup,
  SidebarGroupLabel,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
  SidebarMenuSub,
  SidebarMenuSubItem,
  useSidebar,
} from '@/components/ui/sidebar/index.js'
import {
  Collapsible,
  CollapsibleTrigger,
  CollapsibleContent,
} from '@/components/ui/collapsible/index.js'
import NavMenuButton from '@/components/app-sidebar/components/NavMenuButton.vue'
import {
  DropdownMenu,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
  DropdownMenuContent,
} from '@/components/ui/dropdown-menu/index.js'
import { ChevronRightIcon } from '@lucide/vue'
import { useRoute } from 'vue-router'
import { isExternalUrl } from '@/utils/is-external-url.js'

defineProps({
  items: { type: Array, default: () => [] },
})

const { state, isMobile } = useSidebar()
const route = useRoute()

const isActive = (menu) => {
  const pathname = route.path
  if (menu.url) {
    return pathname === menu.url
  }
  return !!menu.items?.some((item) => item.url === pathname)
}

const isCollapsed = (menu) => {
  const initialPath = route.path
  if (menu.url === initialPath) return true
  return !!menu.items?.some((item) => item.url === initialPath)
}
</script>

<template>
  <SidebarGroup v-for="group in items" :key="group.title">
    <SidebarGroupLabel>{{ group.title }}</SidebarGroupLabel>
    <SidebarMenu>
      <template v-for="menu in group.items" :key="menu.title">
        <!-- 无子项 -->
        <SidebarMenuItem v-if="!menu.items">
          <NavMenuButton
            :item="menu"
            :tooltip="menu.title"
            :isActive="isActive(menu)"
            :isExternal="isExternalUrl(menu.url)"
            :sub="false"
          />
        </SidebarMenuItem>

        <!-- 有子项 -->
        <SidebarMenuItem v-else>
          <!-- 在侧边栏展开或者处于移动端时，使用折叠面板展示子项 -->
          <Collapsible
            as-child
            v-if="state !== 'collapsed' || isMobile"
            class="group/collapsible"
            :default-open="isCollapsed(menu)"
          >
            <SidebarMenuItem>
              <CollapsibleTrigger as-child>
                <SidebarMenuButton :tooltip="menu.title">
                  <Component :is="menu.icon" v-if="menu.icon" />
                  <span>{{ menu.title }}</span>
                  <ChevronRightIcon
                    class="ml-auto transition-transform duration-200 group-data-[state=open]/collapsible:rotate-90"
                  />
                </SidebarMenuButton>
              </CollapsibleTrigger>

              <CollapsibleContent class="collapsible-content">
                <SidebarMenuSub>
                  <SidebarMenuSubItem v-for="subItem in menu.items" :key="subItem.title">
                    <NavMenuButton
                      :item="subItem"
                      :tooltip="subItem.title"
                      :isActive="isActive(subItem)"
                      :isExternal="isExternalUrl(subItem.url)"
                      :sub="true"
                    />
                  </SidebarMenuSubItem>
                </SidebarMenuSub>
              </CollapsibleContent>
            </SidebarMenuItem>
          </Collapsible>

          <!-- 在侧边栏折叠并且处于桌面端时，使用下拉菜单展示子项 -->
          <DropdownMenu v-else>
            <DropdownMenuTrigger as-child>
              <SidebarMenuButton :isActive="isActive(menu)" :tooltip="menu.title">
                <Component :is="menu.icon" v-if="menu.icon" />
                <span>{{ menu.title }}</span>
              </SidebarMenuButton>
            </DropdownMenuTrigger>

            <DropdownMenuContent align="start" side="right">
              <DropdownMenuLabel>
                <div class="flex items-center gap-2">
                  <Component :is="menu.icon" v-if="menu.icon" class="w-4 h-4" />
                  <span>{{ menu.title }}</span>
                </div>
              </DropdownMenuLabel>
              <DropdownMenuSeparator />
              <DropdownMenuItem v-for="subItem in menu.items" :key="subItem.title" as-child>
                <NavMenuButton
                  :item="subItem"
                  :isActive="isActive(subItem)"
                  :isExternal="isExternalUrl(subItem.url)"
                  :sub="false"
                />
              </DropdownMenuItem>
            </DropdownMenuContent>
          </DropdownMenu>
        </SidebarMenuItem>
      </template>
    </SidebarMenu>
  </SidebarGroup>
</template>
