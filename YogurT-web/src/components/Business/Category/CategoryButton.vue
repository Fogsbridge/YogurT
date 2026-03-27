<template>
  <button class="rounded-full   bg-slate-400/20 hover:bg-slate-400/70 text-base-content/60 hover:text-white duration-300 cursor-pointer"
          @click.stop="$router.push({ name: 'CategoryDetail', params: { categoryName: categoryName } })"
  >
    {{ categoryName }}
  </button>
</template>

<script setup>
const props = defineProps({
  categoryName: { type: String, required: true }
})

</script>

<style scoped>

</style>