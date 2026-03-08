<template>
  <Teleport defer to="[data-role='banner']">
    <div v-bind="$attrs" class="relative  bg-cover bg-center" :style="{ 'background-image': `url(${imgUrl})` }">
<!--      <div class="absolute inset-0 bg-black/15 dark:bg-black/30 transition duration-500"></div>-->
<!--      <div class="absolute inset-0 bg-linear-to-b from-transparent from-90% to-base-200 transition duration-500"></div>-->
<!--      <div class="relative">-->
        <slot />
<!--      </div>-->
    </div>
  </Teleport>
</template>

<script setup>
import { useNavbarFloat } from '@/composables/useNavbarFloat.js'
import { onMounted, onUnmounted } from 'vue'

defineOptions({
  inheritAttrs: false
})

const props = defineProps({
  imgUrl: { type: String, default: '/images/banner/banner-5.jpg' }
})

const { setNavbarFloat } = useNavbarFloat()

onMounted(() => {
  setNavbarFloat(true)
})

onUnmounted(() => {
  setNavbarFloat(false)
})
</script>

<style scoped>

</style>