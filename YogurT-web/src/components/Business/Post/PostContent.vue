<template>
  <article class="panel w-full p-4 md:px-10 md:py-8">
    <div v-if="contentHtml" ref="mdRef" class="markdown-body" v-html="contentHtml"></div>
    <slot v-else />
  </article>
</template>

<script setup>
import { nextTick, onBeforeUnmount, onMounted, useTemplateRef, watch } from 'vue'
import { OverlayScrollbars } from 'overlayscrollbars'
import 'overlayscrollbars/overlayscrollbars.css'

const props = defineProps({
  contentHtml: { type: String, required: false }
})

const mdRef = useTemplateRef('mdRef')

// 给围栏代码块自定义滚动条
const initCodeBlockScrollbars = () => {
  destroyAllScrollbars()
  mdRef.value.querySelectorAll('.pre-container .pre-content').forEach(pre => {
    pre.__osInstance__ = OverlayScrollbars(pre, {
      scrollbars: { autoHide: 'move', clickScroll: true, theme: 'os-theme-code-block' },
      cancel: { nativeScrollbarsOverlaid: true }
    })
  })
}

const destroyAllScrollbars = () => {
  mdRef.value.querySelectorAll('.pre-container .pre-content').forEach(pre => {
    if (pre.__osInstance__) {
      pre.__osInstance__.destroy()
      delete pre.__osInstance__
    }
  })
}

onMounted(async () => {
  await nextTick()
  initCodeBlockScrollbars()
})

watch(() => props.source, async () => {
  await nextTick()
  initCodeBlockScrollbars()
})

onBeforeUnmount(destroyAllScrollbars)
</script>

<style>
@reference "@/assets/styles/index.css";

/* 围栏代码块代码高亮样式 */
[data-theme='light'] {
  @import "highlight.js/styles/github.min.css";
}

[data-theme='dark'] {
  @import "highlight.js/styles/github-dark.min.css";
}

/* markdown 样式 */
.markdown-body {
  @apply text-sm md:text-base tracking-wider text-base-content;

  h1, h2, h3, h4, h5, h6 {
    @apply font-bold my-4;
  }

  h1 {
    @apply text-[1.4rem] md:text-[1.7rem] border-l-6 border-primary/70 dark:border-primary pl-4 mt-8 md:mt-10;
  }

  h2 {
    @apply text-[1.3rem] md:text-[1.45rem] border-l-6 border-primary/70 dark:border-primary pl-4;
  }

  h3 {
    @apply text-[1.2rem] md:text-[1.3rem];
  }

  h4 {
    @apply text-[1.1rem] md:text-[1.15rem];
  }

  h5 {
    @apply text-[1.05rem];
  }

  h6 {
    @apply text-[1rem];
  }

  strong, b{
    @apply text-[color-mix(in_oklch,var(--color-primary)_90%,white)];
  }

  em, i {
    @apply text-[color-mix(in_oklch,var(--color-primary)_90%,white)];
  }

  del, s {
    @apply opacity-85 line-through decoration-2;
  }

  ins, u {
    @apply underline decoration-2 underline-offset-4 decoration-primary/80 dark:decoration-primary;
  }

  hr {
    @apply border-t-2 border-primary/70 border-dashed my-6;
  }

  a {
    @apply text-[color-mix(in_oklch,var(--color-primary)_90%,white)] underline decoration-2 underline-offset-4
    decoration-primary/65 dark:decoration-primary/80;
  }

  blockquote, q {
    @apply border-l-6 border-primary/60 dark:border-primary/75 pl-4 bg-primary/5 dark:bg-primary/15 py-0.5
    text-base-content/60;
  }

  table, pre, dl, blockquote, q, ul, ol, p, img, section {
    @apply my-4;
  }

  & > :first-child {
    @apply mt-0;
  }

  ul, ol {
    @apply pl-8 list-outside;
  }

  ul > li {
    @apply list-disc;
  }

  ul > li::marker {
    @apply text-primary;
  }

  ul ul > li {
    @apply list-[circle];
  }

  ol > li {
    @apply list-decimal;
  }

  ol > li::marker {
    @apply font-sans;
  }

  li {
    @apply my-1;
  }

  ul ul, ul ol, ol ul, ol ol {
    @apply m-0 pl-6;
  }

  pre, code {
    @apply font-mono tracking-wide;
  }

  code:not(pre code) {
    @apply bg-primary/5 dark:bg-primary/25 text-[color-mix(in_oklch,var(--color-primary)_90%,white)] text-[0.9rem]
    px-1.5 py-0.5 rounded-md whitespace-pre-wrap;
  }

  table {
    @apply border-collapse;
  }

  table tr {
    @apply bg-base-100;
  }

  table tr:nth-child(2n) {
    @apply bg-base-content/2 dark:bg-base-content/4;
  }

  table thead tr {
    @apply bg-base-content/4 dark:bg-base-content/8;
  }

  table tbody tr {
    @apply font-normal;
  }

  table td, table th {
    @apply border border-base-content/5 dark:border-base-content/10 py-1.5 px-3;
  }

  dl dt {
    @apply font-bold italic;
  }

  dl dd {
    @apply ml-4 my-2;
  }

  ul.contains-task-list {
    @apply pl-4;
  }

  .contains-task-list li.task-list-item {
    @apply list-none;
  }

  .contains-task-list li.task-list-item label {
    @apply  relative pl-6;

    @apply before:absolute before:left-0 before:top-0 before:size-4 before:border before:border-base-content/15
    dark:before:border-base-content/25 before:bg-base-100 before:bg-clip-padding before:rounded-xs;

    @apply has-checked:opacity-85 has-checked:line-through has-checked:decoration-2;

    @apply has-checked:before:bg-primary/80 dark:has-checked:before:bg-primary has-checked:before:border-primary/80
    dark:has-checked:before:border-primary;

    @apply has-checked:after:absolute has-checked:after:size-4 has-checked:after:content-['✓']
    has-checked:after:left-px has-checked:after:-top-px has-checked:after:text-center
    has-checked:after:font-bold has-checked:after:text-white has-checked:after:text-[0.8rem];
  }

  .contains-task-list li.task-list-item label .task-list-item-checkbox {
    @apply appearance-none;
  }
}

