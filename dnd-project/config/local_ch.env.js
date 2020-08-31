'use strict'
const merge = require('webpack-merge')
const devEnv = require('./dev.env')

module.exports = merge(devEnv, {
  NODE_ENV: '"ch"',
  BACK_URL : 'https://172.30.1.26:18080',
  'process.env.HOST': '"172.30.1.26"'
})
