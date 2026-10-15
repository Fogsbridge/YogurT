<!--
 * 默认布局
 *
 * @author fogsbridge
 * @since 1.0.0
-->
<script setup>
import { SidebarInset, SidebarProvider, SidebarTrigger } from '@/components/ui/sidebar/index.js'
import { Separator } from '@/components/ui/separator/index.js'
import AppSidebar from '@/components/app-sidebar/AppSidebar.vue'
import { computed } from 'vue'
import { useScroll } from '@vueuse/core'

const { y } = useScroll(window)
const scrolled = computed(() => y.value > 0)
</script>

<template>
  <SidebarProvider>
    <AppSidebar />
    <SidebarInset>
      <header
        class="flex items-center gap-3 sm:gap-4 h-14 p-4 shrink-0 border-b sticky top-0 bg-background transition-colors"
        :class="scrolled ? '' : 'border-transparent'"
      >
        <SidebarTrigger />
        <Separator orientation="vertical" />
      </header>

      <main>
        <RouterView />
      </main>
    </SidebarInset>
  </SidebarProvider>
</template>
