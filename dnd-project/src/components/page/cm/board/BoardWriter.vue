/* ## BoardWrite.vue 파일 내용 */ 
<template>
  <v-form>
    <v-container>
      <v-row class="order-2 pa-2">
        <v-text-field
          :counter="50"
          label="제목"
          name="title"
          required
          v-model="title"
          maxlength="50"
        ></v-text-field>
      </v-row>
      <v-row class="order-2 pa-2">
        <v-textarea
          filled
          name="context"
          hint="내용을 입력해주세요."
          v-model="context"
          :counter="1000"
          maxlength="1000"
          height="400"
        ></v-textarea>
      </v-row>
      <v-row class="mb-6">
        <v-btn block outlined color="blue" @click="writeClick"> {{ writeType }} </v-btn>
      </v-row>
    </v-container>
  </v-form>
</template> 
<script>
export default {
  name: "BoardWriter",
  data() {
    return {
      boardKey: "",
      title: "",
      context: "",
      updDt: "",
      instDt: "",
      user: "",
      userKey: "",
      galleryKey: "1",
      writeType: "등록",
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
          this.$data.userKey = response.data.cmUserVo.userKey;
          this.$data.galleryKey = response.data.cmGalleryVo.galleryKey;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    writeClick() {
      if (this.$route.params.seq) {
        this.$http
          .put(process.env.API_URL + "/character/list", this.$data)
          .then((response) => {
            console.log(response);
            this.$router.push("/");
          })
          .catch((error) => {
            console.log(error);
          });
      } else {
        this.$data.regDt = this.getNowDate();
        this.$data.uptDt = this.getNowDate();
        this.$http
          .get(process.env.API_URL + "/character/list", this.$data)
          .then((response) => {
            console.log(response);
            this.$router.push("/");
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
    getNowDate() {
      var nowDate = new Date();
      var year = nowDate.getFullYear().toString();
      var month = (nowDate.getMonth() + 1).toString();
      var day = nowDate.getDate().toString();
      return (
        year +
        "-" +
        (month[1] ? month : "0" + month[0]) +
        "-" +
        (day[1] ? day : "0" + day[0])
      );
    },
  },
  created() {
    if (this.$route.params.seq) {
      this.fetch();
      this.$data.writeType = "수정";
    }
  },
};
</script>

