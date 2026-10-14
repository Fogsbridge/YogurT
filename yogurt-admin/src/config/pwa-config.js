/**
 * pwa 配置
 * 提供给 vite-plugin-pwa
 *
 * @author fogsbridge
 * @since 1.0.0
 */
export function createPwaOptions(env) {
  return {
    registerType: 'autoUpdate',
    includeAssets: ['favicon.ico', 'favicon.svg', 'apple-touch-icon.png'],
    manifest: {
      name: env.VITE_SITE_NAME,
      short_name: '',
      description: '',
      theme_color: '#F8FAFC',
      background_color: '#F8FAFC',
      display: 'standalone',
      start_url: env.VITE_BASE_URL,
      icons: [
        {
          src: `${env.VITE_BASE_URL}pwa-192x192.png`,
          sizes: '192x192',
          type: 'image/png',
          purpose: 'any',
        },
        {
          src: `${env.VITE_BASE_URL}pwa-512x512.png`,
          sizes: '512x512',
          type: 'image/png',
          purpose: 'any',
        },
        {
          src: `${env.VITE_BASE_URL}maskable-512x512.png`,
          sizes: '512x512',
          type: 'image/png',
          purpose: 'maskable',
        },
      ],
    },
  }
}
