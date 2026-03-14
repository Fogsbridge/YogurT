<template>
  <div>
    <ul class="flex flex-row flex-wrap gap-2 md:gap-3 md:text-2xl justify-center">
      <li v-for="tag in tags" :key="tag.id"
          @click.stop="$router.push({ name: 'TagDetail', params: { tagName: tag.name } })"
          class="group flex flex-row gap-1 items-center px-2.5 py-1 md:px-4 md:py-2 bg-base-100 rounded-xl border border-base-content/10 dark:border-base-content/13 cursor-pointer transition duration-300
            text-base-content/80 dark:text-base-content/90 hover:text-white hover:bg-(--tag-color) hover:scale-105 hover:shadow-base-content/10 hover:dark:shadow-base-content/15 hover:shadow-lg"
          v-tw:--tag-color="tag.color"
      >
        <div>
          <span class="text-base-content/35 dark:text-base-content/50 mr-0.5 md:mr-1 group-hover:text-white duration-300">#</span>
          <span>{{ tag.name }}</span>
        </div>
        <div class="md:ml-0.5 size-5 md:size-6 rounded-full bg-base-content/5 dark:bg-base-content/15 text-center text-xs md:text-base leading-5 md:leading-6 text-base-content/35 duration-300
                  group-hover:text-white group-hover:font-bold group-hover:bg-transparent group-hover:scale-130"
        >
          {{ tag.postsCount }}
        </div>
      </li>
    </ul>
  </div>
</template>

<script setup>
const props = defineProps({
  tags: { type: Array }
})
</script>

<style scoped>

</style>