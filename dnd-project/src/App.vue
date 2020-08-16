<template>
  <div id="app">
    <img style="width: 300px;height: 400px;" src="./assets/162622_5f33999ee5807.jpg">
    <img style="width: 300px;height: 400px;" src="./assets/162623_5f33999f18e0f.jpg">
    <img style="width: 300px;height: 400px;" src="./assets/162623_5f33999f50fd3.jpg">
    <img style="width: 300px;height: 400px;" src="./assets/162623_5f33999f599a6.jpg">
    <img style="width: 300px;height: 400px;" src="./assets/162623_5f33999f0744f.jpg">
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
</style>
