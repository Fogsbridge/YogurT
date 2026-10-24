import { createRouter, createWebHistory } from 'vue-router'
import { routes } from '@/router/routes.js'
import { setupProgressGuard } from '@/router/guard/progress-guard.js'
import { setupAuthGuard } from '@/router/guard/auth-guard.js'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: routes,
})

setupProgressGuard(router)
setupAuthGuard(router)

export { router }
