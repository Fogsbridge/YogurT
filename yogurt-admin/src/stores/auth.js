/**
 * 认证 store
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { defineStore } from 'pinia'
import { computed, ref } from 'vue'

// 状态机：未认证、已认证、已过期
const STATUS = {
  UNAUTHENTICATED: 'unauthenticated',
  AUTHENTICATED: 'authenticated',
  EXPIRED: 'expired',
}

export const useAuthStore = defineStore(
  'auth',
  () => {
    const token = ref('')

    const expired = ref(false)

    // 判断当前认证状态
    const status = computed(() => {
      if (expired.value) return STATUS.EXPIRED
      return token.value ? STATUS.AUTHENTICATED : STATUS.UNAUTHENTICATED
    })

    // 只在当前处于已认证状态下才能转为已过期状态
    const tryMarkExpired = () => {
      if (!isAuthenticated.value) return false
      expired.value = true
      return true
    }

    // 清除已过期状态
    const resetExpired = () => {
      expired.value = false
    }

    // 存入 Token，状态转为已认证
    const setToken = (newToken) => {
      token.value = newToken
      expired.value = false
    }

    // 清理 Token
    const clearToken = () => {
      token.value = ''
    }

    const isAuthenticated = computed(() => {
      return status.value === STATUS.AUTHENTICATED
    })

    const isExpired = computed(() => {
      return status.value === STATUS.EXPIRED
    })

    return {
      token,
      isAuthenticated,
      isExpired,
      setToken,
      clearToken,
      tryMarkExpired,
      resetExpired,
    }
  },
  {
    persist: {
      pick: ['token'],
    },
  },
)
