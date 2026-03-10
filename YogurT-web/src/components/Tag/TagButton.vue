<template>
  <span class="rounded-full text-base-content/60 duration-300 cursor-pointer hover:text-white hover:bg-(--color-tag)"
        @click.stop="$router.push({ name: 'tags', params: { tagName: tag.name } })"
        v-tw:--color-tag="tag.color"
  >
    #{{ tag.name }}
  </span>
</template>

<script setup>
const props = defineProps({
  tag: { type: Object, required: true }
})

</script>

<style scoped>

</style>