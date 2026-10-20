import { fileURLToPath, URL } from 'node:url'
import { defineConfig, loadEnv } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'
import tailwindcss from '@tailwindcss/vite'
import { VitePWA } from 'vite-plugin-pwa'
import { createPwaOptions } from './src/config/pwa.js'

// https://vite.dev/config/
export default defineConfig(({ mode }) => {
  const env = loadEnv(mode, process.cwd())

  return {
    build: {
      // TODO: Vite 8 无法识别 Tailwind v4 的 @theme，替换为 esbuild
      // https://github.com/vitejs/vite/issues/21911
      cssMinify: 'esbuild',
    },
    plugins: [vue(), vueDevTools(), tailwindcss(), VitePWA(createPwaOptions(env))],
    resolve: {
      alias: {
        '@': fileURLToPath(new URL('./src', import.meta.url)),
      },
    },
    server: {
      proxy: {
        '/api': {
          target: env.VITE_DEV_PROXY_TARGET,
          changeOrigin: true,
        },
      },
    },
    base: env.VITE_BASE_URL,
  }
})
