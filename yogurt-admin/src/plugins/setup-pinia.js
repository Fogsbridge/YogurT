/**
 * pinia 注册
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import { createPinia } from 'pinia'
import { createPersistedState } from 'pinia-plugin-persistedstate'

const pinia = createPinia()

const persistedState = createPersistedState({
  storage: localStorage,
})
pinia.use(persistedState)

export function setupPinia(app) {
  app.use(pinia)
}
