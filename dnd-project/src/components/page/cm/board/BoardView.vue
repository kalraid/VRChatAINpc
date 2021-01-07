/* ## BoardView.vue 파일 내용 */ 
<template>
  <v-form>
    <v-container>
      <v-row> 제목 </v-row> <v-row> {{ title }} </v-row> <v-row> 내용 </v-row>
      <v-row> {{ context }} </v-row>
      <v-row>
        <v-btn block outlined color="blue" @click="listClick"> 목록 </v-btn>
      </v-row>
    </v-container>
  </v-form>
</template> 
<script>
export default {
  name: "BoardView",
  created() {
    this.fetch();
  },
  methods: {
    fetch() {
      this.$http
        .get("http://localhost:8000/api/board/" + this.$$router.params.seq)
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    listClick() {
      this.$router.push("/");
    },
    deleteClick() {
      if (this.$data.seq) {
        this.$http
          .delete("http://localhost:8000/api/board/" + this.$data.seq)
          .then((response) => {
            console.log(response);
            this.$router.push("/");
          })
          .catch((error) => {
            console.log(error);
          });
      }
    }
  },
  data() {
    return { title: "", context: "" };
  }
};
</script>

