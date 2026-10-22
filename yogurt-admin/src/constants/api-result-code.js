/**
 * api 业务状态码
 *
 * @author fogsbridge
 * @since 1.0.0
 */
export const ApiResultCode = {
  // 通用
  SUCCESS: { code: 2000, message: '成功' },
  PARAMETER_ERROR: { code: 4000, message: '参数错误' },
  SERVER_ERROR: { code: 5000, message: '服务器内部错误' },

  // 注册业务错误 (10xxx)
  USERNAME_EXISTS: { code: 10001, message: '用户名已被注册' },
  EMAIL_EXISTS: { code: 10002, message: '邮箱已被注册' },
  REGISTER_CLOSE: { code: 10003, message: '注册已关闭' },

  // 登录业务错误（11xxx)
  LOGIN_FAILED: { code: 11001, message: '用户名或密码错误' },

  // 认证业务错误 (12xxx)
  NOT_LOGGED_IN: { code: 12001, message: '未登录，请先登录' },
  INVALID_TOKEN: { code: 12002, message: '无效的 Token' },
  LOGIN_EXPIRED: { code: 12003, message: '登录状态已失效，请重新登录' },
}
