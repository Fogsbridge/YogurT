import { computed, ref } from 'vue'
import MarkdownIt from 'markdown-it'
import markdownItFootnote from 'markdown-it-footnote'
import markdownItDeflist from 'markdown-it-deflist'
import markdownItLinkAttributes from 'markdown-it-link-attributes'
import markdownItTaskLists from 'markdown-it-task-lists'
import { full as markdownItEmoji } from 'markdown-it-emoji'
import markdownItAnchor from 'markdown-it-anchor'
import markdownItTocDoneRight from 'markdown-it-toc-done-right'
import uslug from 'uslug'
import hljs from 'highlight.js'
import DOMPurify from 'dompurify'

export const useMarkdownRender = (source) => {
  const md = new MarkdownIt({
    html: true,
    linkify: true,
    typographer: true,
    breaks: true,
    highlight: (str, lang) => {
      let highlightedCode = ''
      if (lang && hljs.getLanguage(lang)) {
        try {
          highlightedCode = hljs.highlight(str, { language: lang }).value
        } catch (__) {

        }
      } else {
        // 如果没有指定语言，则转义，避免被渲染成 html 标签
        highlightedCode = md.utils.escapeHtml(str)
      }

      // 添加行号
      const lineCount = str.split(/\n/).length
      let linesHtml = '<div class="pre-line">'
      for (let i = 0; i < lineCount; i++) {
        linesHtml += `<span>${i + 1}</span>`
      }
      linesHtml += '</div>'

      return `<pre class="pre-container hljs"><div class="pre-header"><span class="pre-title">${lang || 'text'}</span></div><div class="pre-main">${linesHtml}<code class="pre-content">${highlightedCode}</code></div></pre>`
    }
  })

  // md 插件：脚注、Emoji、定义列表、任务列表、链接属性、锚点、目录生成
  md.use(markdownItFootnote)
  md.use(markdownItEmoji)
  md.use(markdownItDeflist)
  md.use(markdownItTaskLists, { label: true })

  md.use(markdownItLinkAttributes, {
    // 如果 a 标签的 href 属性不以 # 开头，则给它添加 target: '_blank', rel: 'noopener noreferrer'
    matcher: (href) => !href.startsWith('#'),
    attrs: { target: '_blank', rel: 'noopener noreferrer' }
  })

  md.use(markdownItAnchor, {
    level: [1, 2],
    slugify: uslug
  })

  const rawTocHtml = ref('')
  md.use(markdownItTocDoneRight, {
    level: [1, 2],
    slugify: uslug,
    callback: html => rawTocHtml.value = html
  })

  const rawContentHtml = computed(() => md.render(source))

  // 消毒配置
  const purifyConfig = {
    ALLOWED_TAGS: [
      'div', 'p', 'br', 'hr', 'h1', 'h2', 'h3', 'h4', 'h5', 'h6',
      'ul', 'ol', 'li', 'pre', 'code', 'span', 'a', 'img',
      'strong', 'em', 'b', 'i', 'table', 'thead', 'tbody',
      'tr', 'th', 'td', 'blockquote', 'del', 's', 'ins', 'u', 'sub', 'sup',
      'section', 'dl', 'dt', 'dd', 'label', 'input', 'nav'
    ],
    ALLOWED_ATTR: [
      'class', 'href', 'src', 'alt', 'title', 'width', 'height', 'id', 'style', 'target', 'rel',
      'checked', 'disabled', 'type'
    ],
    ALLOW_DATA_ATTR: false,
    KEEP_CONTENT: true
  }

  const sanitizedContentHtml = computed(() => DOMPurify.sanitize(rawContentHtml.value, purifyConfig))
  const sanitizedTocHtml = computed(() => DOMPurify.sanitize(rawTocHtml.value, purifyConfig))

  return {
    contentHtml: sanitizedContentHtml,
    tocHtml: sanitizedTocHtml
  }
}