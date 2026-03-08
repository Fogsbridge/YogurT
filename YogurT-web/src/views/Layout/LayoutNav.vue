<template>
  <nav data-role="layout-nav" :class="{'pt-15': !isNavbarFloat}">
    <div :class="navClass">
      <div class="max-w-8xl inline-flex grow mx-auto px-6">

        <!-- 左侧 -->
        <div class="navbar-start flex-1 lg:flex-initial">
          <div class="dropdown dropdown-start lg:hidden">
            <div tabindex="0" role="button" :class="[navBtnClass, 'nav__icon-btn']">
              <svg fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                <path clip-rule="evenodd" fill-rule="evenodd" d="M2 4.75A.75.75 0 0 1 2.75 4h14.5a.75.75 0 0 1 0 1.5H2.75A.75.75 0 0 1 2 4.75Zm0 10.5a.75.75 0 0 1 .75-.75h14.5a.75.75 0 0 1 0 1.5H2.75a.75.75 0 0 1-.75-.75ZM2 10a.75.75 0 0 1 .75-.75h7.5a.75.75 0 0 1 0 1.5h-7.5A.75.75 0 0 1 2 10Z"></path>
              </svg>
            </div>
            <div tabindex="-1" class="dropdown-content">
              <ul class="menu menu-lg bg-base-100/95 text-base-content backdrop-blur-md text-shadow-sm w-26 mt-5 items-center rounded-box z-100 shadow-2xl ">
                <li><a>归档</a></li>
                <li><a>分类</a></li>
                <li><a>标签</a></li>
                <li><a>动态</a></li>
                <li><a>友人帐</a></li>
                <li><a>关于我</a></li>
              </ul>
            </div>
          </div>
          <RouterLink to="/" :class="[navBtnClass, 'text-xl!']">
            <div>
              云桥雾的<Typewriter :text="['Blog', '博客']" cursorClass="bg-current pl-0.5 ml-0.5" typingDelay="300" preDeleteDelay="5000" preNextTextDelay="200" />
            </div>
          </RouterLink>
        </div>

        <!-- 中间导航区域 -->
        <div class="navbar-center hidden lg:flex">
          <ul class="menu menu-horizontal py-0 gap-3">
            <li>
              <RouterLink to="/archives" :class="navBtnClass">
                <svg data-slot="icon" fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                  <path d="M3.375 3C2.339 3 1.5 3.84 1.5 4.875v.75c0 1.036.84 1.875 1.875 1.875h17.25c1.035 0 1.875-.84 1.875-1.875v-.75C22.5 3.839 21.66 3 20.625 3H3.375Z"></path>
                  <path clip-rule="evenodd" fill-rule="evenodd" d="m3.087 9 .54 9.176A3 3 0 0 0 6.62 21h10.757a3 3 0 0 0 2.995-2.824L20.913 9H3.087Zm6.163 3.75A.75.75 0 0 1 10 12h4a.75.75 0 0 1 0 1.5h-4a.75.75 0 0 1-.75-.75Z"></path>
                </svg>
                <span>归档</span>
              </RouterLink>
            </li>
            <li>
              <RouterLink to="/categories" :class="navBtnClass">
                <svg data-slot="icon" fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                  <path d="M5.566 4.657A4.505 4.505 0 0 1 6.75 4.5h10.5c.41 0 .806.055 1.183.157A3 3 0 0 0 15.75 3h-7.5a3 3 0 0 0-2.684 1.657ZM2.25 12a3 3 0 0 1 3-3h13.5a3 3 0 0 1 3 3v6a3 3 0 0 1-3 3H5.25a3 3 0 0 1-3-3v-6ZM5.25 7.5c-.41 0-.806.055-1.184.157A3 3 0 0 1 6.75 6h10.5a3 3 0 0 1 2.683 1.657A4.505 4.505 0 0 0 18.75 7.5H5.25Z"></path>
                </svg>
                <span>分类</span>
              </RouterLink>
            </li>
            <li>
              <RouterLink to="/tags" :class="navBtnClass">
                <svg data-slot="icon" fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                  <path clip-rule="evenodd" fill-rule="evenodd" d="M5.25 2.25a3 3 0 0 0-3 3v4.318a3 3 0 0 0 .879 2.121l9.58 9.581c.92.92 2.39 1.186 3.548.428a18.849 18.849 0 0 0 5.441-5.44c.758-1.16.492-2.629-.428-3.548l-9.58-9.581a3 3 0 0 0-2.122-.879H5.25ZM6.375 7.5a1.125 1.125 0 1 0 0-2.25 1.125 1.125 0 0 0 0 2.25Z"></path>
                </svg>
                <span>标签</span>
              </RouterLink>
            </li>
            <li>
              <a :class="navBtnClass">
                <svg data-slot="icon" fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                  <path clip-rule="evenodd" fill-rule="evenodd" d="M4.125 3C3.089 3 2.25 3.84 2.25 4.875V18a3 3 0 0 0 3 3h15a3 3 0 0 1-3-3V4.875C17.25 3.839 16.41 3 15.375 3H4.125ZM12 9.75a.75.75 0 0 0 0 1.5h1.5a.75.75 0 0 0 0-1.5H12Zm-.75-2.25a.75.75 0 0 1 .75-.75h1.5a.75.75 0 0 1 0 1.5H12a.75.75 0 0 1-.75-.75ZM6 12.75a.75.75 0 0 0 0 1.5h7.5a.75.75 0 0 0 0-1.5H6Zm-.75 3.75a.75.75 0 0 1 .75-.75h7.5a.75.75 0 0 1 0 1.5H6a.75.75 0 0 1-.75-.75ZM6 6.75a.75.75 0 0 0-.75.75v3c0 .414.336.75.75.75h3a.75.75 0 0 0 .75-.75v-3A.75.75 0 0 0 9 6.75H6Z"></path>
                  <path d="M18.75 6.75h1.875c.621 0 1.125.504 1.125 1.125V18a1.5 1.5 0 0 1-3 0V6.75Z"></path>
                </svg>
                <span>动态</span>
              </a>
            </li>
            <li>
              <a :class="navBtnClass">
                <svg fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                  <path stroke-linecap="round" stroke-linejoin="round" d="M18 18.72a9.094 9.094 0 0 0 3.741-.479 3 3 0 0 0-4.682-2.72m.94 3.198.001.031c0 .225-.012.447-.037.666A11.944 11.944 0 0 1 12 21c-2.17 0-4.207-.576-5.963-1.584A6.062 6.062 0 0 1 6 18.719m12 0a5.971 5.971 0 0 0-.941-3.197m0 0A5.995 5.995 0 0 0 12 12.75a5.995 5.995 0 0 0-5.058 2.772m0 0a3 3 0 0 0-4.681 2.72 8.986 8.986 0 0 0 3.74.477m.94-3.197a5.971 5.971 0 0 0-.94 3.197M15 6.75a3 3 0 1 1-6 0 3 3 0 0 1 6 0Zm6 3a2.25 2.25 0 1 1-4.5 0 2.25 2.25 0 0 1 4.5 0Zm-13.5 0a2.25 2.25 0 1 1-4.5 0 2.25 2.25 0 0 1 4.5 0Z"></path>
                </svg>
                <span>友人帐</span>
              </a>
            </li>
            <li>
              <RouterLink to="/about" :class="navBtnClass">
                <svg data-slot="icon" fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                  <path clip-rule="evenodd" fill-rule="evenodd" d="M4.5 3.75a3 3 0 0 0-3 3v10.5a3 3 0 0 0 3 3h15a3 3 0 0 0 3-3V6.75a3 3 0 0 0-3-3h-15Zm4.125 3a2.25 2.25 0 1 0 0 4.5 2.25 2.25 0 0 0 0-4.5Zm-3.873 8.703a4.126 4.126 0 0 1 7.746 0 .75.75 0 0 1-.351.92 7.47 7.47 0 0 1-3.522.877 7.47 7.47 0 0 1-3.522-.877.75.75 0 0 1-.351-.92ZM15 8.25a.75.75 0 0 0 0 1.5h3.75a.75.75 0 0 0 0-1.5H15ZM14.25 12a.75.75 0 0 1 .75-.75h3.75a.75.75 0 0 1 0 1.5H15a.75.75 0 0 1-.75-.75Zm.75 2.25a.75.75 0 0 0 0 1.5h3.75a.75.75 0 0 0 0-1.5H15Z"></path>
                </svg>
                <span>关于我</span>
              </RouterLink>
            </li>
          </ul>
        </div>

        <!-- 右侧 -->
        <div class="navbar-end lg:flex-initial">
          <div class="dropdown dropdown-end dropdown-hover group/menu-btn">
            <div tabindex="0" role="button" :class="[navBtnClass, 'nav__icon-btn']" @click="toggleTheme()">
              <svg id="system" class="absolute rotate-180 opacity-0 transition-[opacity,rotate] duration-700 ease-in-out" fill="currentColor" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" viewBox="0 0 24 24">
                <path fill="currentColor" d="M12 17V7Q9.925 7 8.463 8.463T7 12t1.463 3.538T12 17m0 5q-2.075 0-3.9-.788t-3.175-2.137T2.788 15.9T2 12t.788-3.9t2.137-3.175T8.1 2.788T12 2t3.9.788t3.175 2.137T21.213 8.1T22 12t-.788 3.9t-2.137 3.175t-3.175 2.138T12 22m0-2q3.35 0 5.675-2.325T20 12t-2.325-5.675T12 4T6.325 6.325T4 12t2.325 5.675T12 20m0-8"></path>
              </svg>
              <svg id="light" class="absolute rotate-180 opacity-0 transition-[opacity,rotate] duration-700 ease-in-out" fill="currentColor" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" viewBox="0 0 24 24">
                <path fill="currentColor" d="M11 3V2q0-.425.288-.712T12 1t.713.288T13 2v1q0 .425-.288.713T12 4t-.712-.288T11 3m0 19v-1q0-.425.288-.712T12 20t.713.288T13 21v1q0 .425-.288.713T12 23t-.712-.288T11 22m11-9h-1q-.425 0-.712-.288T20 12t.288-.712T21 11h1q.425 0 .713.288T23 12t-.288.713T22 13M3 13H2q-.425 0-.712-.288T1 12t.288-.712T2 11h1q.425 0 .713.288T4 12t-.288.713T3 13m16.75-7.325l-.35.35q-.275.275-.687.275T18 6q-.275-.275-.288-.687t.263-.713l.375-.375q.275-.3.7-.3t.725.3t.288.725t-.313.725M6.025 19.4l-.375.375q-.275.3-.7.3t-.725-.3t-.288-.725t.313-.725l.35-.35q.275-.275.688-.275T6 18q.275.275.288.688t-.263.712m12.3.35l-.35-.35q-.275-.275-.275-.687T18 18q.275-.275.688-.287t.712.262l.375.375q.3.275.3.7t-.3.725t-.725.288t-.725-.313M4.6 6.025l-.375-.375q-.3-.275-.3-.7t.3-.725t.725-.288t.725.313l.35.35q.275.275.275.688T6 6q-.275.275-.687.288T4.6 6.025M12 18q-2.5 0-4.25-1.75T6 12t1.75-4.25T12 6t4.25 1.75T18 12t-1.75 4.25T12 18m0-2q1.675 0 2.838-1.162T16 12t-1.162-2.838T12 8T9.162 9.163T8 12t1.163 2.838T12 16m0-4"></path>
              </svg>
              <svg id="dark" class="absolute rotate-180 opacity-0 transition-[opacity,rotate] duration-700 ease-in-out" fill="currentColor" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" viewBox="0 0 24 24">
                <path fill="currentColor" d="M12 21q-3.775 0-6.387-2.613T3 12q0-3.45 2.25-5.988T11 3.05q.325-.05.575.088t.4.362t.163.525t-.188.575q-.425.65-.638 1.375T11.1 7.5q0 2.25 1.575 3.825T16.5 12.9q.775 0 1.538-.225t1.362-.625q.275-.175.563-.162t.512.137q.25.125.388.375t.087.6q-.35 3.45-2.937 5.725T12 21m0-2q2.2 0 3.95-1.213t2.55-3.162q-.5.125-1 .2t-1 .075q-3.075 0-5.238-2.163T9.1 7.5q0-.5.075-1t.2-1q-1.95.8-3.163 2.55T5 12q0 2.9 2.05 4.95T12 19m-.25-6.75"></path>
              </svg>
            </div>
            <div tabindex="-1" class="dropdown-content hidden group-hover/menu-btn:block">
              <ul class="menu menu-md gap-1 w-35 bg-base-100/95 backdrop-blur-md rounded-box z-100 shadow-2xl mt-5">
                <li @click="toggleTheme('system')">
                  <label :class="['nav__theme-option-btn', {'nav__theme-option-btn--active': currentTheme === 'system'}]">
                    <svg fill="currentColor" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" viewBox="0 0 24 24">
                      <path fill="currentColor" d="M12 17V7Q9.925 7 8.463 8.463T7 12t1.463 3.538T12 17m0 5q-2.075 0-3.9-.788t-3.175-2.137T2.788 15.9T2 12t.788-3.9t2.137-3.175T8.1 2.788T12 2t3.9.788t3.175 2.137T21.213 8.1T22 12t-.788 3.9t-2.137 3.175t-3.175 2.138T12 22m0-2q3.35 0 5.675-2.325T20 12t-2.325-5.675T12 4T6.325 6.325T4 12t2.325 5.675T12 20m0-8"></path>
                    </svg>
                    跟随系统
                  </label>
                </li>
                <li @click="toggleTheme('light')">
                  <label :class="['nav__theme-option-btn', {'nav__theme-option-btn--active': currentTheme === 'light'}]">
                    <svg fill="currentColor" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" viewBox="0 0 24 24">
                      <path fill="currentColor" d="M11 3V2q0-.425.288-.712T12 1t.713.288T13 2v1q0 .425-.288.713T12 4t-.712-.288T11 3m0 19v-1q0-.425.288-.712T12 20t.713.288T13 21v1q0 .425-.288.713T12 23t-.712-.288T11 22m11-9h-1q-.425 0-.712-.288T20 12t.288-.712T21 11h1q.425 0 .713.288T23 12t-.288.713T22 13M3 13H2q-.425 0-.712-.288T1 12t.288-.712T2 11h1q.425 0 .713.288T4 12t-.288.713T3 13m16.75-7.325l-.35.35q-.275.275-.687.275T18 6q-.275-.275-.288-.687t.263-.713l.375-.375q.275-.3.7-.3t.725.3t.288.725t-.313.725M6.025 19.4l-.375.375q-.275.3-.7.3t-.725-.3t-.288-.725t.313-.725l.35-.35q.275-.275.688-.275T6 18q.275.275.288.688t-.263.712m12.3.35l-.35-.35q-.275-.275-.275-.687T18 18q.275-.275.688-.287t.712.262l.375.375q.3.275.3.7t-.3.725t-.725.288t-.725-.313M4.6 6.025l-.375-.375q-.3-.275-.3-.7t.3-.725t.725-.288t.725.313l.35.35q.275.275.275.688T6 6q-.275.275-.687.288T4.6 6.025M12 18q-2.5 0-4.25-1.75T6 12t1.75-4.25T12 6t4.25 1.75T18 12t-1.75 4.25T12 18m0-2q1.675 0 2.838-1.162T16 12t-1.162-2.838T12 8T9.162 9.163T8 12t1.163 2.838T12 16m0-4"></path>
                    </svg>
                    亮色模式
                  </label>
                </li>
                <li @click="toggleTheme('dark')">
                  <label :class="['nav__theme-option-btn', {'nav__theme-option-btn--active': currentTheme === 'dark'}]">
                    <svg fill="currentColor" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" viewBox="0 0 24 24">
                      <path fill="currentColor" d="M12 21q-3.775 0-6.387-2.613T3 12q0-3.45 2.25-5.988T11 3.05q.325-.05.575.088t.4.362t.163.525t-.188.575q-.425.65-.638 1.375T11.1 7.5q0 2.25 1.575 3.825T16.5 12.9q.775 0 1.538-.225t1.362-.625q.275-.175.563-.162t.512.137q.25.125.388.375t.087.6q-.35 3.45-2.937 5.725T12 21m0-2q2.2 0 3.95-1.213t2.55-3.162q-.5.125-1 .2t-1 .075q-3.075 0-5.238-2.163T9.1 7.5q0-.5.075-1t.2-1q-1.95.8-3.163 2.55T5 12q0 2.9 2.05 4.95T12 19m-.25-6.75"></path>
                    </svg>
                    暗色模式
                  </label>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </nav>
