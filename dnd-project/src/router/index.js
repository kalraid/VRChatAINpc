import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import CharacterList from '@/components/CharacterList'
import PartyFrame from '@/components/PartyFrame'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/Character/list',
      name: 'CharacterList',
      component: CharacterList
    },
    {
      path: '/partyFrame',
      name: 'partyFrame',
      component: PartyFrame
    }
  ]
})
