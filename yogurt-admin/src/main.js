import './assets/main.css'
import './assets/semantic-colors.css'
import './assets/global.css'
import 'vue-sonner/style.css'

import { createApp } from 'vue'
import App from './App.vue'
import { setupPlugins } from '@/plugins/index.js'

const app = createApp(App)
setupPlugins(app)

app.mount('#app')
