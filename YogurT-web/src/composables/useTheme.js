import { onMounted, ref, watch } from 'vue'
import { usePreferredColorScheme } from '@vueuse/core'

const THEMES = ['system', 'light', 'dark']
const STORAGE_KEY = 'theme'

const currentTheme = ref('')
const systemTheme = usePreferredColorScheme()

// 设置主题
const applyTheme = (theme) => {
    document.documentElement.setAttribute('data-theme', theme === 'system' ? systemTheme.value : theme)
    localStorage.setItem(STORAGE_KEY, theme)
    currentTheme.value = theme
}

// 循环切换主题
const cycleTheme = () => {
    applyTheme(THEMES[(THEMES.indexOf(currentTheme.value) + 1) % THEMES.length])
}

export function useTheme() {
    onMounted(() => {
        applyTheme(localStorage.getItem(STORAGE_KEY) || 'system')
    })

    watch(systemTheme, () => applyTheme('system'))

    return {
        currentTheme,
        applyTheme,
        cycleTheme
    }
}