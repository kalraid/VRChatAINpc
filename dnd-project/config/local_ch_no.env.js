'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"local_ch_no"',
  PORT: 8081,
  HOST: '"127.0.0.1"',
  BACK_URL: '"12323"',
  API_URL: ' "https://192.168.1.29:18080/api/"'
  //API_URL: ' "http://18.216.170.52:18080"'
})
