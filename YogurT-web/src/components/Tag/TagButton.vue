<template>
  <span class="px-1.5 group/tag-btn rounded-full text-base-content/60 duration-300 cursor-pointer hover:text-white hover:bg-(--color-tag)"
        @click.stop="$router.push({ name: 'tags', params: { tagName: tag.name } })"
        v-tw:--color-tag="tag.color"
  >
    <span class="mr-0.5 text-base-content/35 group-hover/tag-btn:text-white duration-300">#</span>
    <span>{{ tag.name }}</span>
  </span>
</template>

<script setup>
const props = defineProps({
  tag: { type: Object, required: true }
})

</script>

<style scoped>

</style>