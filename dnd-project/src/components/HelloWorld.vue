 <template>
  <div class="hello">
    <div> 4명 이하는 안짜여짐</div>
    <div> 시너지 비는 경우가 있는데 현수 엑셀기준으로 잡은거라서 남는케릭터 대충 넣으면됨</div>
    <button v-show="admin" @click="characterSync">정보 최신화</button>
    <div>
        <span>현재 있는 사람: </span>
        <span v-for="i in users" v-bind:key="i">
          <input type="checkbox" v-bind:id="i.name" v-model="i.checked">
          <label v-bind:for="i.name">{{ i.alias }}</label>
        </span>
    </div>
    <div>
      <select v-show="admin" v-model="selected">
        <option v-for="i in searchOption" v-bind:key="i.idx" v-value="i.name" v-text="i.name" ></option>
      </select>
      <button @click="getParties">파티 짜 주세요</button>
      <div> 총 {{partySize}}개 파티</div>
      <ul v-for="(i, idx) in party" v-bind:key="i">
        <div><span v-text="(idx+1)"></span> <span>번 팟</span></div>
        <li v-for="user in i" v-bind:key="user">
          <div><span v-text="user.userId"></span> <span v-text="user.job"></span>(<span v-text="user.type"></span>)</div>
          <div ><span v-if="user.type == 'B'" v-text="user.buff"></span><span v-else v-text="user.damage"></span></div>
        </li>
      </ul>
      </div>
  </div>
</template>

<script>
/* eslint-disable */
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'UI 따윈 안꾸민다',
      party : [],
      searchOption : [
        { idx : 1, name : "오큘", value : "oculu", selected : true},
        { idx : 2, name : "마대", value : "devildom", selected : false},
        { idx : 3, name : "핀드워", value : "find", selected : false},
        { idx : 4, name : "프레이-이시스", value : "frey-isis", selected : false}
      ],
      users : [
        { idx : 1, name : "1", checked:false},
        { idx : 2, name : "2", checked:false},
        ],
      selected : "오큘",
      admin : false,
      partySize : 0
    }
  },
  methods:{
    characterSync(){
      this.$http.get('http://121.170.211.213:18080/search/sync')
    },
    getParties(){
      
       this.$http.post('http://121.170.211.213:18080/search/start',{
          "users" : this.$data.users.filter((o) => {
                      return o.checked;
                    }),
          "selected" : this.$data.selected
       })
      .then((result) =>{
        console.log(result);
        this.$data.party = result.data;
        this.$data.partySize = result.data.length;
      })
    }
  },
  created() {
    this.$http.get('http://121.170.211.213:18080/users/list')
    .then((result) =>{
      result.data.forEach((o) =>{
        o.checked = true;
      })
      this.$data.users = result.data;
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
div {
  margin-bottom : 10px;
}
</style>
