<template>
<v-app>
  <v-container fluid>
    <v-row>
      <v-container fluid>
          <v-row>
            <v-col
               class="d-flex"
               cols="12"
               sm="6"
             >
                <v-select
                  :items="['SOF', 'BRE']"
                  v-model="selectedCity"
                  label="City"
                  dense
                  solo
                >
                </v-select>
            </v-col>
            <v-col
                class="d-flex"
                cols="12"
                sm="6"
            >
               <v-select
                 :items="getZonesForCity"
                 v-model="selectedZone"
                 label="Parking Zone"
                 dense
                 solo
                >
                </v-select>
            </v-col>
          </v-row>
        </v-container fluid>
        <GmapMap
          ref="mapRef"
          :center="{ lat: 10, lng: 10 }"
          :zoom="7"
          map-type-id="terrain"
          style="width: 2000px; height: 700px"
        >
          <GmapMarker
            :key="index"
            v-for="(m, index) in markers"
            :position="m.position"
            :clickable="true"
            :draggable="true"
            :icon="markerColor(m.free)"
            @click="center = m.position"
          />
        </GmapMap>
     </v-row>
  </v-container fluid>
  </v-app>
</template>

<script>
export default {
  data() {
    return {
      selectedCity: "SOF",
      selectedZone: "",
      cities: [
        {
          name: 'SOF',
          zones: [
            "A1", "A2", "C1", "C2", "OR1", "OR2"
          ]
        },
        {
          name: 'BRE',
          zones: [
            "L1", "L2", "L3", "D1", "D2", "D3", "E1"
          ]
        }
      ],
      markers: [
        {
          position: {
            lat: 1.38,
            lng: 103.8
          },
          free: true,
        },
        {
          position: {
            lat: 53.168057,
            lng: 8.654234
          },
          free: true,
        },
        {
          position: {
            lat: 42.659372,
            lng: 23.314266
          },
          free: false,
        }
      ]
    };
  },
  methods: {
    markerColor(isFree) {
      if(isFree) {
        return 'http://maps.google.com/mapfiles/ms/icons/green-dot.png'
      } else {
        return 'http://maps.google.com/mapfiles/ms/icons/red-dot.png'
      }
    }
  },
  computed: {
    getZonesForCity: function() {
    this.cities.forEach(city => {
      if (city.name === this.selectedCity) {
        return city.zones
      }
    });
      return ""
    }
  },
  mounted() {
    this.$refs.mapRef.$mapPromise.then(map => {
      map.panTo({ lat: 1.38, lng: 103.8 });
    });
  }
};
</script>
