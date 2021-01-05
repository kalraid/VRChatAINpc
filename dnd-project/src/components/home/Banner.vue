<template>
  <base-card dark>
    <v-img
      :src="require('@/assets/articles/blurcamera.jpg')"
      class="grey lighten-2"
      height="400"
      width="100%"
    >
      <v-row
        class="fill-height pa-3"
        align="center"
      >
        <v-col
          cols="12"
          md="7"
          offset-md="5"
        >
          <h1 class="display-3 font-weight-light">
            The Art Of Travel
          </h1>

          <div class="subheading text-uppercase pl-2 mb-4">
            Finding Beauty, One flight at a time
          </div>

          <v-btn
            color="primary"
            depressed
          >
            Subscribe
          </v-btn>
        </v-col>
      </v-row>
    </v-img>
  </base-card>
</template>

<script>
export default {
  name: 'HomeBanner'
}
</script>
