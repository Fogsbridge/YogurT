import { createApp } from 'vue'
import App from '@/App.vue'
import router from '@/router'
import '@/assets/styles/index.css'
import { vTw } from '@/directives/tw.js'

const app = createApp(App)
app.use(router)
app.directive('tw', vTw)
app.mount('#app')