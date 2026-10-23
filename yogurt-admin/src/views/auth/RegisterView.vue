<!--
 * 注册页视图组件
 *
 * @author fogsbridge
 * @since 1.0.0
-->
<script setup>
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from '@/components/ui/card/index.js'
import { Button } from '@/components/ui/button/index.js'
import { Input } from '@/components/ui/input/index.js'
import { Field, FieldError, FieldGroup, FieldLabel } from '@/components/ui/field/index.js'
import { useForm } from '@tanstack/vue-form'
import { registerDefaults, registerSchema } from '@/validators/auth/register.js'
import { useRegisterMutation } from '@/composables/queries/useAuth.js'
import { toast } from 'vue-sonner'
import { Spinner } from '@/components/ui/spinner/index.js'
import { useRouter } from 'vue-router'
import { useAuthStore } from '@/stores/auth.js'
import { ROUTE_NAME } from '@/constants/route-name.js'
import AuthTitle from '@/views/auth/components/AuthTitle.vue'

const router = useRouter()
const authStore = useAuthStore()

const { mutateAsync, isPending } = useRegisterMutation()

const form = useForm({
  defaultValues: registerDefaults,
  validators: {
    onSubmit: registerSchema,
    onChange: registerSchema,
  },
  onSubmit: async ({ value }) => {
    const { confirmPassword: _confirmPassword, ...payload } = value
    try {
      const response = await mutateAsync(payload)
      toast.success('注册成功')
      authStore.setToken(response.data.data.token)
      router.replace({ name: ROUTE_NAME.INDEX })
    } catch (error) {
      toast.error(error.response?.data?.message)
    }
  },
})

const isInvalid = (field) => field.state.meta.isTouched && !field.state.meta.isValid

const fields = [
  {
    name: 'username',
    label: '用户名',
    type: 'text',
    placeholder: '请输入用户名',
    autocomplete: 'username',
  },
  {
    name: 'email',
    label: '电子邮箱',
    type: 'email',
    placeholder: '请输入邮箱地址',
    autocomplete: 'email',
  },
  {
    name: 'password',
    label: '密码',
    type: 'password',
    placeholder: '请输入密码',
    autocomplete: 'new-password',
  },
  {
    name: 'confirmPassword',
    label: '确认密码',
    type: 'password',
    placeholder: '请再次输入密码',
    autocomplete: 'new-password',
  },
]
</script>

<template>
  <main class="flex flex-col gap-6 items-center justify-center min-h-screen w-full p-4">
    <AuthTitle />
    <Card class="w-full max-w-sm mx-auto">
      <CardHeader>
        <CardTitle class="text-lg">创建账号</CardTitle>
      </CardHeader>
      <CardContent>
        <form novalidate @submit.prevent="form.handleSubmit">
          <FieldGroup class="flex flex-col gap-4">
            <form.Field v-for="item in fields" :key="item.name" :name="item.name">
              <template #default="{ field }">
                <Field class="gap-2">
                  <FieldLabel :for="field.name">{{ item.label }}</FieldLabel>
                  <Input
                    :id="field.name"
                    :name="field.name"
                    class="aria-invalid:border-destructive/50 placeholder:opacity-50"
                    :type="item.type"
                    :placeholder="item.placeholder"
                    required
                    :autocomplete="item.autocomplete"
                    :aria-invalid="isInvalid(field)"
                    :model-value="field.state.value"
                    @input="field.handleChange($event.target.value)"
                  />
                  <FieldError
                    v-if="isInvalid(field)"
                    :errors="field.state.meta.errors"
                    class="text-xs opacity-70"
                  />
                </Field>
              </template>
            </form.Field>

            <Field class="mt-2">
              <Button :disabled="isPending" type="submit" class="w-full">
                <template v-if="isPending">
                  <Spinner />
                  注册中
                </template>
                <template v-else>注册</template>
              </Button>
            </Field>
          </FieldGroup>
        </form>
      </CardContent>
      <CardFooter>
        <CardDescription>
          已有账号？
          <Button variant="link" class="px-0" as-child>
            <RouterLink :to="{ name: ROUTE_NAME.LOGIN }">前去登录</RouterLink>
          </Button>
        </CardDescription>
      </CardFooter>
    </Card>
  </main>
</template>
