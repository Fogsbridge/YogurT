/**
 * 登录表单校验规则
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { z } from 'zod'

export const loginSchema = z.object({
  username: z.string().trim().min(1, { error: '请输入用户名', abort: true }),
  password: z.string().min(1, { error: '请输入密码', abort: true }),
})

export const loginDefaults = {
  username: '',
  password: '',
}
