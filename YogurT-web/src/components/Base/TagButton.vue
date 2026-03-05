<template>
  <span
    class="rounded-full text-base-content/60 duration-300 cursor-pointer tag-btn-color"
    :style="{'--color-tag': tag.color}"
    @click.stop="router.push({ name: 'tags', params: { tagName: tag.name } })"
  >
    #{{ tag.name }}
  </span>
</template>

<script setup>
import { useRouter } from 'vue-router'

const props = defineProps({
  tag: { type: Object, required: true }
})

const router = useRouter()
</script>

<style scoped>
:root {
  --color-tag: initial;
}

.tag-btn-color:hover {
  background-color: var(--color-tag);
  color: white;
}
</style>