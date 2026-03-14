<template>
  <ul>
    <li v-for="(item, index) in items" :key="index">
      <slot v-bind="{item, index}" />
    </li>
  </ul>
  <!-- TODO 分页或者瀑布流 -->
</template>

<script setup>
const props = defineProps({
  items: { type: Array },
})
</script>

<style scoped>

</style>