<!--
 * 认证页（登录/注册）标题
 *
 * @author fogsbridge
 * @since 1.0.0
-->
<script setup>
import Logo from '@/components/Logo.vue'
import LogoWord from '@/components/LogoWord.vue'
</script>

<template>
  <h1 class="flex items-center gap-2">
    <span class="size-8 bg-foreground flex items-center justify-center rounded-lg">
      <Logo class="size-6 fill-background" />
    </span>
    <LogoWord class="h-8" />
  </h1>
</template>
