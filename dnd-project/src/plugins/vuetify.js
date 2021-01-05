// src/plugins/vuetify.js

import Vue from 'vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'

Vue.use(Vuetify)
const opts = {
  theme: {
    themes: {
      light: {
        primary: '#CBAA5C',
        secondary: '#083759'
      }
    }
  },
  rtl: false, // 우측 읽기 모드
  icons: {
    iconfont: 'mdiSvg' // 'mdi' || 'mdiSvg' || 'md' || 'fa' || 'fa4' || 'faSvg'
  }
}

Vuetify.config.silent = true
export default new Vuetify(opts)
