<template>
  <v-app-bar rounded tile clipped-left>
    <v-app-bar-nav-icon> </v-app-bar-nav-icon>
    <v-app-bar-title>
      <div link :to="'//'" tag style="cursor: pointer">ProjectName</div>
    </v-app-bar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items class="hidden-sm-and-down">
      <v-btn to="/signup" flat>Sign Up </v-btn>
      <v-btn to="/login" flat>login</v-btn>
    </v-toolbar-items>
    <v-spacer></v-spacer>
    <v-icon>mdi-dots-vertical</v-icon>
  </v-app-bar>
</template>
<script>
export default {
  name: "LeftToolBar2",
  data() {
    return {
      activate: true,
      theme: 1,
      themes: [
        {
          text: "Dark",
          icon: "mdi-clock",
        },
        {
          text: "Light",
          icon: "mdi-account",
        },
      ],
      mini: true,
      services: [
        {
          icon: "mdi-domain",
          title: "Media Monitoring",
          link: "/mmrservices",
        },
        {
          icon: "mdi-message-text",
          title: "Audience Measurement",
          link: "/amrservices",
        },
        {
          icon: "mdi-flag",
          title: "Integration Analysis",
        },
      ],
    };
  },
};
</script>
