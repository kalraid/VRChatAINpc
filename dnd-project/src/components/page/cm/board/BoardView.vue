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
                <p class="ml-3">{{ userName }}</p>
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
                <v-list-item link :to="'/board/list'">
                  <v-list-item-title>목록으로</v-list-item-title>
                  <v-list-item-action></v-list-item-action>
                </v-list-item>
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
          <v-card min-height="600">
            <v-card-text class="ma-2 pa-4" >
                {{ context }}
            </v-card-text>
          </v-card>
          <v-card class="pl-4 pt-4 pr-4 pm-0">
            <v-list>
                <v-item-group
                  v-model="replys"
                  mandatory
                  color="indigo"
                >
                  <v-list-item
                    v-for="(item, i) in replys"
                    :key="i"
                  > 
                      <v-list-item-content>
                        <!-- <v-list-item-title v-text="item.text"></v-list-item-title> -->
                        <v-list-item-title v-text="item.cmUserVo.alias"></v-list-item-title>
                        <v-list-item-content v-text="item.content"></v-list-item-content>
                      </v-list-item-content>
                  </v-list-item>
                </v-item-group>
            </v-list>
            <v-text-field
              v-model="reply"
              append-outer-icon="mdi-send"
              prepend-icon="mdi-emoticon-happy"
              filled
              clear-icon="mdi-close-circle"
              clearable
              label="Message"
              type="text"
              @click:append-outer="sendReply"
              @click:prepend="setEmoticon"
            ></v-text-field>
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
      userName: "kimrie",
      userKey: "1",
      reply: "",
      replys: [{}],
      dialog: false
    };
  },
  methods: {
    fetch() {
      this.$http
        .get(process.env.API_URL + "v1/board/" + this.$route.params.seq)
        .then((response) => {
          this.$data.boardKey = response.data.boardKey;
          this.$data.userName = response.data.cmUserVo.alias;
          this.$data.userKey = response.data.cmUserVo.userKey;
          this.$data.title = response.data.title;
          this.$data.context = response.data.content;
          this.$data.instDt = response.data.instDt;
          this.$data.updDt = response.data.updDt;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    fetchReply() {
      let params = {
        boardKey: this.$route.params.seq
      }
      
      this.$http
        .post(process.env.API_URL + "v1/comment/list/", params)
        .then((response) => {
          this.$data.replys = response.data.content;
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
    },
    sendReply() {
      let params = {
        cmBoardVo: {
          boardKey: this.$route.params.seq,
        },
        cmUserVo: {
          userKey: this.$data.userKey,
        },
        content: this.$data.reply
      }

      this.$http
        .put(process.env.API_URL + "v1/comment", params)
        .then((response) => {
          this.fetchReply();
          // this.$data.replys = response.data.content;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    setEmoticon() {

    }
  },
  created() {
    this.fetch();
    this.fetchReply();
  },
};
</script>

