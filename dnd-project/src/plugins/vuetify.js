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
  }
}

export default new Vuetify(opts)
