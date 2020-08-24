<template>
    <div class="CharacterList">
        <div> 케릭터 테이블</div>
        <div>던담 기준 ( 최신화 하고싶으면 파티 페이지에서 최신화 버튼 클릭 ) </div>
        <table id="CharacterTable">
            <thead>
                <tr>
                    <th class="cth" >사람</th>
                    <th class="cth">케릭터 이름</th>
                    <th class="cth">직업</th>
                    <th class="cth">데미지</th>
                    <th class="cth">버프력</th>
                    <th class="cth" v-show="admin2">남은 오큘 회수(미지원)</th>
                    <th class="cth" v-show="admin2">남은 마대 회수(미지원)</th>
                    <th class="cth" v-show="admin2">남은 추방자 회수(미지원)</th>
                    <th class="cth" v-show="admin2">남은 핀드워 회수(미지원)</th>
                    <th class="cth" v-show="admin2">남은 프레이-이시스 회수(미지원)</th>
                    <th class="cth" v-show="admin2">남은 시로코 회수(미지원)</th>
                    <th class="cth" v-show="admin2">레이드 참가 및 쩔러/손님</th>
                    <th class="cth" v-show="admin2">오큘마대 참가 및 쩔러/손님</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="i in characterList" v-bind:key="i">
                    <td class="ctd" v-text="i.sameUser==true?'':i.userAlias"></td>
                    <td class="ctd" v-text="i.name"></td>
                    <td class="ctd" v-text="i.job"></td>
                    <td class="ctd" v-text="i.damage==0?'':(Math.round(i.damage/10000)+'억')"></td>
                    <td class="ctd" v-text="i.buff==0?'':i.buff.toFixed(2)"></td>
                    <td class="ctd" v-show="admin2" v-text="i.oculusRemainCount"></td>
                    <td class="ctd" v-show="admin2" v-text="i.devildomRemainCount"></td>
                    <td class="ctd" v-show="admin2" v-text="i.bannerRemainCount"></td>
                    <td class="ctd" v-show="admin2" v-text="i.findRemainCount"></td>
                    <td class="ctd" v-show="admin2" v-text="i.freyIsisRemainCount"></td>
                    <td class="ctd" v-show="admin2" v-text="i.sirocoRemainCount"></td>
                    <td class="ctd" v-show="admin2">
                        <select v-model="i.raidParticipateType" @change="setRaidParticipateType(i)">
                            <option v-bind:value="0">참가</option>
                            <option v-bind:value="1">쩔러</option>
                            <option v-bind:value="2">손님</option>
                            <option v-bind:value="3">못감</option>
                            <option v-bind:value="4">안감</option>
                        </select>
                    </td>
                    <td class="ctd" v-show="admin2">
                        <select v-model="i.otherParticipateType" @change="setOtherParticipateType(i)">
                            <option v-bind:value="0">참가</option>
                            <option v-bind:value="1">쩔러</option>
                            <option v-bind:value="2">손님</option>
                            <option v-bind:value="3">못감</option>
                            <option v-bind:value="4">안감</option>
                        </select>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
/* eslint-disable */
export default {
  name: 'CharacterList',
  data() {
      return {
          characterList : [],
          admin2 : true,
      }
  },
  created() {
    this.$http.get('http://121.170.211.213:18080/character/list')
    .then((result) =>{
      result.data.forEach((o,i) =>{
          if(i > 0 && o.userAlias == result.data[i-1].userAlias){
              o.sameUser = true;
          }else{
              o.sameUser = false;
          }
        console.log(i);
       })
      this.$data.characterList = result.data;
    })
  },
  methods: {
      setRaidParticipateType(item){
          
        this.$http.post('http://121.170.211.213:18080/character/change/raidType',
        {
            character : item       
        })   
      },
      setOtherParticipateType(item){
        this.$http.post('http://121.170.211.213:18080/character/change/otherType',
        {
           character : item  
        })
      },
  },
}
</script>
<style scoped>
#CharacterTable{

}
</style>


