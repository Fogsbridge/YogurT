<template>
  <div class="panel px-6 py-4 flex flex-col">
    <h2 class="font-bold border-l-4 border-primary pl-3 mb-4 flex-none">关于友链</h2>
    <ul class="space-y-3 flex-1">
      <li class="flex">
        <div class="size-1.5 bg-primary rounded-full mt-2 mr-2.5 flex-none"></div>
        <p class="text-base-content/85">友链顺序完全随机，每次进入页面（包括刷新）都会重新排序。</p>
      </li>
      <li class="flex">
        <div class="size-1.5 bg-primary rounded-full mt-2 mr-2.5 flex-none"></div>
        <p class="text-base-content/85">为保证友链质量，每日 00:00 至 00:30 期间会对所有友链进行可访问性验证。<br />若连续 3 日无法访问，则自动标记为<span class="bg-error/15 rounded-full px-2 text-sm text-error inline-block">异常</span>（仍保留展示），待下次验证通过后，取消异常标签。<br />若连续 15 日无法访问，该友链将被删除。</p>
      </li>
      <li class="flex">
        <div class="size-1.5 bg-primary rounded-full mt-2 mr-2.5 flex-none"></div>
        <p class="text-base-content/85">若贵站移除本站链接，本站也将视情况适时移除。</p>
      </li>
    </ul>
    <div class="flex-none justify-self-end self-end mt-4">
      <div>
        <Dialog title="申请友链" class="max-w-4/5 max-h-4/5 md:max-w-1/2">
          <template #btn>
            <button class="bg-primary/90 rounded-lg text-white px-2.5 py-1 hover:bg-primary cursor-pointer transition-color duration-300">
              申请友链
            </button>
          </template>
          <template #content>
            <ApplyLinkForm class="p-2" />
          </template>
        </Dialog>
      </div>
    </div>
  </div>
</template>

<script setup>
import Dialog from '@/components/Base/Dialog.vue'
import ApplyLinkForm from '@/views/Links/components/ApplyLinkForm.vue'

</script>

<style scoped>

</style>