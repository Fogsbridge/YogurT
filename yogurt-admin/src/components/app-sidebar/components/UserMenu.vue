<!--
 * 用户菜单
 *
 * @author fogsbridge
 * @since 1.0.0
-->
<script setup>
import { ChevronsUpDown, LogOutIcon } from '@lucide/vue'
import { Avatar, AvatarFallback, AvatarImage } from '@/components/ui/avatar'
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from '@/components/ui/dropdown-menu'
import {
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
  useSidebar,
} from '@/components/ui/sidebar'
import { useLogoutMutation } from '@/composables/queries/useAuth.js'
import { toast } from 'vue-sonner'
import { useAuthStore } from '@/stores/auth.js'
import { useRouter } from 'vue-router'
import { ROUTE_NAME } from '@/constants/route-name.js'

defineProps({
  user: { type: Object, required: true },
})

const { mutateAsync } = useLogoutMutation()
const authStore = useAuthStore()
const router = useRouter()

const logout = async () => {
  // 此接口幂等，响应始终是 200，通用异常已由响应拦截器处理，此处无需处理异常
  // await 是确保请求发出后再清 token，让请求能带上 Authorization
  await mutateAsync()
  authStore.clearToken()
  toast.success('已退出登录')
  router.replace({ name: ROUTE_NAME.LOGIN })
}

const { isMobile } = useSidebar()
</script>

<template>
  <SidebarMenu>
    <SidebarMenuItem>
      <DropdownMenu>
        <DropdownMenuTrigger as-child>
          <SidebarMenuButton
            size="lg"
            class="data-[state=open]:bg-sidebar-accent data-[state=open]:text-sidebar-accent-foreground"
          >
            <Avatar class="h-8 w-8 rounded-lg">
              <AvatarImage :src="user.avatar" :alt="user.nickname" />
              <AvatarFallback class="rounded-lg"> Test </AvatarFallback>
            </Avatar>
            <div class="grid flex-1 text-left text-sm leading-tight">
              <span class="truncate font-medium">{{ user.nickname }}</span>
              <span class="truncate text-xs">{{ user.email }}</span>
            </div>
            <ChevronsUpDown class="ml-auto size-4" />
          </SidebarMenuButton>
        </DropdownMenuTrigger>
        <DropdownMenuContent
          class="w-(--reka-dropdown-menu-trigger-width) min-w-56 rounded-lg"
          :side="isMobile ? 'bottom' : 'right'"
          align="end"
          :side-offset="4"
        >
          <DropdownMenuLabel class="p-0 font-normal">
            <div class="flex items-center gap-2 px-1 py-1.5 text-left text-sm">
              <Avatar class="h-8 w-8 rounded-lg">
                <AvatarImage :src="user.avatar" :alt="user.nickname" />
                <AvatarFallback class="rounded-lg"> Test </AvatarFallback>
              </Avatar>
              <div class="grid flex-1 text-left text-sm leading-tight">
                <span class="truncate font-semibold">{{ user.nickname }}</span>
                <span class="truncate text-xs">{{ user.email }}</span>
              </div>
            </div>
          </DropdownMenuLabel>
          <DropdownMenuSeparator />
          <DropdownMenuItem variant="destructive" @click="logout">
            <LogOutIcon />
            <span>退出登录</span>
          </DropdownMenuItem>
        </DropdownMenuContent>
      </DropdownMenu>
    </SidebarMenuItem>
  </SidebarMenu>
</template>
