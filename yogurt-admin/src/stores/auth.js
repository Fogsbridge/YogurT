/**
 * 认证 store
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useAuthStore = defineStore(
  'auth',
  () => {
    const token = ref('')

    const setToken = (newToken) => {
      token.value = newToken
    }

    const clearToken = () => {
      token.value = ''
    }

    return { token, setToken, clearToken }
  },
  {
    persist: true,
  },
)
