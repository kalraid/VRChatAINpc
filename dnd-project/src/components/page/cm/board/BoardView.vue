/* ## BoardView.vue 파일 내용 */ 
<template>
  <v-form>
    <v-container>
      <v-row justify="space-around" class="mt-4 mb-4">
        <v-card width="1600">
          <v-img
            height="200px"
            src="https://cdn.pixabay.com/photo/2020/07/12/07/47/bee-5396362_1280.jpg"
          >
            <v-app-bar flat color="rgba(0, 0, 0, 0)">
              <v-card-title class="white--text mt-8">
                <v-avatar size="56">
                  <img
                    alt="user"
                    src="https://cdn.pixabay.com/photo/2020/06/24/19/12/cabbage-5337431_1280.jpg"
                  />
                </v-avatar>
                <p class="ml-3">{{ user }}</p>
              </v-card-title>
              <v-spacer></v-spacer>
              <v-btn color="white" icon @click="convertDialog">
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </v-app-bar>
            <v-app-bar flat color="rgba(0, 0, 0, 0)">
              <v-row>
                <v-toolbar-title class="title white--text pl-0 mt-16 ml-8">
                  {{ title }}
                </v-toolbar-title>
              </v-row>
              <v-spacer></v-spacer>
              <v-list rounded outlined v-show="dialog" class="mr-10 mt-2">
                <v-list-item link :to="'/board/writer/'">
                  <v-list-item-title>새글쓰기</v-list-item-title>
                  <v-list-item-action></v-list-item-action>
                </v-list-item>
                <v-list-item link :to="'/board/writer/'+boardKey">
                  <v-list-item-title>수정</v-list-item-title>
                  <v-list-item-action></v-list-item-action>
                </v-list-item>
                <v-list-item link>
                  <v-list-item-title>삭제</v-list-item-title>
                  <v-list-item-action></v-list-item-action>
                </v-list-item>
              </v-list>
            </v-app-bar>
          </v-img>

          <v-card-text>
            <v-card class="ma-2 pa-4">
              {{ context }}
            </v-card>
          </v-card-text>
          <v-card>
            <v-btn block outlined color="blue" @click="listClick"> 목록 </v-btn>
          </v-card>
        </v-card>
      </v-row>
    </v-container>
  </v-form>
</template> 
<script>
export default {
  name: "BoardView",
  data() {
    return {
      boardKey: "",
      title: "",
      context: "",
      user: "",
      dialog: false,
      messages: [
        {
          from: "You",
          message: `Sure, I'll see you later.`,
          time: "10:42am",
          color: "deep-purple lighten-1",
        },
        {
          from: "John Doe",
          message: "Yeah, sure. Does 1:00pm work?",
          time: "10:37am",
          color: "green",
        },
        {
          from: "You",
          message: "Did you still want to grab lunch today?",
          time: "9:47am",
          color: "deep-purple lighten-1",
        },
      ],
    };
  },
  methods: {
    fetch() {
      this.$http
        .get(process.env.API_URL + "v1/board/" + this.$route.params.seq)
        .then((response) => {
          this.$data.boardKey = response.data.boardKey;
          this.$data.user = response.data.cmUserVo.alias;
          this.$data.title = response.data.title;
          this.$data.context = response.data.content;
          this.$data.instDt = response.data.instDt;
          this.$data.updDt = response.data.updDt;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    listClick() {
      this.$router.push("/board/list");
    },
    deleteClick() {
      if (this.$data.seq) {
        this.$http
          .delete(process.env.API_URL + "v1/board/" + this.$data.number)
          .then((response) => {
            console.log(response);
            this.$router.push("/");
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
    convertDialog() {
      this.$data.dialog = !this.$data.dialog;
    }
  },
  created() {
    this.fetch();
  },
};
</script>