/* 围栏代码块容器样式 */
.markdown-body .pre-container {
  @apply relative rounded-xl border border-base-content/10 dark:border-base-content/15 shadow-lg shadow-base-content/2;

  & > .pre-header {
    @apply h-6 md:h-8.5 flex justify-center items-center;

    &:before {
      @apply content-[''] absolute top-1.5 md:top-2.5 left-2.5 md:left-3 size-3 md:size-3.5 rounded-full bg-[#fb2c36]
      shadow-[1.1rem_0_0_#fd9a00,2.2rem_0_0_#00c951] md:shadow-[1.3rem_0_0_#fd9a00,2.6rem_0_0_#00c951];
    }

    & > .pre-title {
      @apply text-base-content/60 text-2xs md:text-sm;
    }
  }

  & > .pre-main {
    @apply font-mono flex flex-row text-xs md:text-base pt-1 pb-2;

    & > .pre-line {
      @apply hidden md:block text-right text-base-content/35 dark:text-base-content/45 border-r
      border-r-base-content/5 dark:border-r-base-content/10 pointer-events-none select-none;

      & > span {
        @apply block px-3;
      }
    }

    & > .pre-content {
      @apply mx-4 pb-3;
    }
  }
}

/* 围栏代码块滚动条 */
.os-theme-code-block {
  cursor: pointer;
  box-sizing: border-box;
  --os-size: 6px;
  --os-padding-perpendicular: 0;
  --os-padding-axis: 0;
  --os-track-border-radius: 10px;
  --os-handle-interactive-area-offset: 0;
  --os-handle-border-radius: 10px;
}

[data-theme='light'] .os-theme-code-block {
  --os-handle-bg: rgba(0, 0, 0, 0.05);
  --os-handle-bg-hover: rgba(0, 0, 0, 0.1);
  --os-handle-bg-active: rgba(0, 0, 0, 0.15);
}

[data-theme='dark'] .os-theme-code-block {
  --os-handle-bg: rgba(255, 255, 255, 0.1);
  --os-handle-bg-hover: rgba(255, 255, 255, 0.2);
  --os-handle-bg-active: rgba(255, 255, 255, 0.3);
}
</style>