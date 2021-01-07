<template>
    <div class="BoardList">
      <v-container>
        <v-row>
          <v-col cols="12">
            <h3
              ref="radio"
              class="headline"
            >
              Target
            </h3>

            <v-radio-group
              v-model="type"
              row
            >
              <v-radio
                label="Number"
                value="number"
              ></v-radio>

              <v-radio
                label="Selector"
                value="selector"
              ></v-radio>

              <v-radio
                label="DOMElement"
                value="element"
              ></v-radio>
            </v-radio-group>

            <v-text-field
              v-if="type === 'number'"
              v-model="number"
              type="number"
              label="Number"
            ></v-text-field>

            <v-select
              v-if="type === 'selector'"
              v-model="selector"
              label="Selector"
              :items="selections"
            ></v-select>

            <v-select
              v-if="type === 'element'"
              v-model="selected"
              :items="elements"
              label="DOMElement"
            ></v-select>
          </v-col>

          <v-col cols="12">
            <h3 class="headline">
              Options
            </h3>

            <v-select
              v-model="easing"
              :items="easings"
              label="Easing"
            ></v-select>

            <v-slider
              v-model="duration"
              min="0"
              max="1000"
              label="Duration"
              thumb-label
            ></v-slider>

            <v-slider
              v-model="offset"
              min="-500"
              max="500"
              label="Offset"
              thumb-label
            ></v-slider>
          </v-col>

          <v-col>
            <v-btn
              ref="button"
              block
              color="primary"
              @click="$vuetify.goTo(target, options)"
            >
              scroll
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
      <v-select
        :items="['Fizz', 'Buzz']"
        label="Items"
      >
        <template v-slot:item="{ item, attrs, on }">
          <v-list-item
            v-bind="attrs"
            v-on="on"
          >
            <v-list-item-content>
              <v-list-item-title
                :id="attrs['aria-labelledby']"
                v-text="item.title"
              ></v-list-item-title>

              <v-list-item-subtitle v-text="item.sub"></v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </template>
      </v-select>

      <div class="text-center">
        <v-menu>
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              v-bind="attrs"
              v-on="on"
            >
              Click me
            </v-btn>
          </template>

          <v-list>
            <v-list-item @click="onClick">
              <v-list-item-title>Option 1</v-list-item-title>
            </v-list-item>

            <v-list-item disabled>
              <v-list-item-title>Option 2</v-list-item-title>
            </v-list-item>

            <v-list-item @click="onClick">
              <v-list-item-title>Option 3</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
    </div>

      <v-card
        class="mx-auto"
        max-width="500"
      >
      <v-list>
        <v-list-item-group v-model="model">
          <v-list-item
            v-for="(item, i) in items"
            :key="i"
            :disabled="item.disabled"
          >
            <v-list-item-content>
              <v-list-item-title v-text="item.text"></v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-card>

    <v-card
      :height="height"
      class="mx-auto"
      max-width="800"
    >
      <pre>
        {{ breakpointinfo }}
      </pre>
        {{ breakpointname }}
    </v-card>

    <v-icon>{{ svgPath }}</v-icon>

    <v-icon v-text="icon"></v-icon>
    <slot></slot>

     <v-card
      dark
      flat
    >
      <v-toolbar
        flat
        height="72"
      >
        <v-switch
          v-model="$vuetify.theme.dark"
          hint="This toggles the global state of the Vuetify theme"
          inset
          label="Vuetify Theme Dark"
          persistent-hint
        ></v-switch>
      </v-toolbar>
      <v-card-text>
        <v-list>
          <v-subheader>I inherit dark from my parent</v-subheader>
          <v-list-item
            v-for="item in item"
            :key="item"
          >
            <v-list-item-title v-text="item"></v-list-item-title>
          </v-list-item>
        </v-list>
        <v-divider class="mb-y"></v-divider>
        <v-theme-provider root>
          <v-list :rounded="b">
            <v-subheader>
              <span>I inherit from the root</span>
              <strong>&nbsp;$vuetify.theme.dark</strong>
            </v-subheader>
            <v-list-item
              v-for="item in item"
              :key="item"
            >
              <v-list-item-title v-text="item"></v-list-item-title>
            </v-list-item>
          </v-list>
        </v-theme-provider>
      </v-card-text>
    </v-card>

    <div class="text-center">
      <v-slider
        v-model="model"
        :max="rounded.length - 1"
        :tick-labels="rounded"
      ></v-slider>
      <div class="py-3"></div>
      <v-sheet
        :class="radius"
        :max-width="model === 6 ? 128 : 256"
        class="mx-auto transition-swing secondary"
        elevation="12"
        height="128"
        width="100%"
      ></v-sheet>
      <div class="py-3"></div>
      <code class="text-subtitle-1">.{{ radius }}</code>
    </div>

    <div class="purple darken-2 text-center">
      <span class="white--text">Lorem ipsum</span>
    </div>

    <div>
      Lorem ipsum dolor sit amet, <strong class="red--text text--lighten-1">inciderint</strong>
      definitionem est ea, explicari prodesset eam id. Mazim doctus vix an.
      <span class="indigo--text text--darken-2">Amet causae probatus nec ex</span>.
    </div>

    <div>
      <div class="d-inline pa-2 deep-purple accent-4 white--text">
        d-inline
      </div>
      <div class="d-inline pa-2 black white--text">
        d-inline
      </div>
    </div>

    <div>
      <div class="d-block pa-2 deep-purple accent-4 white--text">
        d-block
      </div>
      <div class="d-block pa-2 black white--text">
        d-block
      </div>
    </div>

    <div>
      <div class="d-lg-none">
        hide on screens wider than lg
      </div>
      <div class="d-none d-lg-block">
        hide on screens smaller than lg
      </div>
    </div>

    <div>
      <div class="d-print-none">
        Screen Only (Hide on print only)
      </div>
      <div class="d-none d-print-block">
        Print Only (Hide on screen only)
      </div>
      <div class="d-none d-lg-block d-print-block">
        Hide up to large on screen, but always show on print
      </div>
    </div>

    <v-container>
      <v-row justify="center">
        <v-col
          v-for="n in 25"
          :key="n"
          cols="auto"
        >
          <v-card
            :elevation="n - 1"
            height="100"
            width="100"
            class="secondary"
          >
            <v-row
              class="fill-height"
              align="center"
              justify="center"
              v-text="n - 1"
            ></v-row>
          </v-card>
        </v-col>
      </v-row>
    </v-container>

    <div class="text--primary">
      <!-- Using the elevation prop -->
      <v-hover>
        <template v-slot:default="{ hover }">
          <v-card
            :elevation="hover ? 24 : 6"
            class="mx-auto pa-6"
          >
            Prop based elevation
          </v-card>
        </template>
      </v-hover>
      <div class="my-6"></div>
      <!-- Using a dynamic class -->
      <v-hover>
        <template v-slot:default="{ hover }">
          <div
            :class="`elevation-${hover ? 24 : 6}`"
            class="mx-auto pa-6 transition-swing"
          >
            Class based elevation
          </div>
        </template>
      </v-hover>
    </div>

    <v-card
      class="d-flex pa-2"
      outlined
      tile
    >
      <div>
        I'm a flexbox container!
      </div>
    </v-card>

      <v-card
      class="d-inline-flex pa-2"
      outlined
      tile
    >
      <div>
        I'm an inline flexbox container!
      </div>
    </v-card>

          <v-card
        class="d-flex flex-row mb-6"
        :color="$vuetify.theme.dark ? 'grey darken-3' : 'grey lighten-4'"
        flat
        tile
      >
      <v-card
          v-for="n in 3"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          Flex item {{ n }}
        </v-card>
      </v-card>
      <v-card
        class="d-flex flex-row-reverse"
        :color="$vuetify.theme.dark ? 'grey darken-3' : 'grey lighten-4'"
        flat
        tile
      >
        <v-card
          v-for="n in 3"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          Flex item {{ n }}
        </v-card>
      </v-card>

      <div>
        <div class="d-flex flex-column mb-6">
          <v-card
            v-for="n in 3"
            :key="n"
            class="pa-2"
            outlined
            tile
          >
            Flex item {{ n }}
          </v-card>
        </div>
        <div class="d-flex flex-column-reverse">
          <v-card
            v-for="n in 3"
            :key="n"
            class="pa-2"
            outlined
            tile
          >
          Flex item {{ n }}
        </v-card>
      </div>
    </div>

    <div>
      <v-card
        class="d-flex justify-start mb-6"
        :color="$vuetify.theme.dark ? 'grey darken-3' : 'grey lighten-4'"
        flat
        tile
      >
        <v-card
          v-for="n in 3"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          justify-start
        </v-card>
      </v-card>
      <v-card
        class="d-flex justify-end mb-6"
        :color="$vuetify.theme.dark ? 'grey darken-3' : 'grey lighten-4'"
        flat
        tile
      >
        <v-card
          v-for="n in 3"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          justify-end
        </v-card>
      </v-card>
      <v-card
        class="d-flex justify-center mb-6"
        :color="$vuetify.theme.dark ? 'grey darken-3' : 'grey lighten-4'"
        flat
        tile
      >
        <v-card
          v-for="n in 3"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          justify-center
        </v-card>
      </v-card>
      <v-card
        class="d-flex justify-space-between mb-6"
        :color="$vuetify.theme.dark ? 'grey darken-3' : 'grey lighten-4'"
        flat
        tile
      >
        <v-card
          v-for="n in 3"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          justify-space-between
        </v-card>
      </v-card>
      <v-card
        class="d-flex justify-space-around mb-6"
        :color="$vuetify.theme.dark ? 'grey darken-3' : 'grey lighten-4'"
        flat
        tile
      >
        <v-card
          v-for="n in 3"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          justify-space-around
        </v-card>
      </v-card>
    </div>

    <div>
      <v-card
        class="d-flex align-start mb-6"
        color="grey lighten-2"
        flat
        height="100"
        tile
      >
        <v-card
          v-for="n in 3"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          align-start
        </v-card>
      </v-card>
      <v-card
        class="d-flex align-end mb-6"
        color="grey lighten-2"
        flat
        height="100"
        tile
      >
        <v-card
          v-for="n in 3"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          align-end
        </v-card>
      </v-card>
      <v-card
        class="d-flex align-center mb-6"
        color="grey lighten-2"
        flat
        height="100"
        tile
      >
        <v-card
          v-for="n in 3"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          align-center
        </v-card>
      </v-card>
      <v-card
        class="d-flex align-baseline mb-6"
        color="grey lighten-2"
        flat
        height="100"
        tile
      >
        <v-card
          v-for="n in 3"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          align-baseline
        </v-card>
      </v-card>
      <v-card
        class="d-flex align-stretch mb-6"
        color="grey lighten-2"
        flat
        height="100"
        tile
      >
        <v-card
          v-for="n in 3"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          align-stretch
        </v-card>
      </v-card>
    </div>

      <div>
      <v-card
        v-for="j in justify"
        :key="j"
        class="d-flex mb-6"
        color="grey lighten-2"
        flat
        height="100"
        tile
      >
        <v-card
          v-for="n in 3"
          :key="n"
          class="pa-2"
          :class="[n === 2 && `align-self-${j}`]"
          outlined
          tile
        >
          {{ n === 2 ? 'Aligned flex item' : 'Flex item' }}
        </v-card>
      </v-card>
    </div>

    <div>
      <v-card
        class="d-flex mb-6"
        color="grey lighten-2"
        flat
        tile
      >
        <v-card
          v-for="n in 3"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          Flex item
        </v-card>
      </v-card>
      <v-card
        class="d-flex mb-6"
        color="grey lighten-2"
        flat
        tile
      >
        <v-card
          v-for="n in 3"
          :key="n"
          :class="n === 1 && 'mr-auto'"
          class="pa-2"
          outlined
          tile
        >
          Flex item
        </v-card>
      </v-card>
      <v-card
        class="d-flex mb-6"
        color="grey lighten-2"
        flat
        tile
      >
        <v-card
          v-for="n in 3"
          :key="n"
          :class="n === 3 && 'ml-auto'"
          class="pa-2"
          outlined
          tile
        >
          Flex item
        </v-card>
      </v-card>
    </div>

    <div>
      <v-card
        class="d-flex align-start flex-column mb-6"
        color="grey lighten-2"
        flat
        tile
        height="200"
      >
        <v-card
          v-for="n in 3"
          :key="n"
          :class="n === 1 && 'mb-auto'"
          class="pa-2"
          outlined
          tile
        >
          Flex item
        </v-card>
      </v-card>
      <v-card
        class="d-flex align-end flex-column"
        color="grey lighten-2"
        flat
        tile
        height="200"
      >
        <v-card
          v-for="n in 3"
          :key="n"
          :class="n === 3 && 'mt-auto'"
          class="pa-2"
          outlined
          tile
        >
          Flex item
        </v-card>
      </v-card>
    </div>

    <div>
      <v-card
        class="d-flex flex-nowrap py-3"
        color="grey lighten-2"
        flat
        tile
        width="125"
      >
        <v-card
          v-for="n in 5"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          Flex item
        </v-card>
      </v-card>
    </div>

    <div>
      <v-card
        class="d-flex flex-wrap"
        color="grey lighten-2"
        flat
        tile
      >
        <v-card
          v-for="n in 20"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          Flex item
        </v-card>
      </v-card>
    </div>

    <div>
      <v-card
        class="d-flex flex-wrap-reverse"
        color="grey lighten-2"
        flat
        tile
      >
        <v-card
          class="order-3 pa-2"
          outlined
          tile
        >
          First flex item
        </v-card>
        <v-card
          class="order-2 pa-2"
          outlined
          tile
        >
          Second flex item
        </v-card>
        <v-card
          class="order-1 pa-2"
          outlined
          tile
        >
          Third flex item
        </v-card>
      </v-card>
    </div>

    <div>
      <v-card
        class="d-flex align-content-start flex-wrap"
        color="grey lighten-2"
        flat
        tile
        min-height="200"
      >
        <v-card
          v-for="n in 20"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          Flex item
        </v-card>
      </v-card>
    </div>

    <div>
      <v-card
        class="d-flex align-content-end flex-wrap"
        color="grey lighten-2"
        flat
        tile
        min-height="200"
      >
        <v-card
          v-for="n in 20"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          Flex item
        </v-card>
      </v-card>
    </div>

    <div>
      <v-card
        class="d-flex align-content-space-around flex-wrap"
        color="grey lighten-2"
        flat
        tile
        min-height="200"
      >
        <v-card
          v-for="n in 20"
          :key="n"
          class="pa-2"
          outlined
          tile
        >
          Flex item
        </v-card>
      </v-card>
    </div>

    <v-container class="grey lighten-5">
      <v-row
        no-gutters
        style="flex-wrap: nowrap;"
      >
        <v-col
          cols="2"
          class="flex-grow-0 flex-shrink-0"
        >
          <v-card
            class="pa-2"
            outlined
            tile
          >
            I'm 2 column wide
          </v-card>
        </v-col>
        <v-col
          cols="1"
          style="min-width: 100px; max-width: 100%;"
          class="flex-grow-1 flex-shrink-0"
        >
          <v-card
            class="pa-2"
            outlined
            tile
          >
            I'm 1 column wide and I grow to take all the space
          </v-card>
        </v-col>
        <v-col
          cols="5"
          style="min-width: 100px;"
          class="flex-grow-0 flex-shrink-1"
        >
          <v-card
            class="pa-2"
            outlined
            tile
          >
            I'm 5 column wide and I shrink if there's not enough space
          </v-card>
        </v-col>
      </v-row>
    </v-container>

    <div>
      <div class="float-sm-left">
        Float left on viewports sized SM (small) or wider
      </div>
      <br>
      <div class="float-md-left">
        Float left on viewports sized MD (medium) or wider
      </div>
      <br>
      <div class="float-lg-left">
        Float left on viewports sized LG (large) or wider
      </div>
      <br>
      <div class="float-xl-left">
        Float left on viewports sized XL (extra-large) or wider
      </div>
      <br>
    </div>
    <v-card
      class="pa-md-4 mx-lg-auto"
      color="secondary"
      width="250px"
    >
      <v-card-text>
        Adjust screen size to see spacing changes
      </v-card-text>
    </v-card>

    <v-card
      class="mx-auto"
      color="secondary"
      width="200px"
    >
      <v-card-text>
        Centered
      </v-card-text>
    </v-card>

    <v-card
      class="mx-auto"
      height="100"
      max-width="200"
      color="secondary"
    ></v-card>
    <v-card
      class="mt-n12 mx-auto"
      elevation="12"
      height="200"
      max-width="300"
      color="secondary"
    >
      <v-card-text>This card has negative top margin applied</v-card-text>
    </v-card>
    <v-item-group mandatory>
      <v-sheet
        class="overflow-y-auto"
        max-height="600"
        tile
      >
        <v-item
          v-for="[
            c,
            text,
            size,
            weight,
            spacing,
            margin
          ] in classes"
          :key="c"
        >
          <template v-slot:default="{ active, toggle }">
            <v-sheet
              :color="active ? $vuetify.theme.dark ? 'grey darken-3' : 'grey lighten-4' : undefined"
              class="px-4 pt-4 pb-3"
              tile
              style="cursor: pointer;"
              @click="toggle"
            >
              <div
                :class="[`text-${c}`, active && `mb-${margin}`]"
                class="transition-swing"
                v-text="text"
              >
              </div>
  
              <v-expand-transition>
                <v-responsive
                  v-if="active"
                  max-width="350"
                >
                  <div class="d-flex justify-space-between caption">
                    <div>
                      <div class="grey--text mb-2">
                        Font
                      </div>
  
                      <div class="font-weight-medium">
                        Roboto
                      </div>
                    </div>
  
                    <div>
                      <div class="grey--text mb-2">
                        Weight
                      </div>
  
                      <div
                        class="font-weight-medium"
                        v-text="weight"
                      ></div>
                    </div>
  
                    <div>
                      <div class="grey--text mb-2">
                        Size
                      </div>
  
                      <div
                        class="font-weight-medium"
                        v-text="size"
                      ></div>
                    </div>
  
                    <div>
                      <div class="grey--text text-darken-1 mb-2">
                        Letter spacing
                      </div>
  
                      <div
                        class="font-weight-medium"
                        v-text="spacing"
                      ></div>
                    </div>
                  </div>
                </v-responsive>
              </v-expand-transition>
            </v-sheet>
          </template>
        </v-item>
      </v-sheet>
    </v-item-group>
    <div>
      <v-item-group
        v-model="model2"
        class="pa-2 d-flex justify-center"
        mandatory
      >
        <v-item
          v-for="([icon, bp, size], i) in sizes"
          :key="i"
          :value="size"
        >
          <template v-slot:default="{ active, toggle }">
            <v-hover v-slot="{ hover }">
              <div
                :class="[(active || hover) ? 'text--primary' : 'text--secondary']"
                class="ma-3 text-center"
                style="cursor: pointer"
                @click="toggle"
              >
                <v-icon
                  :color="(active || hover) ? 'grey darken-4' : 'grey lighten-1'"
                  class="pa-1 mb-1"
                  v-text="icon"
                ></v-icon>
  
                <div
                  class="caption"
                  v-text="bp"
                ></div>
              </div>
            </v-hover>
          </template>
        </v-item>
      </v-item-group>
  
      <div class="text-h5 mb-6 text-center">
        <code v-text="typeClass"></code>
      </div>
  
      <v-card
        class="d-flex align-center justify-center pa-4 mx-auto"
        max-width="550"
        min-height="76"
        outlined
      >
        <div :class="`text-${model}`">
          Example Heading
        </div>
      </v-card>
    </div>

    <div>
      <p class="font-weight-black">
        Black text.
      </p>
      <p class="font-weight-bold">
        Bold text.
      </p>
      <p class="font-weight-medium">
        Medium weight text.
      </p>
      <p class="font-weight-regular">
        Normal weight text.
      </p>
      <p class="font-weight-light">
        Light weight text.
      </p>
      <p class="font-weight-thin">
        Thin weight text.
      </p>
      <p class="font-italic">
        Italic text.
      </p>
    </div>

    <p class="text-justify">
      Morbi mattis ullamcorper velit. Donec orci lectus, aliquam ut, faucibus non, euismod id, nulla. Fusce convallis metus id felis luctus adipiscing. Aenean massa. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus.
  
      Nulla consequat massa quis enim. Praesent venenatis metus at tortor pulvinar varius. Donec venenatis vulputate lorem. Phasellus accumsan cursus velit. Pellentesque ut neque.
    </p>

    <div>
      <p class="text-left">
        Left aligned text on all viewport sizes.
      </p>
      <p class="text-center">
        Center aligned text on all viewport sizes.
      </p>
      <p class="text-right">
        Right aligned text on all viewport sizes.
      </p>
  
      <p class="text-sm-left">
        Left aligned text on viewports sized SM (small) or wider.
      </p>
      <p class="text-md-left">
        Left aligned text on viewports sized MD (medium) or wider.
      </p>
      <p class="text-lg-left">
        Left aligned text on viewports sized LG (large) or wider.
      </p>
      <p class="text-xl-left">
        Left aligned text on viewports sized XL (extra-large) or wider.
      </p>
    </div>

    <div>
      <a
        href="#"
        class="text-decoration-none"
      >Non-underlined link</a>
  
      <div class="text-decoration-line-through">
        Line-through text
      </div>
  
      <div class="text-decoration-overline">
        Overline text
      </div>
  
      <div class="text-decoration-underline">
        Underline text
      </div>
    </div>

    <div>
      <p class="text--primary">
        High-emphasis has an opacity of 87%.
      </p>
      <p class="text--secondary">
        Medium-emphasis text and hint text have opacities of 60%.
      </p>
      <p class="text--disabled">
        Disabled text has an opacity of 38%.
      </p>
    </div>

    <div>
      <p class="text-lowercase">
        Lowercased text.
      </p>
      <p class="text-uppercase">
        Uppercased text.
      </p>
      <p class="text-capitalize">
        CapiTaliZed text.
      </p>
    </div>

    <div>
      <p class="custom-transform-class text-none">
        Random TEXT cApitaLization
      </p>
      <p
        class="text-break"
        style="max-width: 4rem;"
      >
        SUBDERMATOGLYPHIC
      </p>
    </div>

    <div
      class="text-no-wrap secondary"
      style="width: 8rem;"
    >
      This text should overflow the parent.
    </div>

    <div>
      <!-- Block level -->
      <div class="row">
        <div class="col-2 text-truncate">
          Suspendisse faucibus, nunc et pellentesque egestas, lacus ante convallis tellus.
        </div>
      </div>
  
      <!-- Inline level -->
      <span
        class="d-inline-block text-truncate"
        style="max-width: 150px;"
      >
        Suspendisse faucibus, nunc et pellentesque egestas, lacus ante convallis tellus.
      </span>
    </div>

    <div>
      <p class="subtitle-2 text-center">
        Agnostic RTL Alignment
      </p>
  
      <p class="text-sm-left">
        Left aligned text on viewports sized SM (small) or wider for rtl or ltr.
      </p>
      <p class="text-md-left">
        Left aligned text on viewports sized MD (medium) or wider for rtl or ltr.
      </p>
      <p class="text-lg-right">
        Right aligned text on viewports sized LG (large) or wider for rtl or ltr.
      </p>
      <p class="text-xl-left">
        Left aligned text on viewports sized XL (extra-large) or wider for rtl or ltr.
      </p>
  
      <p class="subtitle-2 text-center">
        Responsive RTL Alignment
      </p>
  
      <p class="text-start">
        Left aligned text on ltr and right aligned on rtl.
      </p>
      <p class="text-end">
        Right aligned text on ltr and left aligned on rtl.
      </p>
    </div>

    <v-row justify="center">
      <v-menu transition="slide-x-transition">
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            color="primary"
            class="ma-2"
            v-bind="attrs"
            v-on="on"
          >
            Slide X Transition
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="n in 5"
            :key="n"
            link
          >
            <v-list-item-title v-text="'Item ' + n"></v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
  
      <div class="mx-6 hidden-sm-and-down"></div>
  
      <v-menu transition="scroll-y-transition">
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            color="secondary"
            class="ma-2"
            v-bind="attrs"
            v-on="on"
          >
            Scroll Y Transition
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="n in 5"
            :key="n"
            link
          >
            <v-list-item-title v-text="'Item ' + n"></v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </v-row>

    <div class="text-center">
      <v-menu
        transition="scale-transition"
        origin="center center"
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            dark
            color="primary"
            v-bind="attrs"
            v-on="on"
          >
            Scale Transition
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="n in 5"
            :key="n"
            @click="() => {}"
          >
            <v-list-item-title v-text="'Item ' + n"></v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </div>

    <v-row
      justify="center"
  
      style="min-height: 160px;"
    >
      <v-col class="shrink">
        <v-btn
          class="ma-2"
          color="primary"
          @click="expand = !expand"
        >
          Expand Transition
        </v-btn>
  
        <v-expand-transition>
          <v-card
            v-show="expand"
            height="100"
            width="100"
            class="mx-auto secondary"
          ></v-card>
        </v-expand-transition>
      </v-col>
  
      <div class="mx-4 hidden-sm-and-down"></div>
  
      <v-col class="shrink">
        <v-btn
          class="ma-2"
          color="secondary"
          @click="expand2 = !expand2"
        >
          Expand X Transition
        </v-btn>
  
        <v-expand-x-transition>
          <v-card
            v-show="expand2"
            height="100"
            width="100"
            class="mx-auto secondary"
          ></v-card>
        </v-expand-x-transition>
      </v-col>
    </v-row>

    <div class="text-center">
      <v-menu transition="fade-transition">
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            dark
            color="primary"
            v-bind="attrs"
            v-on="on"
          >
            Fade Transition
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="n in 5"
            :key="n"
          >
            <v-list-item-title v-text="'Item ' + n"></v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </div>

    <div class="text-center">
      <v-menu transition="scale-transition">
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            dark
            color="primary"
            v-bind="attrs"
            v-on="on"
          >
            Scale Transition
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="n in 5"
            :key="n"
          >
            <v-list-item-title v-text="'Item ' + n"></v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </div>

    <v-row
      justify="center"
    >
      <v-menu transition="scroll-y-transition">
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            color="primary"
            class="ma-2"
            v-bind="attrs"
            v-on="on"
          >
            Scroll Y Transition
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="n in 5"
            :key="n"
            link
          >
            <v-list-item-title v-text="'Item ' + n"></v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
  
      <div class="mx-4 hidden-sm-and-down"></div>
  
      <v-menu transition="scroll-y-reverse-transition">
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            color="secondary"
            class="ma-2"
            v-bind="attrs"
            v-on="on"
          >
            Scroll Y Reverse Transition
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="n in 5"
            :key="n"
            link
          >
            <v-list-item-title v-text="'Item ' + n"></v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </v-row>

    <v-row
      justify="center"
    >
      <v-menu transition="slide-x-transition">
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            color="primary"
            class="ma-2"
            v-bind="attrs"
            v-on="on"
          >
            Slide X Transition
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="n in 5"
            :key="n"
            link
          >
            <v-list-item-title v-text="'Item ' + n"></v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
  
      <div class="mx-4 hidden-sm-and-down"></div>
  
      <v-menu transition="slide-x-reverse-transition">
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            color="secondary"
            class="ma-2"
            v-bind="attrs"
            v-on="on"
          >
            Slide X Reverse Transition
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="n in 5"
            :key="n"
            link
          >
            <v-list-item-title v-text="'Item ' + n"></v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </v-row>

        <v-row
      justify="center"
    >
      <v-menu transition="slide-y-transition">
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            color="primary"
            class="ma-2"
            v-bind="attrs"
            v-on="on"
          >
            Slide Y Transition
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="n in 5"
            :key="n"
            link
          >
            <v-list-item-title v-text="'Item ' + n"></v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
  
      <div class="mx-4 hidden-sm-and-down"></div>
  
      <v-menu transition="slide-y-reverse-transition">
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            color="secondary"
            class="ma-2"
            v-bind="attrs"
            v-on="on"
          >
            Slide Y Reverse Transition
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="n in 5"
            :key="n"
            link
          >
            <v-list-item-title v-text="'Item ' + n"></v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </v-row>

    <v-container style="max-width: 500px">
      <v-text-field
        v-model="newTask"
        label="What are you working on?"
        solo
        @keydown.enter="create"
      >
        <template v-slot:append>
          <v-fade-transition>
            <v-icon
              v-if="newTask"
              @click="create"
            >
              add_circle
            </v-icon>
          </v-fade-transition>
        </template>
      </v-text-field>
  
      <h2 class="display-1 success--text pl-4">
        Tasks:&nbsp;
        <v-fade-transition leave-absolute>
          <span :key="`tasks-${tasks.length}`">
            {{ tasks.length }}
          </span>
        </v-fade-transition>
      </h2>
  
      <v-divider class="mt-4"></v-divider>
  
      <v-row
        class="my-1"
        align="center"
      >
        <strong class="mx-4 info--text text--darken-2">
          Remaining: {{ remainingTasks }}
        </strong>
  
        <v-divider vertical></v-divider>
  
        <strong class="mx-4 success--text text--darken-2">
          Completed: {{ completedTasks }}
        </strong>
  
        <v-spacer></v-spacer>
  
        <v-progress-circular
          :value="progress"
          class="mr-2"
        ></v-progress-circular>
      </v-row>
  
      <v-divider class="mb-4"></v-divider>
  
      <v-card v-if="tasks.length > 0">
        <v-slide-y-transition
          class="py-0"
          group
          tag="v-list"
        >
          <template v-for="(task, i) in tasks">
            <v-divider
              v-if="i !== 0"
              :key="`${i}-divider`"
            ></v-divider>
  
            <v-list-item :key="`${i}-${task.text}`">
              <v-list-item-action>
                <v-checkbox
                  v-model="task.done"
                  :color="task.done && 'grey' || 'primary'"
                >
                  <template v-slot:label>
                    <div
                      :class="task.done && 'grey--text' || 'primary--text'"
                      class="ml-4"
                      v-text="task.text"
                    ></div>
                  </template>
                </v-checkbox>
              </v-list-item-action>
  
              <v-spacer></v-spacer>
  
              <v-scroll-x-transition>
                <v-icon
                  v-if="task.done"
                  color="success"
                >
                  mdi-check
                </v-icon>
              </v-scroll-x-transition>
            </v-list-item>
          </template>
        </v-slide-y-transition>
      </v-card>
    </v-container>

    
  </div>
