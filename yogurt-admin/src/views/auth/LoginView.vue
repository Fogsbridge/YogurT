<!--
 * 登录页视图组件
 *
 * @author fogsbridge
 * @since 1.0.0
-->
<script setup>
import { Button } from '@/components/ui/button/index.js'
import { Field, FieldError, FieldGroup, FieldLabel } from '@/components/ui/field/index.js'
import { Input } from '@/components/ui/input/index.js'
import { Spinner } from '@/components/ui/spinner/index.js'
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from '@/components/ui/card/index.js'
import { useForm } from '@tanstack/vue-form'
import { toast } from 'vue-sonner'
import { loginDefaults, loginSchema } from '@/validators/auth/login.js'
import { ROUTE_NAME } from '@/constants/route-name.js'
import AuthTitle from '@/views/auth/components/AuthTitle.vue'
import { useLoginMutation } from '@/composables/queries/useAuth.js'
import { useRoute, useRouter } from 'vue-router'
import { useAuthStore } from '@/stores/auth.js'

const router = useRouter()
const route = useRoute()
const authStore = useAuthStore()

const { mutateAsync, isPending } = useLoginMutation()

const form = useForm({
  defaultValues: loginDefaults,
  validators: {
    onSubmit: loginSchema,
    onChange: loginSchema,
  },
  onSubmit: async ({ value }) => {
    try {
      const response = await mutateAsync(value)
      toast.success('登录成功')
      authStore.setToken(response.data.data.token)
      const redirect = route.query.redirect
      const target = typeof redirect === 'string' ? redirect : { name: ROUTE_NAME.INDEX }
      router.replace(target)
    } catch (error) {
      if (error.response) toast.error(error.response.data?.message)
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
    name: 'password',
    label: '密码',
    type: 'password',
    placeholder: '请输入密码',
    autocomplete: 'new-password',
  },
]
</script>

<template>
  <main class="flex flex-col gap-6 items-center justify-center min-h-screen w-full p-4">
    <AuthTitle />
    <Card class="w-full max-w-sm mx-auto">
      <CardHeader>
        <CardTitle class="text-lg">登录账号</CardTitle>
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
                  登录中
                </template>
                <template v-else>登录</template>
              </Button>
            </Field>
          </FieldGroup>
        </form>
      </CardContent>
      <CardFooter>
        <CardDescription>
          还未注册？
          <Button variant="link" class="px-0" as-child>
            <RouterLink :to="{ name: ROUTE_NAME.REGISTER }">前往注册</RouterLink>
          </Button>
        </CardDescription>
      </CardFooter>
    </Card>
  </main>
</template>