</template>

<script setup>
import Typewriter from '@/components/Base/Typewriter.vue'
import { computed, onMounted, ref, watch } from 'vue'
import { useEventListener, usePreferredColorScheme } from '@vueuse/core'
import { useNavbarFloat } from '@/composables/useNavbarFloat.js'

// 主题切换逻辑
const themes = ['system', 'light', 'dark']
const currentTheme = ref('')
const systemTheme = usePreferredColorScheme()

onMounted(() => {
  toggleTheme(localStorage.getItem('theme') || 'system')
})

watch(systemTheme, () => toggleTheme('system'))

const toggleTheme = (theme) => {
  if (!theme) {
    theme = themes[(themes.indexOf(currentTheme.value) + 1) % themes.length]
  }
  document.documentElement.setAttribute('data-theme', theme === 'system' ? systemTheme.value : theme)
  localStorage.setItem('theme', theme)
  currentTheme.value = theme

  // 导航栏主题图标切换时的过渡动画逻辑
  themes.forEach(themeName => {
    const themeIcon = document.getElementById(themeName)
    const isActive = themeName === theme

    themeIcon.classList.toggle('opacity-100', isActive)
    themeIcon.classList.toggle('rotate-0', isActive)
    themeIcon.classList.toggle('opacity-0', !isActive)
    themeIcon.classList.toggle('rotate-180', !isActive)
  })
}

