<template>
  <v-app-bar
    app
    flat
  >
    <v-app-bar-nav-icon
      class="hidden-md-and-up"
      @click="toggleDrawer"
    />

    <v-container class="mx-auto py-0">
      <v-row align="center">
        <v-img
          :src="require('@/assets/logo.png')"
          class="mr-5"
          contain
          height="48"
          width="48"
          max-width="48"
        />

        <v-btn
          v-for="(link, i) in links"
          :key="i"
          v-bind="link"
          class="hidden-sm-and-down"
          text
        >
          {{ link.text }}
        </v-btn>

        <v-spacer />

        <v-text-field
          append-icon="mdi-magnify"
          flat
          hide-details
          solo-inverted
          style="max-width: 300px;"
        />
      </v-row>
    </v-container>
  </v-app-bar>
</template>

<script>
// Utilities
import {
  mapGetters,
  mapMutations
} from 'vuex'

export default {
  name: 'CoreAppBar',

  computed: {
    ...mapGetters(['links'])
  },

  methods: {
    ...mapMutations(['toggleDrawer']),
  }
}
</script>
