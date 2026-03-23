<template>
  <div>
    <div @click="openModal">
      <slot name="btn" />
    </div>

    <dialog ref="dialogRef" v-bind="$attrs" @cancel.prevent="closeModal" class="open:flex panel py-4 m-auto backdrop:bg-black/30 backdrop:backdrop-blur-xs" :class="{ 'closing': isClosing }">
      <div class="flex flex-col px-6" v-overlay-scroll>
        <div class="sticky top-0 bg-base-100 flex items-center justify-between gap-10 pb-4">
          <h1 class="text-lg">{{ title }}</h1>
          <button @click="closeModal" class="size-6 cursor-pointer hover:text-primary hover:scale-120  transition duration-300">
            <svg fill="none" stroke-width="1.5" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" d="M6 18 18 6M6 6l12 12"></path>
            </svg>
          </button>
        </div>

        <div>
          <slot name="content" />
        </div>
      </div>
    </dialog>
  </div>
</template>

<script setup>
import { onUnmounted, ref, useTemplateRef } from 'vue'
import { useScrollLock } from '@vueuse/core'

defineOptions({ inheritAttrs: false })
const props = defineProps({ title: { type: String } })

const dialogRef = useTemplateRef('dialogRef')
const isLocked = useScrollLock(window)
const isClosing = ref(false)

const openModal = () => {
  dialogRef.value.showModal()
  isLocked.value = true
}

const closeTimer = ref(null)
const closeModal = () => {
  isClosing.value = true
  isLocked.value = false

  if (closeTimer.value) {
    clearTimeout(closeTimer.value)
    closeTimer.value = null
  }
  // 等待动画执行完后再关闭
  closeTimer.value = setTimeout(() => {
    dialogRef.value.close()
    isClosing.value = false
  },400)
}

onUnmounted(() => {
  clearTimeout(closeTimer.value)
})
</script>

<style scoped>
dialog {
  animation: fadeIn 300ms ease forwards, contentIn 200ms ease forwards;
  &::backdrop {
    animation: fadeIn 400ms ease forwards;
  }
}

dialog.closing {
  animation: fadeOut 300ms ease forwards, contentOut 200ms ease forwards;
  &::backdrop {
    animation: fadeOut 400ms ease forwards;
  }
}

@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

@keyframes fadeOut {
  from {
    opacity: 1;
  }
  to {
    opacity: 0;
  }
}

@keyframes contentIn {
  from {
    scale: 95%;
  }
  to {
    scale: 100%;
  }
}

@keyframes contentOut {
  from {
    scale: 100%;
  }
  to {
    scale: 95%;
  }
}
</style>