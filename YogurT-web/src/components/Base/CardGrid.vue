<template>
  <ul class="grid grid-cols-(--cols) md:grid-cols-(--md-cols) lg:grid-cols-(--lg-cols) xl:grid-cols-(--xl-cols) gap-(--gap)"
      v-tw:--cols.grid-cols="cols"
      v-tw:--md-cols.grid-cols="mdCols"
      v-tw:--lg-cols.grid-cols="lgCols"
      v-tw:--xl-cols.grid-cols="xlCols"
      v-tw:--gap.spacing="gap"
  >
    <li v-for="(item, index) in items" :key="index">
      <slot v-bind="{item, index}" />
    </li>
  </ul>
  <!-- TODO 分页或者瀑布流 -->
</template>

<script setup>
const props = defineProps({
  items: { type: Array },
  gap: { type: Number, default: 4 },
  cols: { type: Number, default: 1 },
  mdCols: { type: Number, default: 1 },
  lgCols: { type: Number, default: 2 },
  xlCols: { type: Number, default: 2 }
})
</script>

<style scoped>

</style>