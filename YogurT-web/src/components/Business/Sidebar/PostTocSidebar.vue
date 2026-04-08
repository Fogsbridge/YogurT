<template>
  <div v-if="show" class="panel px-1 py-6 min-h-50 w-full space-y-4">
    <h2 class="px-5 text-xl font-bold text-base-content">
      文章目录
    </h2>
    <div ref="tocContainerRef" v-html="tocHtml" class="px-5 max-h-[75lvh]" v-overlay-scroll="tocScrollbarConfig"></div>
  </div>
</template>

<script setup>
import { computed, onMounted, ref, toRefs, useTemplateRef } from 'vue'
import { useGlobalScrollStore } from '@/stores/globalScroll.js'
import { useEventListener, useResizeObserver } from '@vueuse/core'

const props = defineProps({
  tocHtml: { type: String, required: true }
})

const tocContainerRef = useTemplateRef('tocContainerRef')
const anchors = ref([])
const currentAnchor = ref({})
const { scrollTop, viewport } = toRefs(useGlobalScrollStore())
const { scrollTo } = useGlobalScrollStore()
const tocScrollbarConfig = {
  scrollbars: {
    autoHide: 'move',
    clickScroll: true,
    theme: 'os-theme-toc-sidebar'
  },
  cancel: {
    nativeScrollbarsOverlaid: true
  }
}

// 判断 html 是否存在锚点链接，只有存在时才渲染此侧边栏
const show = computed(() => props.tocHtml.includes('href="#'))

// 计算所有锚点的信息（锚点id、上边框偏移量）
const updateAnchors = () => {
  let anchorLinks = document.querySelectorAll('.table-of-contents a[href]')
  anchors.value = Array
    .from(anchorLinks)
    .map(el => {
      const targetId = el.attributes.href.value.slice(1)
      const headingElement = document.querySelector(
        `.markdown-body h1[id="${targetId}"], .markdown-body h2[id="${targetId}"]`
      )
      let borderTopOffset = 0
      if (headingElement) {
        const marginTop = parseFloat(window.getComputedStyle(headingElement).marginTop) || 0
        borderTopOffset = headingElement.offsetTop - marginTop
      }
      return { targetId, borderTopOffset }
    })
    .sort((a, b) => a.borderTopOffset - b.borderTopOffset)
}

// 根据当前滚动位置找到应该激活的锚点链接
const findCurrentAnchor = () => {
  if (anchors.value.length === 0) return null

  currentAnchor.value = null

  const navHeight = document.querySelector('[data-role="layout-nav"] > div').getBoundingClientRect().height
  for (let i = anchors.value.length - 1; i >= 0; i--) {
    if (scrollTop.value + navHeight >= anchors.value[i].borderTopOffset) {
      currentAnchor.value = anchors.value[i]
      break
    }
  }
}

// 为当前活动的锚点链接添加样式
const activateCurrentAnchor = () => {
  if(!tocContainerRef.value) return
  // 移除 active 类
  const legacyLink = tocContainerRef.value.querySelectorAll('.table-of-contents a.active')
  if (legacyLink) {
    legacyLink.forEach(link => link.classList.remove('active'))
  }
  // 添加 active 类
  if (currentAnchor.value && currentAnchor.value.targetId) {
    const currentLink = tocContainerRef.value.querySelector(`.table-of-contents a[href="#${currentAnchor.value.targetId}"]`)
    currentLink.classList.add('active')
  }
}

// 处理滚动
const handleScroll = () => {
  findCurrentAnchor()
  activateCurrentAnchor()
}

// 滚动到指定锚点
const scrollToAnchor = (id) => {
  const headingElement = document.getElementById(id)
  if (!headingElement) return

  const headingTop = headingElement.getBoundingClientRect().top
  const headingMarginTop = parseFloat(window.getComputedStyle(headingElement).marginTop) || 0
  const navHeight = document.querySelector('[data-role="layout-nav"] > div').getBoundingClientRect().height

  const targetTop = scrollTop.value - navHeight + headingTop - headingMarginTop + 1

  scrollTo({ top: targetTop, behavior: 'smooth' })
}

// 处理点击
const handleClick = (event) => {
  let target = event.target
  while (target && target !== tocContainerRef.value) {
    if (target.tagName === 'A') break
    target = target.parentElement
  }
  if (!target || target.tagName !== 'A') return

  const href = target.getAttribute('href')
  if (href && href.startsWith('#')) {
    event.preventDefault()
    const id = href.slice(1)
    scrollToAnchor(id)
  }
}

onMounted(() => {
  useEventListener(viewport.value, 'scroll', handleScroll)
  useEventListener(tocContainerRef, 'click', handleClick)
  // 图片加载完成后，尺寸会发生变化，需重新计算 offset
  useResizeObserver(document.querySelector('.markdown-body'), updateAnchors)
})
</script>

<style>
@reference "@/assets/styles/index.css";

.table-of-contents {
  @apply overflow-hidden;

  ol li ol {
    @apply border-l-3 border-base-content/3 dark:border-base-content/6;
  }

  li ol li {
    @apply pl-4;
  }

  a {
    @apply block py-1.5 text-base-content/60 w-full text-nowrap text-ellipsis overflow-hidden;
    @apply hover:font-bold hover:text-base-content/90 transition-all duration-200;
  }

  a.active {
    @apply font-bold text-primary origin-left scale-115 transition-transform duration-300 will-change-transform;
  }
}

.os-theme-toc-sidebar {
  cursor: pointer;
  box-sizing: border-box;
  --os-size: 6px;
  --os-padding-perpendicular: 0;
  --os-padding-axis: 0;
  --os-track-border-radius: 10px;
  --os-handle-interactive-area-offset: 0;
  --os-handle-border-radius: 10px;
}

[data-theme='light'] .os-theme-toc-sidebar {
  --os-handle-bg: rgba(0, 0, 0, 0.05);
  --os-handle-bg-hover: rgba(0, 0, 0, 0.1);
  --os-handle-bg-active: rgba(0, 0, 0, 0.15);
}

[data-theme='dark'] .os-theme-toc-sidebar {
  --os-handle-bg: rgba(255, 255, 255, 0.1);
  --os-handle-bg-hover: rgba(255, 255, 255, 0.2);
  --os-handle-bg-active: rgba(255, 255, 255, 0.3);
}
</style>