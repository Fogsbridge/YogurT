<template>
  <div class="pt-2 lg:pt-6 pb-4 lg:pb-12 transition duration-500">
    <div v-for="archive in archiveList" :key="archive.year">
      <div class="flex flex-row items-center gap-2 md:gap-4 my-2 lg:my-4">
        <h2 class="text-3xl lg:text-4xl font-bold">
          {{ archive.year }}
        </h2>
        <span class="size-1 md:size-1.5 rounded-full bg-base-content/70"></span>
        <span class="text-base font-medium">{{ archive.posts.length }} 篇文章</span>
      </div>

      <ul class="mr-5 lg:mx-7">
        <li v-for="post in archive.posts" :key="posts.id"
            class="grid grid-cols-[28px_1fr] grid-rows-[20px_1fr] items-center ">

          <div class="size-7 justify-self-center">
            <svg class="fill-current/80" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
              <path clip-rule="evenodd" fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm1-12a1 1 0 10-2 0v4a1 1 0 00.293.707l2.828 2.829a1 1 0 101.415-1.415L11 9.586V6z"></path>
            </svg>
          </div>

          <div>
            <div class="text-base lg:text-lg text-base-content/60 pt-2.5 ml-1 lg:ml-3 mb-2">
              {{ post.publishDate.slice(-5) }}
            </div>
          </div>

          <div>
            <div class="w-1 h-full bg-base-content/7 rounded-full justify-self-center"></div>
          </div>

          <div class="ml-1 lg:ml-3 mb-4 lg:mb-8">
            <div
              class="w-fit group hover:text-primary hover:cursor-pointer text-shadow-primary/40 hover:text-shadow-xs"
              @click="router.push(`/posts/${post.id}`)"
            >
              <div
                class="text-lg lg:text-xl py-0.5 inline
                  bg-[linear-gradient(currentColor,currentColor)] bg-no-repeat bg-size-[0_2px] bg-bottom-left
                  group-hover:bg-size-[100%_2px] transition-[background-size] duration-300 ease-in-out"
              >
                {{ post.title }}
              </div>
            </div>

            <div class="flex flex-row items-center text-sm mt-1">
              <CategoryButton class="flex-none px-2 mr-1 lg:mr-3" :categoryName="post.category" />

              <div>
                <TagButton class="lg:mr-1 inline-block px-2" v-for="tag in post.tags" :tag="tag" :key="tag.name" />
              </div>
            </div>
          </div>
        </li>
      </ul>

    </div>
  </div>
</template>

<script setup>
import { computed, toRefs } from 'vue'
import { useRouter } from 'vue-router'
import CategoryButton from '@/components/Business/Category/CategoryButton.vue'
import TagButton from '@/components/Business/Tag/TagButton.vue'

const props = defineProps({
  posts: { type: Array, default: [] }
})
const { posts } = toRefs(props)
const router = useRouter()

const archiveList = computed(() => {
  const yearGroup = {}
  posts.value.forEach(item => {
    const year = new Date(item.publishDate).getFullYear().toString()
    if (!yearGroup[year]) {
      yearGroup[year] = { year, posts: [] }
    }
    yearGroup[year].posts.push(item)
  })

  Object.values(yearGroup).forEach(item => {
    item.posts.sort((a, b) => b.publishDate.localeCompare(a.publishDate))
  })

  return Object.values(yearGroup).sort((a, b) => b.year - a.year)
})
</script>

<style scoped>

</style>