import Vue from 'vue'
import Router from 'vue-router'

import Home from '@/components/Home'
import HelloVueity from '@/components/HelloVueity'
import ExvuetifyForm from '@/components/ExvuetifyForm'

import BoardList from '@/components/page/cm/board/BoardList'
import BoardDetail from '@/components/page/cm/board/BoardDetail'
import BoardView from '@/components/page/cm/board/BoardView'
import BoardWriter from '@/components/page/cm/board/BoardWriter'

import Login from '@/components/page/cm/login/Login'
import Logout from '@/components/page/cm/login/Logout'
import Sign from '@/components/page/cm/login/Sign'

import PartyFinder from '@/components/page/df/party/PartyFinder'
import CharacterList from '@/components/page/df/party/CharacterList'
import PartyFrame from '@/components/page/df/party/PartyFrame'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/Hellovueity',
      name: 'HelloVueity',
      component: HelloVueity
    },
    {
      path: '/logout',
      name: 'Logout',
      component: Logout
    },
    {
      path: '/sign',
      name: 'Sign',
      component: Sign
    },
    {
      path: '/board/list',
      name: 'BoardList',
      component: BoardList
    },
    {
      path: '/board/detail',
      name: 'BoardDetail',
      component: BoardDetail
    },
    {
      path: '/board/view/:seq',
      name: 'BoardView',
      component: BoardView
    },
    {
      path: '/board/writer',
      name: 'BoardWriter',
      component: BoardWriter
    },
    {
      path: '/board/writer/:seq',
      name: 'BoardWriter',
      component: BoardWriter
    },
    {
      path: '/df/party/character/list',
      name: 'CharacterList',
      component: CharacterList
    },
    {
      path: '/df/party/frame',
      name: 'partyFrame',
      component: PartyFrame
    },
    {
      path: '/df/party/finder',
      name: 'PartyFinder',
      component: PartyFinder
    },
    {
      path: '/test/ex',
      name: 'ExvuetifyForm',
      component: ExvuetifyForm
    }
  ]
})
