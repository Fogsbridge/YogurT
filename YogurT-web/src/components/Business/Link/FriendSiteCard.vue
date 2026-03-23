<template>
  <a :href="siteUrl" target="_blank" class="relative group panel h-40 flex flex-row gap-6 p-7 hover:scale-105 hover:border-primary hover:ring-1 hover:ring-primary/70 hover:bg-base-200">
    <svg class="opacity-0 group-hover:opacity-100 size-5 absolute top-3  right-3 stroke-primary duration-500" fill="none" stroke-width="1.5" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
      <path stroke-linecap="round" stroke-linejoin="round" d="M13.5 6H5.25A2.25 2.25 0 0 0 3 8.25v10.5A2.25 2.25 0 0 0 5.25 21h10.5A2.25 2.25 0 0 0 18 18.75V10.5m-10.5 6L21 3m0 0h-5.25M21 3v5.25"></path>
    </svg>
    <img :src="avatarUrl" class="size-16 ring-offset-2 ring-offset-base-100 ring-2 ring-primary/70 group-hover:ring-primary rounded-full duration-300" :alt="name" />
    <div class="flex flex-col w-full">
      <div class="flex gap-3 items-center">
        <span class="text-xl font-bold group-hover:text-primary">{{ name }}</span>
        <span v-if="status === 'offline'" class="bg-error/15 rounded-full px-2 text-sm text-error">异常</span>
      </div>
      <div class="mt-0.5 flex gap-1.5">
        <div class="border border-primary rounded-full px-1 text-primary text-xs content-center group-hover:opacity-0 duration-200" v-for="type in types" :key="type">{{ type }}</div>
      </div>
      <p class="mt-1.5 duration-500 line-clamp-2 text-base-content/80 group-hover:line-clamp-3 group-hover:text-primary/80 group-hover:-mt-4">{{ description }}</p>
    </div>
  </a>
</template>

<script setup>
const props = defineProps({
  id: { type: String },
  name: { type: String },
  description: { type: String },
  siteUrl: { type: String },
  avatarUrl: { type: String },
  types: { type: Array },
  status: { type: String }
})
</script>

<style scoped>

</style>