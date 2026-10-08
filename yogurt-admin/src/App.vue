<template>
  <Toaster
    position="top-center"
    class="flex justify-center"
    :richColors="true"
    :toastOptions="{
      style: {
        '--width': 'auto',
        '--min-width': 'fit-content',
        'font-size': '0.875rem',
        padding: '12px 18px',

        '--success-bg': 'var(--success-muted)',
        '--success-text': 'var(--success-muted-foreground)',
        '--success-border': 'var(--success)',

        '--error-bg': 'var(--error-muted)',
        '--error-text': 'var(--error-muted-foreground)',
        '--error-border': 'var(--error)',

        '--warning-bg': 'var(--warning-muted)',
        '--warning-text': 'var(--warning-muted-foreground)',
        '--warning-border': 'var(--warning)',

        '--info-bg': 'var(--info-muted)',
        '--info-text': 'var(--info-muted-foreground)',
        '--info-border': 'var(--info)',
      },
    }"
  />
  <RouterView />
</template>

<script setup>
import { Toaster } from '@/components/ui/sonner'
</script>
