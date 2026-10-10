/**
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

    const setToken = (token) => {
      token.value = token
    }

    const clearToken = () => {
      token.value = ''
    }

    return { token, setToken, clearToken }
  },
  {
    persist: {
      key: 'auth',
      storage: localStorage,
      pick: ['token'],
    },
  },
)
