<template>
  <div class="min-h-screen bg-base-200">

<!--
  如果有 banner (设想中的绝大部分情况下 banner 都应该是一个含有背景图的组件)，路由记录包含 banner 组件则将导航栏设置 fixed 定位 否则使用 sticky 定位
  如果没有 banner 组件的情况下，不使用 sticky 而使用 fixed 定位会遮盖住后面的内容
-->
    <LayoutNav :isFixed="hasBanner" />

    <LayoutHeader />

    <LayoutMain />

    <LayoutFooter />
  </div>
</template>

<script setup>
import LayoutNav from '@/views/Layout/LayoutNav.vue'
import LayoutHeader from '@/views/Layout/LayoutHeader.vue'
import LayoutMain from '@/views/Layout/LayoutMain.vue'
import LayoutFooter from '@/views/Layout/LayoutFooter.vue'
import { useRoute } from 'vue-router'
import { computed } from 'vue'

const route = useRoute()

const hasBanner = computed(() => {
  return route.matched.some(record => record.components.banner)
})
</script>

<style scoped>

</style>