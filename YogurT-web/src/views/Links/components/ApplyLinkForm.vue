<template>
  <div>
    <div class="panel p-3 bg-base-content/1">
      <ul class="space-y-2.5">
        <li class="flex">
          <div class="size-5 bg-violet-400 rounded-full mr-2 mt-0.5 flex-none text-center text-white text-sm">1</div>
          <p class="text-base-content/85">申请前，请先在贵站添加本站为友情链接。</p>
        </li>
        <li class="flex">
          <div class="size-5 bg-violet-400 rounded-full mr-2 mt-0.5 flex-none text-center text-white text-sm">2</div>
          <p class="text-base-content/85">仅接受在中国大陆境内可稳定访问的站点。</p>
        </li>
        <li class="flex">
          <div class="size-5 bg-violet-400 rounded-full mr-2 mt-0.5 flex-none text-center text-white text-sm">3</div>
          <p class="text-base-content/85">贵站内容应符合法规。</p>
        </li>
        <li class="flex">
          <div class="size-5 bg-violet-400 rounded-full mr-2 mt-0.5 flex-none text-center text-white text-sm">4</div>
          <p class="text-base-content/85">若贵站移除本站链接，本站也将视情况适时移除。</p>
        </li>
      </ul>
    </div>

    <div class="mt-5">
      <form @submit.prevent="handleSubmit" class="space-y-4">
        <!-- 站点名称 -->
        <div>
          <label class="block text-sm text-base-content/70 mb-1.5 ml-2">站点名称</label>
          <input type="text"
                 class="w-full px-4 py-2 rounded-lg focus:bg-base-100 focus:border-primary focus:ring-2 focus:ring-primary/50 transition-all duration-200 outline-none"
                 :class="inputClass('siteName')"
                 placeholder="站点名称"
                 v-model.trim="formData.siteName"
                 @input="clearError('siteName')"
          />
          <p v-if="errors.siteName" class="mt-1.5 text-xs text-error">{{ errors.siteName }}</p>
        </div>

        <!-- 站点描述 -->
        <div>
          <label class="block text-sm text-base-content/70 mb-1.5 ml-1">站点描述</label>
          <textarea class="w-full px-4 py-2 rounded-lg focus:bg-base-100 focus:border-primary focus:ring-2 focus:ring-primary/50 transition-all duration-200 outline-none resize-none overflow-y-scroll scrollbar scrollbar-w-1.5 scrollbar-thumb-rounded-full scrollbar-corner-rounded-full scrollbar-track-rounded-full scrollbar-hover:cursor-pointer scrollbar-thumb-base-content/10 scrollbar-hover:scrollbar-thumb-base-content/20 dark:scrollbar-thumb-base-content/20 dark:scrollbar-hover:scrollbar-thumb-base-content/30"
                    :class="inputClass('description')"
                    rows="3"
                    placeholder="写点什么，让别人了解这个站点..."
                    v-model.trim="formData.description"
                    @input="clearError('description')"
          >
          </textarea>
          <p v-if="errors.description" class="mt-1.5 text-xs text-error ml-1">{{ errors.description }}</p>
        </div>

        <!-- 站点地址 -->
        <div>
          <label class="block text-sm text-base-content/70 mb-1.5 ml-1">站点地址</label>
          <input type="url"
                 class="w-full px-4 py-2 rounded-lg focus:bg-base-100 focus:border-primary focus:ring-2 focus:ring-primary/50 transition-all duration-200 outline-none"
                 :class="inputClass('siteUrl')"
                 placeholder="示例：https://domain.com"
                 v-model.trim="formData.siteUrl"
                 @input="clearError('siteUrl')"
          />
          <p v-if="errors.siteUrl" class="mt-1.5 text-xs text-error ml-1">{{ errors.siteUrl }}</p>
        </div>

        <!-- 头像地址 -->
        <div>
          <label class="block text-sm text-base-content/70 mb-1.5 ml-1">头像地址</label>
          <input type="url"
                 class="w-full px-4 py-2 rounded-lg focus:bg-base-100 focus:border-primary focus:ring-2 focus:ring-primary/50 transition-all duration-200 outline-none"
                 :class="inputClass('avatarUrl')"
                 placeholder="示例：https://domain.com/avatar.png"
                 v-model.trim="formData.avatarUrl"
                 @input="clearError('avatarUrl')"
          />
          <p v-if="errors.avatarUrl" class="mt-1.5 text-xs text-error ml-1">{{ errors.avatarUrl }}</p>
        </div>

        <!-- 订阅地址 -->
        <div>
          <label class="block text-sm text-base-content/70 mb-1.5 ml-1">订阅地址 <span class="text-xs text-base-content/50">(可选)</span></label>
          <input type="url"
                 class="w-full px-4 py-2 rounded-lg focus:bg-base-100 focus:border-primary focus:ring-2 focus:ring-primary/50 transition-all duration-200 outline-none"
                 :class="inputClass('subscribeUrl')"
                 placeholder="示例：https://domain.com/rss.xml"
                 v-model.trim="formData.subscribeUrl"
                 @input="clearError('subscribeUrl')"
          />
          <p v-if="errors.subscribeUrl" class="mt-1.5 text-xs text-error ml-1">{{ errors.subscribeUrl }}</p>
        </div>

        <!-- 电子邮箱 -->
        <div>
          <label class="block text-sm text-base-content/70 mb-1.5 ml-1">电子邮箱 <span class="text-xs text-base-content/50">(可选)</span></label>
          <input type="email"
                 class="w-full px-4 py-2 rounded-lg focus:bg-base-100 focus:border-primary focus:ring-2 focus:ring-primary/50 transition-all duration-200 outline-none"
                 :class="inputClass('email')"
                 placeholder="示例：name@domain.com"
                 v-model="formData.email"
                 @input="clearError('email')"
          />
          <p v-if="errors.email" class="mt-1.5 text-xs text-error ml-1">{{ errors.email }}</p>
        </div>

        <!-- 站点类型 -->
        <div>
          <label class="block text-sm text-base-content/70 mb-1.5 ml-1">站点类型 <span class="text-xs text-base-content/50">(选择1-2个站点类型)</span></label>
          <div class="flex flex-wrap gap-3">
            <label class="px-3 py-1.5 rounded-full border cursor-pointer transition duration-200"
                   v-for="type in siteTypes" :key="type"
                   :class="formData.types.includes(type)
                      ? 'bg-primary/7 border-primary/70 text-primary'
                      : 'bg-base-100 border-base-content/10 text-base-content/80 hover:border-primary/60'"
            >
              <input type="checkbox"
                     class="hidden"
                     :value="type"
                     v-model="formData.types"
                     @change="clearError('types')"
              />
              <span class="text-sm">{{ type }}</span>
            </label>
          </div>
          <p v-if="errors.types" class="mt-2 text-xs text-error ml-1">{{ errors.types }}</p>
        </div>

        <!-- 提交按钮 -->
        <div class="my-5">
          <button formnovalidate
                  type="submit"
                  class="w-full py-3 bg-linear-to-r from-violet-400 to-violet-500 text-base-100 rounded-xl shadow-md hover:shadow-lg hover:from-violet-600 hover:to-violet-700 focus:outline-none focus:ring-2 focus:ring-violet-500/50 transition duration-200 disabled:opacity-60 disabled:cursor-not-allowed"
                  :disabled="isSubmitting"
          >
            <span v-if="!isSubmitting">提交站点信息</span>
            <span v-else>提交中...</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { reactive, ref } from 'vue'

