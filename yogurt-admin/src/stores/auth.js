/**
 * 认证 store
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { defineStore } from 'pinia'
import { computed, ref } from 'vue'

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

    const isAuthenticated = computed(() => !!token.value)

    return { token, setToken, clearToken, isAuthenticated }
  },
  {
    persist: true,
  },
)
