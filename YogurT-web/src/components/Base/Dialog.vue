<template>
  <Teleport :disabled="!show" to="body">
    <div class="fixed flex items-center bg-black/20 inset-0 z-1000 before:backdrop-blur-xs before:absolute before:inset-0 before:-z-1 transition"
         v-if="show"
    >
      <div v-bind="$attrs" class="panel px-4 pt-2 pb-4 mx-auto">
        <div class="flex items-center justify-between gap-10 mb-4">
          <h1 class="text-lg">申请友链</h1>
          <button @click="close" class="size-6 cursor-pointer hover:text-primary hover:scale-120 duration-300">
            <svg fill="none" stroke-width="1.5" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" d="M6 18 18 6M6 6l12 12"></path>
            </svg>
          </button>
        </div>

        <div>
          <slot />
        </div>
      </div>
    </div>
  </Teleport>
</template>

<script setup>
defineOptions({ inheritAttrs: false })
const props = defineProps({
  title: { type: String }
})

const show = defineModel('show', { required: true })

const close = () => show.value = false
</script>

<style scoped>

</style>