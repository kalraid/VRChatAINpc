'use strict'
const merge = require('webpack-merge')
const devEnv = require('./dev.env')

module.exports = merge(devEnv, {
  NODE_ENV: '"ch_note"',
  BACK_URL : 'https://172.30.1.33:18080',
  'process.env.HOST': '"172.30.1.33"',
  HOST: '172.30.1.33'
})
