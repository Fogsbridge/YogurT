import { ref } from 'vue'

// 导航栏是否浮动
const isNavbarFloat = ref(false)

export function useNavbarFloat() {
  const setNavbarFloat = (value) => {
    isNavbarFloat.value = value
  }

  return { isNavbarFloat, setNavbarFloat }
}