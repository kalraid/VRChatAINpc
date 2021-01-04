<template>
  <div id="app">
    <div id="menu">
      <router-link class="menuLink" to="/Character/list">케릭터 목록</router-link>
      <router-link class="menuLink" to="/">파티 계산기</router-link>
      <router-link class="menuLink" to="/partyFrame">파티 프레임</router-link>
    </div>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 20px;
}
#menu{
  margin-bottom: 40px
}
.menuLink{
  padding-right: 40px;
}
</style>
