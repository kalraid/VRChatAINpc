 <template>
  <div class="hello">
    <div> 4명 이하는 안짜여짐</div>
    <div> 최신화버튼 누르면 대충 10초정도 걸린뒤에 알림창 뜸</div>
    <div>
        <span>현재 있는 사람 (쩔러 노동 제한 - 아직 미지원): </span>
        <span v-for="i in users" v-bind:key="i">
          <input type="checkbox" v-bind:id="i.name" v-model="i.checked">
          <label v-bind:for="i.name">{{ i.alias }}</label>
          <select v-model="i.count">
            <option v-for="a in partySize" v-bind:key="a.idx" v-value="a" v-text="a" v-bind:min="1"></option>
          </select>
        </span>
    </div>
    <div>
      <select v-show="admin2" v-model="selected">
        <option v-for="i in searchOption" v-bind:key="i.idx" v-value="i.name" v-text="i.name" ></option>
      </select>
      <button v-show="admin" v-bind:disabled="syncEnd"  @click="characterSync">정보 최신화</button>
      <button v-bind:disabled="syncEnd" @click="getParties2">벞+딜 조합</button>
      <button v-bind:disabled="syncEnd" @click="getParties">벞+딜+시 조합</button>
      <div> 총 {{partySize}}개 파티</div>
      <ul v-for="(i, idx) in party" v-bind:key="i">
        <div><span v-text="(idx+1)"></span> <span>번 팟</span></div>
        <li v-for="user in i" v-bind:key="user">
          <div><span v-text="user.userId"></span> <span v-text="user.job"></span>(<span v-text="user.type"></span>)</div>
          <div><span v-if="user.type == 'B'" v-text="user.buff.toFixed(1)"></span><span v-else v-text="Math.round(user.damage/10000)+'억'"></span></div>
        </li>
        <span> 파티 총 데미지(예상) : <span v-text="Math.round(partyDamage[idx]/10000)+'억'"></span></span>
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
        { idx : 4, name : "프레이-이시스", value : "frey-isis", selected : false},
        { idx : 5, name : "추방자", value : "banner", selected : false}
      ],
      users : [
        { idx : 1, name : "1", checked:false},
        { idx : 2, name : "2", checked:false},
        ],
      selected : "오큘",
      admin : true,
      partySize : 0,
      syncEnd : false,
      admin2 : false,
      partyDamage : []
    }
  },
  methods:{
    characterSync(){
      this.$data.syncEnd = true;

      this.$http.get('${BACK_URL}/api/dndoff/characterInfo')
      .then((result) =>{
        alert("동기화 완료");
        this.$data.syncEnd = false;
      })
      .error((error) =>{
        alert("동기화 실패 error : "+error);
        this.$data.syncEnd = false;        
      })
    },
    getParties(){
      
       this.$http.post('${BACK_URL}/search/start',{
          "users" : this.$data.users.filter((o) => {
                      return o.checked;
                    }),
          "selected" : this.$data.selected,
          "type" : "DSB",
       })
      .then((result) =>{
        this.$data.party = result.data.partList;
        this.$data.partySize = result.data.partList.length;
        this.$data.partyDamage = result.data.partDamageList;
      })
    },
    getParties2(){
      
       this.$http.post('${BACK_URL}/search/start',{
          "users" : this.$data.users.filter((o) => {
                      return o.checked;
                    }),
          "selected" : this.$data.selected,
          "type" : "DB",
       })
      .then((result) =>{
        console.log(result);
        this.$data.party = result.data.partList;
        this.$data.partySize = result.data.partList.length;
        this.$data.partyDamage = result.data.partDamageList;
      })
    }
  },
  created() {
    this.$http.get('${BACK_URL}/users/list')
    .then((result) =>{
      result.data.forEach((o) =>{
        o.checked = true;
        o.count = 1;
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
