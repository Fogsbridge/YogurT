/**
 * 侧边栏配置
 *
 * @author fogsbridge
 * @since 1.0.0
 */
import {
  LayoutDashboardIcon,
  HouseIcon,
  FilePenLineIcon,
  FileTextIcon,
  LibraryBigIcon,
  TagsIcon,
  HardDriveIcon,
  SettingsIcon,
  LinkIcon,
  TimelineIcon,
  TrashIcon,
  FileClockIcon,
  NewspaperIcon,
} from '@lucide/vue'
import Logo from '@/components/Logo.vue'
import LogoWord from '@/components/LogoWord.vue'

export const brandData = {
  title: '云桥雾',
  logo: Logo,
  logoWord: LogoWord,
}

export const navMainData = [
  {
    title: '概览',
    items: [
      {
        title: '仪表盘',
        url: '',
        icon: LayoutDashboardIcon,
      },
      {
        title: '写文章',
        url: '',
        icon: FilePenLineIcon,
      },
    ],
  },
  {
    title: '内容管理',
    items: [
      {
        title: '文章管理',
        icon: NewspaperIcon,
        items: [
          { title: '全部文章', url: '', icon: FileTextIcon },
          { title: '写文章', url: '', icon: FilePenLineIcon },
          { title: '草稿箱', url: '', icon: FileClockIcon },
          { title: '回收站', url: '', icon: TrashIcon },
        ],
      },
      {
        title: '分类管理',
        url: '',
        icon: LibraryBigIcon,
      },
      {
        title: '标签管理',
        url: '',
        icon: TagsIcon,
      },
      {
        title: '文件管理',
        url: '',
        icon: HardDriveIcon,
      },
    ],
  },
  {
    title: '站点管理',
    items: [
      {
        title: '站点设置',
        url: '',
        icon: SettingsIcon,
      },
      {
        title: '友链管理',
        url: '',
        icon: LinkIcon,
      },
    ],
  },
  {
    title: '系统管理',
    items: [
      {
        title: '操作日志',
        url: '',
        icon: TimelineIcon,
      },
    ],
  },
]

export const navSecondaryData = [
  {
    title: '访问前台',
    url: 'http://localhost:5173/admin/',
    icon: HouseIcon,
  },
]

export const userData = {
  nickname: 'test',
  email: 'test@test.com',
  avatar: '',
}
