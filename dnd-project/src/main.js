// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import https from 'https'

// Polyfills
import 'core-js/stable'
import 'regenerator-runtime/runtime'
import store from '../store/index'

// Imports
import vuetify from './plugins/vuetify'
import '@/plugins/base'

Vue.config.productionTip = false
const instance = axios.create({
  timeout: 120000,
  httpsAgent: new https.Agent({
    rejectUnauthorized: false
  })
})

Vue.prototype.$http = instance

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  vuetify,
  template: '<App/>'
})
