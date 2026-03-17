<template>
  <div class="space-y-2 md:space-y-4">
    <InfoBar title="瞬间" :description="moments ? `共 ${moments.length} 条瞬间` : ''"/>

    <div class="columns-1 md:columns-2 gap-x-4 space-y-4">
      <MomentCard v-for="item in moments" :key="item.id" :moment="item"
                  class="break-inside-avoid transition-all duration-500"
      />
    </div>
  </div>
</template>

<script setup>
import InfoBar from '@/components/Base/InfoBar.vue'
import MomentCard from '@/components/Business/Moment/MomentCard.vue'
import { onMounted, ref } from 'vue'

const moments = ref(null)

onMounted(() => {
  setTimeout(() => {
    moments.value = [
      {
        id: '1001',
        author: {
          name: '云桥雾',
          avatar: '/images/avatar-1.jpg'
        },
        createTime: '2026-03-08 13:30',
        updateTime: '2026-03-12 16:30',
        content: '今天尝试了新的咖啡店，手冲咖啡果然不一样，带着水果的酸味和花香。坐在窗边看了一下午书，感觉时间都慢下来了。',
        pinned: true,
        media: [
          { type: 'image', url: '/images/moment-media/image/image-1.jpg' },
          { type: 'image', url: '/images/moment-media/image/image-2.jpg' },
          { type: 'image', url: '/images/moment-media/image/image-3.png' }
        ],
        likeCount: 45,
        commentCount: 12
      },
      {
        id: '1002',
        author: {
          name: '云桥雾',
          avatar: '/images/avatar-1.jpg'
        },
        createTime: '2026-03-02 05:20',
        updateTime: '2026-03-02 05:20',
        content: '代码写累了，抬头看见窗外的晚霞，突然觉得生活不只有bug，还有诗和远方。明天继续加油！',
        pinned: false,
        media: [
          { type: 'image', url: '/images/moment-media/image/image-4.png' },
          { type: 'video', url: '/images/moment-media/video/video-1.mp4'}
        ],
        likeCount: 234,
        commentCount: 45
      },
      {
        id: '1003',
        author: {
          name: '云桥雾',
          avatar: '/images/avatar-1.jpg'
        },
        createTime: '2026-02-01 11:30',
        updateTime: '2026-02-01 11:30',
        content: '刚刚读完了《百年孤独》，合上书的那一刻，心里空落落的。马尔克斯笔下的马孔多小镇，七代人的命运轮回，仿佛一场漫长的梦。最让我触动的是那句“家族的第一个人被捆在树上，最后一个人正被蚂蚁吃掉”。孤独不是寂寞，而是生命本质的底色。我们每个人都在自己的轨道上，渴望被理解，却又享受独处的自由。也许，这就是为什么星星会亮——不是因为它们孤独，而是因为它们想为夜行的人照亮一点路。',
        pinned: false,
        media: [
          { type: 'image', url: '/images/moment-media/image/image-5.png' }
        ],
        likeCount: 278,
        commentCount: 56
      },
      {
        id: '1004',
        author: {
          name: '云桥雾',
          avatar: '/images/avatar-1.jpg'
        },
        createTime: '2026-01-30 12:40',
        updateTime: '2026-01-30 12:40',
        content: '今天重构了一段三年前写的代码，看到那些糟糕的命名和冗长的函数，忍不住笑了。那时候刚学编程，总想证明自己，结果写出来的东西只有机器能看懂，而且机器可能也不太想看懂。现在回头看，编程和写作很像，都是把思想转化为文字，只不过编程的语言更严谨。好的代码就像好的文章，清晰、简洁、有逻辑，别人能一眼看懂，自己几个月后还能维护。其实人生也是一样，年轻的时候总想搞个大新闻，后来才发现，踏踏实实把每一行代码写好，把每一天过好，才是最重要的。不用追求完美，但求无愧于心。',
        pinned: false,
        media: [
          { type: 'image', url: '/images/moment-media/image/image-6.jpg' }
        ],
        likeCount: 456,
        commentCount: 98
      },
      {
        id: '1005',
        author: {
          name: '云桥雾',
          avatar: '/images/avatar-1.jpg'
        },
        createTime: '2026-01-01 13:30',
        updateTime: '2026-01-01 13:30',
        content: '上个月在花市买了一盆薄荷，放在窗台上，每天浇水晒太阳。现在它已经长出了好多新叶子，绿油油的，凑近了闻有淡淡的清香。早上摘了几片泡水喝，清凉的感觉从喉咙一直蔓延到胃里，整个人都清醒了。其实养植物很简单，只要用心，它就会给你回报。有时候觉得，生活里的快乐就是这些细小的事情：一杯茶、一本书、一缕阳光、一片绿叶。不需要太多物质，内心丰盈就够了。对了，薄荷很好养，推荐给想养植物但怕养不活的朋友，只要勤浇水，它就会疯长，还可以随时摘来泡茶、做菜。',
        pinned: false,
        media: [
          { type: 'image', url: '/images/moment-media/image/image-7.jpg' }
        ],
        likeCount: 167,
        commentCount: 42
      },
      {
        id: '1006',
        author: {
          name: '云桥雾',
          avatar: '/images/avatar-1.jpg'
        },
        createTime: '2025-12-01 13:32',
        updateTime: '2025-12-01 13:32',
        content: '今天和朋友去爬了梧桐山，从早上八点出发，一直到下午三点才下山。山路很陡，中间好几次想放弃，但每次抬头看到远处的风景，又觉得值得。山顶的视野太开阔了，整个城市都在脚下，云雾缭绕，像仙境一样。朋友说，爬山的意义不在于登顶，而在于过程中的坚持和沿途的风景。我想，生活也是一样吧，不管遇到什么困难，只要一步一步往前走，总会到达想去的地方。下山后一起去吃了农家菜，柴火灶炒的青菜特别香，可能是累了的缘故，觉得这是最近吃过最好吃的一顿饭。',
        pinned: false,
        media: [
          { type: 'image', url: '/YogurT/images/moment-media/image/image-8.jpg' }
        ],
        likeCount: 123,
        commentCount: 31
      },
      {
        id: '1007',
        author: {
          name: '云桥雾',
          avatar: '/images/avatar-1.jpg'
        },
        createTime: '2025-11-01 13:42',
        updateTime: '2025-11-01 13:42',
        content: '给十年后的自己写封信吧。你好，我是十年前的你，现在住在深圳，养了一只猫，每天写代码，偶尔写写文章。不知道十年后的你过得怎么样？还在写代码吗？还是转行做了别的？有没有找到那个愿意共度一生的人？父母身体还好吗？有没有去环游世界？希望你不要变成自己讨厌的那种人，不要为了生活而放弃理想。记得要多读书，多运动，多陪家人。如果你现在过得不好，也没关系，人生总有起伏，只要还活着，就有希望。如果你过得很好，记得回头拉一把曾经的自己。对了，如果科技够发达，记得给十年前的自己发条消息，让我知道，现在的努力没有白费。',
        pinned: false,
        media: [
        ],
        likeCount: 789,
        commentCount: 154
      },
      {
        id: '1008',
        author: {
          name: '云桥雾',
          avatar: '/images/avatar-1.jpg'
        },
        createTime: '2025-06-14 23:45',
        updateTime: '2025-06-14 23:45',
        content: '凌晨两点，终于把那个困扰三天的bug修好了。起因居然是一个不起眼的变量名拼写错误，这种经历每个程序员都有吧。修好那一刻，整个人瘫在椅子上，感觉比喝了十杯咖啡还清醒。窗外万籁俱寂，只有电脑风扇还在转。突然想到，代码和人生很像，有时候怎么都找不到问题出在哪，但只要你足够耐心，一行一行排查下去，总会发现那个小小的错误。然后一切豁然开朗。这种成就感，可能就是支撑我们走下去的动力吧。',
        pinned: false,
        media: [
          { type: 'image', url: '/images/moment-media/image/image-2.jpg' }
        ],
        likeCount: 267,
        commentCount: 53
      },
      {
        id: '1009',
        author: {
          name: '云桥雾',
          avatar: '/images/avatar-1.jpg'
        },
        createTime: '2025-06-01 09:30',
        updateTime: '2025-06-01 09:30',
        content: '最近在尝试每天写一点东西，不拘形式，不限主题。有时候是读书笔记，有时候是心情记录，有时候只是路上看到的一句话。写作这件事，坚持下来会发现，它不仅是输出，更是梳理。把脑海里纷乱的思绪变成文字，就像把一团乱麻慢慢理成一条线。而且写得越多，越能敏锐地捕捉生活中的细节。以前忽略的，现在都会多看一眼：路边那只猫的姿势、咖啡店老板的笑容、雨滴打在树叶上的声音……这些都可以成为素材。如果你也迷茫，不妨试试写点东西。',
        pinned: false,
        media: [
          { type: 'image', url: '/images/moment-media/image/image-3.png' }
        ],
        likeCount: 312,
        commentCount: 67
      },
      {
        id: '1010',
        author: {
          name: '云桥雾',
          avatar: '/images/avatar-1.jpg'
        },
        createTime: '2025-02-15 08:50',
        updateTime: '2025-02-15 08:50',
        content: '早高峰的地铁，人挤人。对面坐着一个年轻的妈妈，怀里抱着熟睡的孩子，她一手护着孩子，一手拿着手机看电子书。书名是《月亮与六便士》。旁边的大叔在看股票，眉头紧锁。有个女孩在背英语单词，嘴唇微微翕动。每个人都在自己的轨道上运行，偶然交集在这节车厢里。到站了，各奔东西。这种萍水相逢的陌生感，有时候会让人觉得很奇妙。我们都不知道对方的故事，但此刻，我们共享了这段旅程。',
        pinned: false,
        media: [
          { type: 'image', url: '/images/moment-media/image/image-4.png' }
        ],
        likeCount: 401,
        commentCount: 63
      }
    ]
  }, 300)
})
</script>

<style scoped>

</style>