</template>
<script>
import { mdiAccount } from '@mdi/js'

/* eslint-disable */
export default {
  name: 'ExvuetifyForm',
  // vuetify: new Vuetify(),
  props: {
    attrs: {
      type: Object,
      default: () => ({}),
    },
  },
  data: () => ({
    items: [
      {
        text: 'Item 1',
        disabled: false,
      },
      {
        text: 'Item 2',
        disabled: true,
      },
      {
        text: 'Item 3',
        disabled: false,
      },
    ],
    item: ['One', 'Two', 'Three'],
    model: 0,
    breakpointinfo: 'Extra small	xs	Small to large phone	< 600px \r\n'+
              'Small	sm	Small to medium tablet	600px > < 960px \r\n'+
              'Medium	md	Large tablet to laptop	960px > < 1264px*\r\n'+
              'Large	lg	Desktop	1264px > < 1904px*\r\n'+
              'Extra large	xl	4k and ultra-wide	> 1904px*\r\n',
    svgPath: mdiAccount,
    ////
    icon: {
      type: String,
      default: '$cancel'
    },
    ////
    type: 'number',
    number: 9999,
    selector: '#first',
    selections: ['#first', '#second', '#third'],
    selected: 'Button',
    elements: ['Button', 'Radio group'],
    duration: 300,
    offset: 0,
    easing: 'easeInOutCubic',
    easings: Object.keys({
      linear: '',
      easeInQuad: '',
      easeOutQuad: '',
      easeInOutQuad: '',
      easeInCubic: '',
      easeOutCubic: '',
      easeInOutCubic: '',
      easeInQuart: '',
      easeOutQuart: '',
      easeInOutQuart: '',
      easeInQuint: '',
      easeOutQuint: '',
      easeInOutQuint: ''
    }),
    ////
    model: 3,
    rounded: [
      '0',
      'sm',
      'md',
      'lg',
      'xl',
      'pill',
      'circle',
    ],
    ////
    b : true,
    ////
    model1 : null,
    classes: [
      ['h1', 'Heading 1', '6rem', '300', '-.015625em', -1],
      ['h2', 'Heading 2', '3.75rem', '300', '-.0083333333em', 0],
      ['h3', 'Heading 3', '3rem', '400', 'normal', 1],
      ['h4', 'Heading 4', '2.125rem', '400', '.0073529412em', 2],
      ['h5', 'Heading 5', '1.5rem', '400', 'normal', 2],
      ['h6', 'Heading 6', '1.25rem', '500', '.0125em', 3],
      ['subtitle-1', 'Subtitle 1', '1rem', '400', '.009375em', 4],
      ['subtitle-2', 'Subtitle 2', '0.875rem', '500', '.0071428571em', 4],
      ['body-1', 'Body 1', '1rem', '400', '.03125em', 4],
      ['body-2', 'Body 2', '0.875rem', '400', '.0178571429em', 4],
      ['button', 'Button', '0.875rem', '500', '.0892857143em', 4],
      ['caption', 'Caption', '0.75rem', '400', '.0333333333em', 4],
      ['overline', 'Overline', '0.75rem', '500', '.1666666667em', 4],
    ],
    ////
    model2: 'caption',
    sizes: [
      ['mdi-devices', 'all', 'caption'],
      ['mdi-cellphone-iphone', 'sm', 'body-2'],
      ['mdi-laptop', 'md', 'body-1'],
      ['mdi-monitor', 'lg', 'h6'],
      ['mdi-television', 'xl', 'h4'],
    ],
    ////
    tasks: [
      {
        done: false,
        text: 'Foobar',
      },
      {
        done: false,
        text: 'Fizzbuzz',
      },
    ],
    newTask: null,
  }),
  methods : {
    onClick () {
      // Perform an action
    }
  },
  computed: {
    height () {
      switch (this.$vuetify.breakpoint.name) {
        case 'xs': return 220
        case 'sm': return 400
        case 'md': return 500
        case 'lg': return 600
        case 'xl': return 800
      }
    },
    breakpointname(){
      return this.$vuetify.breakpoint.name
    },
    target () {
      const value = this[this.type]
      if (!isNaN(value)) return Number(value)
      else return value
    },
    options () {
      return {
        duration: this.duration,
        offset: this.offset,
        easing: this.easing,
      }
    },
    element () {
      if (this.selected === 'Button') return this.$refs.button
      else if (this.selected === 'Radio group') return this.$refs.radio
      else return null
    },
    radius () {
      let rounded = 'rounded'
      const value = this.rounded[this.model]

      if (value !== 'md') {
        rounded += `-${value}`
      }

      return rounded
    },
    completedTasks () {
      return this.tasks.filter(task => task.done).length
    },
    progress () {
      return this.completedTasks / this.tasks.length * 100
    },
    remainingTasks () {
      return this.tasks.length - this.completedTasks
    },
  },
  created() {
    console.log(this.$vuetify.breakpoint.width)

    this.tasks.push({
      done: false,
      text: this.newTask,
    })

    this.newTask = null
  },

}
</script>
