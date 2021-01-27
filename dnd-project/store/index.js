import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    articles: require('../data/articles.json'),
    drawer: false,
    link: [
      {
        text: '메인',
        href: '/',
      },
      {
        text: '갤러리',
        href: '/board/list/free',
      },
      {
        text: '던파',
        href: '/df',
      },
      {
        text: '마비노기',
        href: '/mb',
      },
      {
        text: '와우',
        href: '/wo',
      },
    ],
    menus: [
      {
        id: 1,
        icon: "mdi-circle",
        title: "자유갤러리",
        href: "/board/list/free",
        target: "free",
        type: "free"
      },
      {
        id: 2,
        icon: "mdi-circle",
        title: "유머갤러리",
        href: "/board/list/gag",
        target: "gag",
        type: "free",
      },
      {
        id: 3,
        icon: "mdi-circle",
        title: "던파갤러리",
        target: "",
        type: "df",
        childrens: [
          {
            id: 31,
            icon: "mdi-triangle",
            href: "/board/list/df1",
            title: "던파1",
            target: "df1",
          },
          {
            id: 32,
            icon: "mdi-triangle",
            title: "던파2",
            href: "/board/list/df2",
            target: "df2",
          },
          {
            id: 33,
            icon: "mdi-triangle",
            title: "던파3",
            href: "/board/list/df3",
            target: "df3",
          },
        ]
      },
      {
        id: 4,
        icon: "mdi-circle",
        title: "마비갤러리",
        target: "",
        type: "mb",
        childrens: [
          {
            id: 41,
            icon: "mdi-triangle",
            title: "마비1",
            href: "/board/list/mb1",
            target: "mb1",
          },
          {
            id: 42,
            icon: "mdi-triangle",
            title: "마비2",
            href: "/board/list/mb2",
            target: "mb2",
          },
          {
            id: 44,
            icon: "mdi-triangle",
            title: "마비3",
            href: "/board/list/mb3",
            target: "mb3",
          },
          {
            id: 45,
            icon: "mdi-triangle",
            title: "마비4",
            href: "/board/list/mb4",
            target: "mb4",
          },
        ]
      },
      {
        id: 5,
        icon: "mdi-circle",
        title: "신화갤러리",
        target: "",
        type: "mis",
        childrens: [
          {
            id: 51,
            icon: "mdi-triangle",
            title: "신화1",
            href: "/board/list/mis1",
            target: "mis1",
          },
          {
            id: 52,
            icon: "mdi-triangle",
            title: "신화2",
            href: "/board/list/mis2",
            target: "mis2",
          },
          {
            id: 54,
            icon: "mdi-triangle",
            title: "신화3",
            href: "/board/list/mis3",
            target: "mis3",
          },
        ]
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
      // return state.items.concat(getters.categories)
      return state.link
    },
  },
  mutations: {
    setDrawer: (state, payload) => (state.drawer = payload),
    toggleDrawer: state => (state.drawer = !state.drawer),
  },
  actions: {

  },
})