const isScrolled = ref(false)

useEventListener(window, 'scroll', () => {
  isScrolled.value = window.scrollY > 0
})

const { isNavbarFloat } = useNavbarFloat()

// 计算导航栏样式
// 通过 scrolled 判断是否产生了滚动，在有 banner 且没有产生滚动时的情况下背景应该是透明的，否则是是毛玻璃背景
const navClass = computed(() => {
  const classList = ['fixed', 'navbar', 'top-0', 'h-15', 'border-b', 'z-100', 'p-0', 'transition-colors', 'duration-400']

  if (isNavbarFloat.value) {
    if (isScrolled.value) {
      classList.push('bg-base-100/95', 'shadow-2xs', 'border-b-base-content/20', 'navbar--backdrop-blur')
    } else {
      classList.push('bg-transparent', 'border-b-transparent')
    }
  } else {
    if (isScrolled.value) {
      classList.push('bg-base-100/95', 'border-b-base-content/20', 'shadow-2xs', 'navbar--backdrop-blur')
    } else {
      classList.push('bg-base-200', 'border-b-transparent')
    }
  }

  return classList
})

// 计算导航栏按钮样式
const navBtnClass = computed(() => {
  const classList = [
    'btn', 'btn-ghost', 'rounded-full', 'font-bold', 'text-shadow-sm', 'text-lg', 'leading-none', 'border-0', 'h-8', 'px-2.5', 'transition-[scale]', 'duration-200',
    'hover:shadow-none', 'hover:scale-110'
  ]

  if (isNavbarFloat.value && !isScrolled.value) {
    classList.push('text-white/95', 'dark:text-white/90', 'hover:bg-black/20')
  } else {
    classList.push('text-base-content', 'hover:bg-base-content', 'hover:text-base-100')
  }

  return classList
})
</script>

