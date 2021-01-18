/* ## BoardList.vue 내용 */ 
<template>
  <v-container>
    <v-col>
      <v-data-table
        :headers="headers"
        :items="desserts"
        :items-per-page="5"
        class="elevation-1"
        @click:row="rowClick"
      >
      </v-data-table>
    </v-col>
    <v-col >
      <v-row>
        <v-btn outlined color="blue" class="ms-3" @click="writeClick"> 작성 </v-btn>
      </v-row>
    </v-col>
  </v-container>
</template> 
<script>
import axios from "axios";
export default {
  name: "BoardList",
  data() { 
    return {
      headers: [
        { text: "글번호", align: "left", sortable: false, value: "number" },
        { text: "제목", value: "title" },
        { text: "작성자", value: "user" },
        { text: "작성시간", value: "instDt" }
      ],
      desserts: [],
      gallery: {
        galleryKey: "1",
        name: "",
      },
      board: {
        t: "123"
      },
      pageable: {
        a: "1234"
      }
    }
  },
  methods: {
    fetch() {
      console.log("fetch list");
      let params = {
        gallery: this.$data.gallery,
        vo: this.$data.board,
        pageable: this.$data.pageable
      }
      
      axios
        .post(process.env.API_URL + 'v1/board/list', params)
        .then((response) => {
          this.desserts = []
          response.data.content.forEach(element => {
            let content = {}
            content.number = element.boardKey;
            content.title = element.title;
            content.user = element.cmUserVo.alias;
            content.instDt = element.instDt;
            this.desserts.push(content);
          });
        })
        .catch((error) => {
          console.log(error);
        });
    },
    writeClick() {
      this.$router.push("/board/writer");
    },
    rowClick(item) {
      this.$router.push("/board/view/" + item.number);
    },
  },
  created() {
    this.fetch();
  },
}
</script>
