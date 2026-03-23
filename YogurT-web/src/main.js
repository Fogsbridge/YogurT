import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from '@/App.vue'
import router from '@/router'

import { vTw } from '@/directives/tw.js'
import { vOverlayScroll } from '@/directives/overlayScroll.js'
import '@/assets/styles/index.css'

const pinia = createPinia()
const app = createApp(App)
app.use(pinia)
app.use(router)
app.directive('tw', vTw)
app.directive('overlay-scroll', vOverlayScroll)
app.mount('#app')