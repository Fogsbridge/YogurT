<template>
  <form class="flex flex-col gap-2 md:gap-3" :class="show ? 'block' : 'hidden'">
    <div class="rounded-lg md:rounded-xl border border-base-content/6 dark:border-base-content/12
                hover:border-base-content/25 focus-within:border-primary/80 hover:focus-within:border-primary/80
                focus-within:ring focus-within:ring-primary/80 duration-200"
         :class="variant === 'comment' ? 'bg-base-200/40' : 'bg-base-100'"
    >
      <div class="relative md:resize-y h-50 md:h-40 min-h-40 max-h-100 overflow-y-auto my-1 ml-2 mr-2 pb-6 md:my-2 md:ml-4 md:mr-2 md:pb-7.5">
        <div class="text-sm md:text-base">
          <textarea class="w-full h-full outline-none ring-0 border-0 caret-primary resize-none"
                    placeholder="友善评论，理性发言～"
                    v-model.trim="formData.content"
          >
          </textarea>
        </div>
        <div class="absolute bottom-0 left-0 flex flex-row gap-2">
          <!--
            TODO: 表情、图片
          -->
          <div class="text-base-content/50">
            表情
          </div>
          <div class="text-base-content/50">
            图片
          </div>
        </div>
        <div class="absolute bottom-0 right-0 md:right-5 text-2xs md:text-xs text-base-content/60"
             :class="formData.content.length > 1000 ? 'text-error' : 'text-base-content/60'"
        >
          {{ formData.content.length }} / 1000
        </div>
      </div>
    </div>

    <div class="flex flex-col md:flex-row gap-2 md:gap-3 text-sm md:text-base">
      <div class="flex-2 focus-within:flex-3 min-w-0 overflow-clip flex flex-row rounded-lg md:rounded-xl border border-base-content/6
                  dark:border-base-content/12 hover:border-base-content/25 focus-within:border-primary/80
                  hover:focus-within:border-primary/80 focus-within:ring focus-within:ring-primary/80 duration-200"
           :class="variant === 'comment' ? 'bg-base-200/40' : 'bg-base-100'"
      >
        <span class="px-2 py-1.5 md:px-3 md:py-2 text-nowrap border-r border-r-base-content/6"
              :class="variant === 'comment' ? 'bg-base-100' : 'bg-base-200/40'"
        >昵称
        </span>
        <input type="text"
               class="px-2 py-1.5 md:px-3 md:py-2 outline-none min-w-0"
               placeholder="必填"
               v-model.trim="formData.name"
        />
      </div>

      <div class="flex-2 focus-within:flex-3 min-w-0 overflow-clip flex flex-row rounded-lg md:rounded-xl border border-base-content/6
                  dark:border-base-content/12 hover:border-base-content/25 focus-within:border-primary/80
                  hover:focus-within:border-primary/80 focus-within:ring focus-within:ring-primary/80 duration-200"
           :class="variant === 'comment' ? 'bg-base-200/40' : 'bg-base-100'"
      >
        <span class="px-2 py-1.5 md:px-3 md:py-2 text-nowrap border-r border-r-base-content/6"
              :class="variant === 'comment' ? 'bg-base-100' : 'bg-base-200/40'"
        >邮箱
        </span>
        <input type="email"
               class="px-2 py-1.5 md:px-3 md:py-2 outline-none min-w-0"
               placeholder="选填"
               v-model.trim="formData.email"
        />
      </div>

      <div class="flex-2 focus-within:flex-3 min-w-0 overflow-clip flex flex-row rounded-lg md:rounded-xl border border-base-content/6
                  dark:border-base-content/12 hover:border-base-content/25 focus-within:border-primary/80
                  hover:focus-within:border-primary/80 focus-within:ring focus-within:ring-primary/80 duration-200"
           :class="variant === 'comment' ? 'bg-base-200/40' : 'bg-base-100'"
      >
        <span class="px-2 py-1.5 md:px-3 md:py-2 text-nowrap border-r border-r-base-content/6"
              :class="variant === 'comment' ? 'bg-base-100' : 'bg-base-200/40'"
        >网址
        </span>
        <input type="url"
               class="px-2 py-1.5 md:px-3 md:py-2 outline-none min-w-0"
               placeholder="选填"
               v-model.trim="formData.siteUrl"
        />
      </div>

      <button type="button"
              class="flex-none text-nowrap px-3 py-1.5 md:px-4 md:py-2 bg-base-100 rounded-lg md:rounded-xl border border-base-content/6
                     dark:border-base-content/12 hover:bg-gray-500 hover:text-white cursor-pointer duration-200"
              :class="variant === 'subComment' ? 'block' : 'hidden'"
              @click.stop="emit('close')"
      >取消
      </button>

      <button formnovalidate
              type="submit"
              class="flex-none text-nowrap px-3 py-1.5 md:px-4 md:py-2 bg-base-100 rounded-lg md:rounded-xl border border-base-content/6
                     dark:border-base-content/12 hover:bg-primary hover:text-white cursor-pointer duration-200"
              :disabled="false"
      >发送
      </button>
    </div>
  </form>
</template>

<script setup>
import { reactive } from 'vue'

const props = defineProps({
  targetType: { type: String, required: true, validator: v => ['post', 'guestbook'].includes(v) },
  targetId: { type: String, required: true },
  parentId: { type: String, required: false, default: null },
  variant: { type: String, default: 'comment', validator: v => ['comment', 'subComment'].includes(v) },
  show: { type: Boolean, default: true }
})

const emit = defineEmits(['close'])

const formData = reactive({
  content: '',
  name: '',
  email: '',
  siteUrl: ''
})
</script>

<style scoped>

</style>