<style scoped>
@reference "@/assets/styles/index.css";

svg {
  @apply fill-current stroke-current size-5 stroke-0 drop-shadow-xs drop-shadow-neutral/10;
}

.nav__icon-btn {
  @apply rounded-full p-0 size-8 active:bg-inherit;
  svg {
    @apply stroke-1 size-6;
  }
}

.nav__theme-option-btn {
  @apply flex justify-start gap-1 h-9 text-base-content/85 text-base rounded-xl border-2 border-transparent text-shadow-xs
    active:bg-primary/90
    hover:shadow-sm
    duration-300;
}

.nav__theme-option-btn--active {
  @apply bg-primary text-white border-base-100/10 shadow-sm;
}

/*
  这是导航栏的毛玻璃效果样式。
  在嵌套的元素中，当给一个元素添加 backdrop-filter 时，会创建一个 backdrop root 。
  此时另一个也元素添加 backdrop-filter 时，会在已有的 backdrop root 上创建 新的 backdrop root 。
  从而导致 backdrop-filter 不生效。
  参见：https://stackoverflow.com/questions/60997948/backdrop-filter-not-working-for-nested-elements-in-chrome
  解决方法是将 backdrop-filter 应用在 ::before 上。
*/
.navbar--backdrop-blur {
  @apply before:backdrop-blur-md before:w-full before:h-full before:absolute before:top-0 before:left-0 before:-z-100;
}
</style>