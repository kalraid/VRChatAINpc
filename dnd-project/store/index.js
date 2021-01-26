import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    articles: require('../data/articles.json'),
    drawer: false,
    items: [
      {
        text: '메인',
        href: '#/',
      },
      {
        text: '갤러리',
        href: '#/board/list',
      },
    ],
    menus: [
      {
        id: 1,
        icon: "loop",
        title: "메뉴 설정",
        target: "Index",
      },
      {
        id: 2,
        icon: "android",
        title: "페이지2",
        target: "Page2",
        model: false,
        childrens: [
          {
            id: 21,
            icon: "assignment_ind",
            title: "페이지2_1",
            target: "Page2_1",
          },
          {
            id: 22,
            icon: "people_alt",
            title: "페이지2_2",
            target: "Page2_2",
          }
        ]
      },
      {
        id: 3,
        icon: "trending_up",
        title: "페이지3",
        target: "Page3",
      },
    ],
    colors: {
      menu_background_color: '#263238',
      menu_selected_color: 'red',
    }
  },
  getters: {
    categories: state => {
      const categories = []

      for (const article of state.articles) {
        if (
          !article.category ||
          categories.find(category => category.text === article.category)
        ) continue

        const text = article.category

        categories.push({
          text,
          href: '#!',
        })
      }

      return categories.sort().slice(0, 4)
    },
    links: (state, getters) => {
      return state.items.concat(getters.categories)
    },
  },
  mutations: {
    setDrawer: (state, payload) => (state.drawer = payload),
    toggleDrawer: state => (state.drawer = !state.drawer),
  },
  actions: {

  },
})
