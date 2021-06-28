<template>
    <base-card>
      <div id="mapContainer"></div>
    </base-card>
</template>

<script>
import "leaflet/dist/leaflet.css";
import L from "leaflet";
import { mapGetters } from 'vuex';

const greenIcon = new L.Icon(
    {
        iconUrl: 'https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-green.png',
        iconAnchor: [12, 41],
        shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
        shadowSize: [43, 43],
        iconSize: [25, 41],
        popupAnchor: [1, -34]
    }
);
const redIcon = new L.Icon(
    {
        iconUrl: 'https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-red.png',
        iconAnchor: [12, 41],
        shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
        shadowSize: [43, 43],
        iconSize: [25, 41],
        popupAnchor: [1, -34]
    }
);

export default {
  data() {
    return {
      isLoading: false,
      error: null,
      mapDiv: null,
      polling: null
    };
 },
 computed: {
   ...mapGetters(["parkingData"])
 },
 methods: {
   setupLeafletMap: function () {
     this.mapDiv = L.map("mapContainer").setView([40, 20], 2);

     L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
         attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
     }).addTo(this.mapDiv);
   },
   populateLeafletMap: function () {
     for (var i = 0; i < this.parkingData.length; i++) {
       L.marker(
            [this.parkingData[i].latitude, this.parkingData[i].longitude],
            { icon: this.parkingData[i].state === 0 ? greenIcon : redIcon }
       ).addTo(this.mapDiv);
     }
   },
   async loadParkingData() {
    this.isLoading = true;

    try {
      await this.$store.dispatch('loadParkingData');
    } catch (error) {
      this.error = error.message || 'Something went wrong!';
    }
    this.isLoading = false;
  },
  async updateMap () {

    await this.loadParkingData();
    this.populateLeafletMap();

    this.polling = setInterval(async () => {
        await this.loadParkingData();
        this.populateLeafletMap();
    }, 5000)
  }
 },
 mounted() {
   this.setupLeafletMap();
   this.updateMap();
 },
 beforeUnmount () {
    clearInterval(this.polling)
 }
};
</script>

<style scoped>
#mapContainer {
 max-width: 80rem;
 height: 40rem;
}
</style>