<script setup>
import { cn } from "@/lib/utils.js";
import { Separator } from "@/components/ui/separator/index.js";
const props = defineProps({
  class: { type: [Boolean, null, String, Object, Array], required: false, skipCheck: true }
});
</script>

<template>
  <Separator
    data-slot="sidebar-separator"
    data-sidebar="separator"
    :class="cn('bg-sidebar-border mx-2 w-auto', props.class)"
  >
    <slot />
  </Separator>
</template>
