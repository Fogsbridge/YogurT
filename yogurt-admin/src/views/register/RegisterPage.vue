<!--
 * 登录页视图组件
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

const router = useRouter()
const authStore = useAuthStore()

const { debouncedMutate, isPending } = useRegisterMutation({
  onError: (error) => {
    toast.error(error.response?.data?.message)
  },
  onSuccess: (response) => {
    toast.success('注册成功')
    authStore.setToken(response.data.data.token)
    router.replace('/')
  },
})

const form = useForm({
  defaultValues: registerDefaults,
  validators: {
    onSubmit: registerSchema,
    onChange: registerSchema,
  },
  onSubmit: ({ value }) => {
    const { confirmPassword: _confirmPassword, ...payload } = value
    debouncedMutate(payload)
  },
})

const isInvalid = (field) => field.state.meta.isTouched && !field.state.meta.isValid
</script>

<template>
  <div class="flex items-center justify-center min-h-screen min-w-screen p-4">
    <main class="flex flex-col gap-4">
      <Card class="w-sm max-w-md mx-auto">
        <CardHeader>
          <CardTitle class="text-xl">创建账号</CardTitle>
        </CardHeader>
        <CardContent>
          <form @submit.prevent="form.handleSubmit" novalidate>
            <FieldGroup class="flex flex-col gap-4">
              <form.Field name="username">
                <template #default="{ field }">
                  <Field class="gap-2">
                    <FieldLabel :for="field.name">用户名</FieldLabel>
                    <Input
                      :id="field.name"
                      :name="field.name"
                      class="aria-invalid:border-destructive/50"
                      type="text"
                      placeholder="username"
                      required
                      autocomplete="username"
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

              <form.Field name="email">
                <template #default="{ field }">
                  <Field class="gap-2">
                    <FieldLabel :for="field.name">电子邮箱</FieldLabel>
                    <Input
                      :id="field.name"
                      :name="field.name"
                      class="aria-invalid:border-destructive/50"
                      type="email"
                      placeholder="example@example.com"
                      required
                      autocomplete="email"
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

              <form.Field name="password">
                <template #default="{ field }">
                  <Field class="gap-2">
                    <FieldLabel :for="field.name">密码</FieldLabel>
                    <Input
                      :id="field.name"
                      :name="field.name"
                      class="aria-invalid:border-destructive/50"
                      type="password"
                      placeholder="******"
                      required
                      autocomplete="new-password"
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

              <form.Field name="confirmPassword">
                <template #default="{ field }">
                  <Field class="gap-2">
                    <FieldLabel :for="field.name">确认密码</FieldLabel>
                    <Input
                      :id="field.name"
                      :name="field.name"
                      class="aria-invalid:border-destructive/50"
                      type="password"
                      placeholder="******"
                      required
                      autocomplete="new-password"
                      :model-value="field.state.value"
                      :aria-invalid="isInvalid(field)"
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
                    注册中...
                  </template>
                  <template v-else> 注册 </template>
                </Button>
              </Field>
            </FieldGroup>
          </form>
        </CardContent>
        <CardFooter>
          <CardDescription>
            已有账号？
            <Button variant="link" class="px-0">前去登录</Button>
          </CardDescription>
        </CardFooter>
      </Card>
    </main>
  </div>
</template>