// 站点类型可选项
const siteTypes = ref(['技术', '生活', '工具', '聚合'])

// 表单信息
const formData = reactive({
  siteName: '',
  description: '',
  siteUrl: '',
  avatarUrl: '',
  subscribeUrl: '',
  email: '',
  types: []
})

// 错误信息
const errors = reactive({
  siteName: '',
  description: '',
  siteUrl: '',
  avatarUrl: '',
  subscribeUrl: '',
  email: '',
  types: ''
})

// 表单项样式（错误 / 正常）
const inputClass = (prop) => {
  if (errors[prop]) {
    return 'bg-error/5 border border-error/70'
  }

  return 'bg-base-content/2 dark:bg-base-content/5 border border-base-content/10 dark:border-base-content/20'
}

// 提交状态
const isSubmitting = ref(false)

// 清除错误信息
const clearError = (prop) => {
  if (errors[prop] === undefined) {
    return
  }
  errors[prop] = ''
}

// 验证 URL 格式
const isValidUrl = (url) => {
  const urlPattern = /^https?:\/\/[^.]+\..+$/
  return urlPattern.test(url)
}

// 验证邮箱格式
const isValidEmail = (email) => {
  const emailPattern = /^.+@.+\..+$/
  return emailPattern.test(email)
}

// 表单验证
const validateForm = () => {
  let isValid = true
  // 重置所有错误
  Object.keys(errors).forEach(key => clearError(key))

  // 站点名称验证（必填）
  if (!formData.siteName) {
    errors.siteName = '站点名称不能为空'
    isValid = false
  }

  // 站点描述验证（必填）
  if (!formData.description) {
    errors.description = '站点描述不能为空'
    isValid = false
  }

  // 站点地址验证（必填）
  if (!formData.siteUrl) {
    errors.siteUrl = '站点地址不能为空'
    isValid = false
  } else if (!isValidUrl(formData.siteUrl)) {
    errors.siteUrl = '请输入有效的地址（以 http:// 或 https:// 开头）'
    isValid = false
  }

  // 头像地址验证（必填）
  if (!formData.avatarUrl) {
    errors.avatarUrl = '头像地址不能为空'
    isValid = false
  } else if (!isValidUrl(formData.avatarUrl)) {
    errors.avatarUrl = '请输入有效的地址（以 http:// 或 https:// 开头）'
    isValid = false
  }

  // 订阅地址验证（选填）
  if (formData.subscribeUrl && !isValidUrl(formData.subscribeUrl)) {
    errors.subscribeUrl = '请输入有效的地址（以 http:// 或 https:// 开头）'
    isValid = false
  }

  // 邮箱验证（选填）
  if (formData.email && !isValidEmail(formData.email)) {
    errors.email = '请输入有效的邮箱，例如：name@domain.com'
    isValid = false
  }

  // 站点类型验证（必填，至少选择一个，最多选择两个）
  if (formData.types.length === 0) {
    errors.types = '请至少选择一个站点类型'
    isValid = false
  } else if (formData.types.length > 2) {
    errors.types = '最多选择两个站点类型'
    isValid = false
  }

  return isValid
}

// 处理提交
const handleSubmit = async () => {
  // 验证表单数据
  if (!validateForm()) {
    return
  }

  isSubmitting.value = true

  setTimeout(() => {
    console.log(formData)

    alert('提交成功！')
    isSubmitting.value = false
  }, 1000)
}
</script>

<style scoped>

</style>