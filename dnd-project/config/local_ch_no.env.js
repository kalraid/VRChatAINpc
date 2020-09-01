'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"local_ch_no"',
  PORT: 8081,
  HOST: '"127.0.0.1"',
  BACK_URL: '"12323"',
  API_URL: ' "http://172.30.1.33:18080"'
})
