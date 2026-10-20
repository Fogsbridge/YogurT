<script setup>
import { Toaster } from '@/components/ui/sonner'
import { toasterProps } from '@/config/toaster.js'
</script>

<template>
  <Toaster v-bind="toasterProps" />
  <RouterView />
</template>
