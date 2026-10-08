/**
 * 注册表单校验规则
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { z } from 'zod'

export const registerSchema = z
  .object({
    username: z
      .string()
      .trim()
      .min(1, { error: '请输入用户名', abort: true })
      .regex(/^[a-zA-Z0-9]+$/, { error: '用户名只能包含大小写字母和数字', abort: true })
      .max(32, '用户名最多 32 个字符'),
    email: z
      .email({ error: '请输入有效的邮箱地址', abort: true })
      .trim()
      .max(254, { error: '邮箱长度不能超过 254 个字符' }),
    password: z
      .string()
      .min(1, { error: '请输入密码', abort: true })
      .min(6, '密码至少 6 位')
      .max(64, '密码最多 64 位'),
    confirmPassword: z.string().min(1, { error: '请重新确认密码', abort: true }),
  })
  .refine((data) => data.password === data.confirmPassword, {
    error: '密码不一致',
    path: ['confirmPassword'],
  })

export const registerDefaults = {
  username: '',
  email: '',
  password: '',
  confirmPassword: '',
}
