<template>
  <div class="max-w-8xl mx-auto">
    <div class="mx-auto grid md:grid-cols-6 gap-2 md:gap-4">

      <div class="md:col-span-2">
        <div class="card h-full bg-[url('/images/about/img-5.jpg')] bg-center bg-cover bg-clip-padding">
          <div class="absolute bg-black/25 h-full top-0 left-0 w-full rounded-2xl"></div>
          <div class="z-1 pb-4">
            <h2 class="text-white text-lg mb-6">技能</h2>
            <div class="flex flex-wrap gap-3 text-white text-xl">
              <span class="rounded-full bg-black/60 font-bold hover:scale-110 duration-300 ease-out px-5 py-1.5">Java</span>
              <span class="rounded-full bg-black/60 font-bold hover:scale-110 duration-300 ease-out px-5 py-1.5">Spring</span>
              <span class="rounded-full bg-black/60 font-bold hover:scale-110 duration-300 ease-out px-5 py-1.5">MyBatis</span>
              <span class="rounded-full bg-black/60 font-bold hover:scale-110 duration-300 ease-out px-5 py-1.5">MySQL</span>
              <span class="rounded-full bg-black/60 font-bold hover:scale-110 duration-300 ease-out px-5 py-1.5">JavaScript</span>
              <span class="rounded-full bg-black/60 font-bold hover:scale-110 duration-300 ease-out px-5 py-1.5">Vue</span>
              <span class="rounded-full bg-black/60 font-bold hover:scale-110 duration-300 ease-out px-5 py-1.5">TailwindCSS</span>
              <span class="rounded-full bg-black/60 font-bold hover:scale-110 duration-300 ease-out px-5 py-1.5">Docker</span>
              <span class="rounded-full bg-black/60 font-bold hover:scale-110 duration-300 ease-out px-5 py-1.5">Git</span>
              <span class="rounded-full bg-black/60 font-bold hover:scale-110 duration-300 ease-out px-5 py-1.5">MySQL</span>
            </div>
          </div>
        </div>
      </div>

      <div class="md:col-span-4">
        <div class="card h-full text-white font-bold bg-[url('/images/about/img-4.jpg')] bg-center bg-cover">
          <div class="absolute bg-black/15 h-full top-0 left-0 w-full rounded-2xl"></div>
          <div class="z-1">
            <h2 class="text-2xl text-center md:text-left md:ml-8 mt-2 mb-8 md:mb-12">站点统计</h2>
            <div class="grid grid-cols-2 md:grid-cols-4 gap-y-6 md:gap-y-14 mb-6 md:mb-14">
              <div class="text-center">
                <h2 class="text-base md:text-xl mb-3">今日访问</h2>
                <p class="text-3xl md:text-5xl">99</p>
              </div>
              <div class="text-center">
                <h2 class="text-base md:text-xl mb-3">昨日访问</h2>
                <p class="text-3xl md:text-5xl">230</p>
              </div>
              <div class="text-center">
                <h2 class="text-base md:text-xl mb-3">总访问量</h2>
                <p class="text-3xl md:text-5xl">94325</p>
              </div>
              <div class="text-center">
                <h2 class="text-base md:text-xl mb-3">建站天数</h2>
                <p class="text-3xl md:text-5xl">365</p>
              </div>
              <div class="text-center">
                <h2 class="text-base md:text-xl mb-3">文章数</h2>
                <p class="text-3xl md:text-5xl">23</p>
              </div>
              <div class="text-center">
                <h2 class="text-base md:text-xl mb-3">分类数</h2>
                <p class="text-3xl md:text-5xl">16</p>
              </div>
              <div class="text-center">
                <h2 class="text-base md:text-xl mb-3">标签数</h2>
                <p class="text-3xl md:text-5xl">20</p>
              </div>
              <div class="text-center">
                <h2 class="text-base md:text-xl mb-3">评论数</h2>
                <p class="text-3xl md:text-5xl">666</p>
              </div>
            </div>
          </div>
        </div>
      </div>

      <FlipCard axis="y" class="md:col-span-3 duration-500 h-60 md:h-80">
        <template #front>
          <div class="hover-3d w-full h-full">
            <div class="card relative">
              <h2 class="text-lg mb-4">MBTI</h2>
              <p class="text-4xl md:text-5xl">INTP <span class="text-primary font-bold">逻辑学家</span></p>
              <img class="h-50" src="/images/about/16personalities/desktop-intp.svg" alt="intp"/>
            </div>
            <div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div>
          </div>
        </template>
        <template #back>
          <div class="hover-3d w-full h-full">
            <div class="card relative">
              <h2 class="text-lg mb-4">MBTI<span class="mx-2 font-bold">·</span><span class="font-bold text-primary">INTP</span></h2>
              <img class="absolute -bottom-8 -right-6 h-40 md:h-60 -z-1" src="/images/about/16personalities/svg/intp.svg" alt="intp"/>
              <p class="text-xl">这是一段文本 巴拉巴拉~</p>
            </div>
            <div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div>
          </div>
        </template>
      </FlipCard>

      <FlipCard axis="y" class="md:col-span-3 duration-500 h-60 md:h-80">
        <template #front>
          <div class="hover-3d w-full h-full">
            <div class="card bg-[url('/images/about/yuanshen-1.png')] bg-cover bg-center bg-origin-padding bg-no-repeat">
              <div class="absolute bg-black/15 top-0 left-0 w-full h-full -z-1"></div>
              <h2 class="text-white text-lg mb-4">游戏</h2>
              <p class="text-white text-5xl md:text-6xl font-bold text-shadow-lg">原神</p>
            </div>
            <div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div>
          </div>
        </template>
        <template #back>
          <div class="hover-3d w-full h-full">
            <div class="card bg-[url('/images/about/yuanshen-2.jpg')] bg-cover bg-center bg-origin-padding bg-no-repeat">
              <div class="absolute bg-black/15 top-0 left-0 w-full h-full -z-1"></div>
              <h2 class="text-white text-lg mb-4">游戏</h2>
              <p class="text-white text-4xl md:text-5xl font-bold text-shadow-lg mb-4">原神</p>
              <p class="text-white text-2xl font-bold text-shadow-lg">UID 1234567</p>
            </div>
            <div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div>
          </div>
        </template>
      </FlipCard>

      <FlipCard axis="y" class="md:col-span-2 duration-500 h-60 md:h-80">
        <template #front>
          <div class="hover-3d w-full h-full">
            <div class="card bg-[url('/images/about/gta-1.png')] bg-cover bg-center bg-origin-padding bg-no-repeat">
              <div class="absolute bg-black/15 top-0 left-0 w-full h-full -z-1"></div>
              <h2 class="text-white text-lg text-shadow-lg mb-4">游戏</h2>
              <h2 class="text-white text-5xl text-shadow-lg font-bold">GTA</h2>
            </div>
            <div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div>
          </div>
        </template>
        <template #back>
          <div class="hover-3d w-full h-full">
            <div class="card bg-[url('/images/about/gta-1.png')] bg-cover bg-center bg-origin-padding bg-no-repeat">
              <div class="absolute bg-black/15 top-0 left-0 w-full h-full -z-1"></div>
              <h2 class="text-white text-lg text-shadow-lg mb-4">游戏</h2>
              <h2 class="text-white text-5xl text-shadow-lg font-bold">道德与法制</h2>
            </div>
            <div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div>
          </div>
        </template>
      </FlipCard>

      <FlipCard axis="y" class="md:col-span-2 duration-500 h-60 md:h-80">
        <template #front>
          <div class="hover-3d w-full h-full">
            <div class="card bg-[url('/images/about/guangyu-1.jpg')] bg-cover bg-center bg-origin-padding bg-no-repeat">
              <div class="absolute bg-black/15 top-0 left-0 w-full h-full -z-1"></div>
              <h2 class="text-white text-lg text-shadow-lg mb-4">游戏</h2>
              <h2 class="text-white text-5xl text-shadow-lg font-bold">光·遇</h2>
            </div>
            <div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div>
          </div>
        </template>
        <template #back>
          <div class="hover-3d w-full h-full">
            <div class="card bg-[url('/images/about/guangyu-1.jpg')] bg-cover bg-center bg-origin-padding bg-no-repeat">
              <div class="absolute bg-black/15 top-0 left-0 w-full h-full -z-1"></div>
              <h2 class="text-white text-lg text-shadow-lg mb-4">游戏</h2>
              <h2 class="text-white text-5xl text-shadow-lg font-bold">光遇</h2>
            </div>
            <div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div>
          </div>
        </template>
      </FlipCard>

      <FlipCard axis="y" class="md:col-span-2 duration-500 h-60 md:h-80">
        <template #front>
          <div class="hover-3d w-full h-full">
            <div class="card bg-[url('/images/about/lol-1.jpg')] bg-cover bg-center bg-origin-padding bg-no-repeat">
              <div class="absolute bg-black/15 top-0 left-0 w-full h-full -z-1"></div>
              <h2 class="text-white text-lg text-shadow-lg mb-4">游戏</h2>
              <h2 class="text-white text-5xl text-shadow-lg font-bold">英雄联盟</h2>
            </div>
            <div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div>
          </div>
        </template>
        <template #back>
          <div class="hover-3d w-full h-full">
            <div class="card bg-[url('/images/about/lol-1.jpg')] bg-cover bg-center bg-origin-padding bg-no-repeat">
              <div class="absolute bg-black/15 top-0 left-0 w-full h-full -z-1"></div>
              <h2 class="text-white text-lg text-shadow-lg mb-4">游戏</h2>
              <h2 class="text-white text-5xl text-shadow-lg font-bold mb-2">锐雯</h2>
              <h2 class="text-white text-4xl text-shadow-lg font-bold">Riven</h2>
            </div>
            <div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div>
          </div>
        </template>
      </FlipCard>

      <div class="md:col-span-2 md:row-span-2 h-80">
        <div class="h-full card bg-[url('/images/about/music-1.jpg')]  bg-cover bg-center bg-origin-padding bg-no-repeat">
          <div class="absolute bg-black/25 h-full top-0 left-0 w-full rounded-2xl"></div>
          <div class="z-1">
            <h2 class="text-lg text-white mb-2">音乐</h2>
            <div class="flex flex-col h-full justify-around text-white font-bold">
              <p class="text-4xl text-shadow-lg">Hiphop</p>
              <p class="text-4xl text-shadow-lg">纯音乐</p>
              <p class="text-4xl text-shadow-lg">梦核 / 怪核 / 后室</p>
              <p class="text-4xl text-shadow-lg">欧美</p>
            </div>
          </div>
        </div>
      </div>

      <div class="md:col-start-3 md:col-span-4">
        <div class="card h-full bg-teal-400! bg-clip-padding">
          <h2 class="text-white text-lg mb-4">最近在</h2>
          <p class="text-white text-4xl">
            忙！！！！！！！！！！！！！
          </p>
        </div>
      </div>

      <div class="md:col-start-3 md:col-span-4">
        <div class="card h-full bg-indigo-400! bg-clip-padding">
          <h2 class="text-white text-lg mb-4">兴趣</h2>
          <p class="text-white text-4xl">
            睡觉，谁都不要吵我睡觉！！
          </p>
        </div>
      </div>

      <div class="md:col-span-6">
        <div class="card min-h-60">
          <h2 class="text-3xl mt-2 mb-4">关于我</h2>
          <p class="text-lg mb-2">
            这是一段文本
            这是一段文本
            这是一段文本
            这是一段文本
            这是一段文本
            这是一段文本
            这是一段文本
            这是一段文本
            这是一段文本
            这是一段文本
            这是一段文本
          </p>
          <p class="text-lg">
            啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧 啊吧
          </p>
        </div>
      </div>

<!--      <div>-->
<!--        <div>打赏作者</div>-->
<!--      </div>-->

<!--      <div>-->
<!--        <div>技能</div>-->
<!--      </div>-->

    </div>
  </div>

</template>

<script setup>
import FlipCard from '@/components/Base/FlipCard.vue'
</script>

<style scoped>
@reference "@/assets/styles/index.css";

.card {
  @apply bg-base-100 rounded-2xl border border-base-content/10 shadow-lg shadow-base-content/2 py-4 px-8 wrap-anywhere;
}

/*
  覆盖掉 hover-3d 原来的放大效果，改为缩小
 */
.hover-3d:hover > :first-child, .md\:hover-3d:hover > :first-child {
  @apply scale-97;
}
</style>