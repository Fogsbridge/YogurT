<template>
  <ol class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-2 md:gap-4">
    <li v-for="entry in guestbookEntries" :key="entry.id">
      <GuestbookEntryCard :name="entry.name" :content="entry.content" :date="entry.date" :likeCount="entry.likeCount" />
    </li>
  </ol>
</template>

<script setup>
import GuestbookEntryCard from '@/components/Business/Guestbook/GuestbookEntryCard.vue'

const props = defineProps({
  guestbookEntries: { type: Array, required: true }
})

</script>

<style scoped>

</style>