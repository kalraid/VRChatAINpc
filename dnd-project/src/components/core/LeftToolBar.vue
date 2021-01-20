<template>
  <v-toolbar rounded tile>
    <v-app-bar-nav-icon> </v-app-bar-nav-icon>
    <v-app-bar-title>
      <div link :to="'//'" tag style="cursor: pointer">ProjectName</div>
    </v-app-bar-title>
    <v-spacer></v-spacer>
    <!-- <v-toolbar-items>
      <v-btn flat to="/"> Home </v-btn>
      <v-menu
        :rounded="rounded"
        open-on-hover
        offset-y
        transition="slide-x-transition"
        bottom
        right
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn flat v-bind="attrs" v-on="on"> Services </v-btn>
        </template>
        <v-list dense>
          <v-list-item
            v-for="(item, index) in services"
            :key="index"
            router
            :to="item.link"
          >
            <v-list-item-action>
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item-action>
          </v-list-item>
        </v-list>
      </v-menu>
      <v-btn to="/about" flat> About Us </v-btn>
      <v-btn to="/contact" flat> Contact Us </v-btn>
    </v-toolbar-items> -->
    <v-spacer></v-spacer>
    <v-toolbar-items class="hidden-sm-and-down">
      <v-btn to="/signup" flat>Sign Up </v-btn>
      <v-btn to="/login" flat>login</v-btn>
    </v-toolbar-items>
    <v-menu open-on-hover transition="slide-x-transition" bottom right offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn icon v-bind="attrs" v-on="on">
          <v-icon>mdi-dots-vertical</v-icon>
        </v-btn>
      </template>
      <v-card class="mx-auto" max-width="300" tile>
        <v-list dense>
          <v-subheader>THEMES</v-subheader>
          <v-list-item-group v-model="theme" color="primary">
            <v-list-item
              v-for="(item, i) in themes"
              :key="i"
              router
              :to="item.link"
            >
              <v-list-item-action>
                <v-icon v-text="item.icon"></v-icon>
              </v-list-item-action>
              <v-list-item-action>
                <v-list-item-title v-text="item.text"></v-list-item-title>
              </v-list-item-action>
            </v-list-item>
          </v-list-item-group>
        </v-list>
      </v-card>
    </v-menu>
  </v-toolbar>
</template>
<script>
export default {
  name: "LeftToolBar",
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
