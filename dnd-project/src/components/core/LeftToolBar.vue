<template>
  <div>
    <v-navigation-drawer
      id="app-drawer"
      v-model="drawer"
      dark
      :color="colors.menu_background_color"
      floating
      persistent
      absolute
      mobile-break-point="960"
      width="350"
    >
      <div>
        <v-layout class="fill-height" tag="v-list" column>
          <v-list>
            <v-list-item @click="movePage('')">
              <v-toolbar-title>갤러리</v-toolbar-title>
            </v-list-item>
            <hr class="mt-2 mb-2" />
            <v-list-item-group active-class="white--text">
              <template v-for="menu in menus">
                <template v-if="menu.childrens">
                  <!-- 자식 메뉴가 있는경우 -->
                  <v-list-group :prepend-icon="menu.icon" :key="menu.id">
                    <template v-slot:activator>
                      <v-list-item-title>{{ menu.title }}</v-list-item-title>
                    </template>
                    <template v-for="children in menu.childrens">
                      <v-list-item
                        @click="movePage(children.target)"
                        :key="children.id"
                        class="ml-2"
                        :active-class="`${colors.menu_selected_color} accent-4 white--text`"
                      >
                        <v-list-item-icon
                          :active-class="`${colors.menu_selected_color} accent-4`"
                        >
                          <v-icon>{{ children.icon }}</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>
                          {{ children.title }}
                        </v-list-item-title>
                      </v-list-item>
                    </template>
                  </v-list-group>
                </template>
                <template v-else>
                  <!-- 단일 메뉴일 경우 -->
                  <v-list-item
                    @click="movePage(menu.target)"
                    :key="menu.id"
                    :active-class="`${colors.menu_selected_color} accent-4 white--text`"
                  >
                    <v-list-item-icon>
                      <v-icon>{{ menu.icon }}</v-icon>
                    </v-list-item-icon>
                    <v-list-item-title>{{ menu.title }}</v-list-item-title>
                  </v-list-item>
                </template>
              </template>
            </v-list-item-group>
          </v-list>
        </v-layout>
      </div>
    </v-navigation-drawer>
  </div>
</template>

<script>
// Utilities
import { mapState } from "vuex";
import _ from "lodash";

export default {
  name: "LeftToolBar",
  components: {},
  data: () => ({
    drawer: null,
    color: "success",
    responsive: false,
  }),
  computed: _.extend(mapState(["menus", "colors"])),
  mounted() {
    this.onResponsiveInverted();
    window.addEventListener("resize", this.onResponsiveInverted);
  },
  methods: {
    movePage(target) {
      //   this.$router.push({ name: target });
    },
    onResponsiveInverted() {
      if (window.innerWidth < 1000) {
        this.responsive = true;
      } else {
        this.responsive = false;
      }
    },
  },
};
</script>
