/* ## BoardList.vue 내용 */ 
<template>
  <v-container>
    <lefttoolbar />
    <div>
      <v-col>
        <v-card class="pa-4" dark> 배너 겸 채팅창 </v-card>
      </v-col>
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
      <v-col>
        <v-row>
          <v-btn outlined color="blue" class="ms-3" @click="writeClick">
            작성
          </v-btn>
        </v-row>
      </v-col>
    </div>
  </v-container>
</template> 
<script>
export default {
  name: "BoardList",
  data() {
    return {
      headers: [
        { text: "글번호", align: "left", sortable: false, value: "number" },
        { text: "제목", value: "title" },
        { text: "작성자", value: "user" },
        { text: "작성시간", value: "instDt" },
      ],
      desserts: [],
      vo: {
        // API 쪽에 전달할 객체
        cmGalleryVo: {
          galleryKey: "1",
        },
        cmUserVo: {},
        boardKey: "",
        title: "",
        content: "",
        page: "0",
        size: "10",
        orderColumns: "",
        order: "ASC",
      },
    };
  },
  methods: {
    fetch() {
      console.log("fetch list");
      this.$http
        .post(process.env.API_URL + "v1/board/list", this.$data.vo)
        .then((response) => {
          this.desserts = [];
          response.data.content.forEach((element) => {
            let content = {};
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
  components: {
    lefttoolbar: () => import("@/components/core/LeftToolBar"),
  },
};
</script>
