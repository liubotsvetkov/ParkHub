<template>
    <base-card>
      <div id="mapContainer"></div>
    </base-card>
</template>

<script>
import "leaflet/dist/leaflet.css";
import L from "leaflet";

const greenIcon = new L.Icon(
    {
        iconUrl: 'https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-green.png',
        iconAnchor: [12, 41],
        shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
        shadowSize: [39, 39],
        iconSize: [25, 41],
        popupAnchor: [1, -34]
    }
);
const redIcon = new L.Icon(
    {
        iconUrl: 'https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-red.png',
        iconAnchor: [12, 41],
        shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
        shadowSize: [39, 39],
        iconSize: [25, 41],
        popupAnchor: [1, -34]
    }
);

export default {
  data() {
    return {
      mapDiv: null,
      markers: null
    };
 },
 props: {
    data: Array,
    isUpdateMapTriggered: Boolean
 },
 methods: {
   setupLeafletMap: function () {
     this.mapDiv = L.map("mapContainer").setView([40, 20], 2);

     L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
         attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
     }).addTo(this.mapDiv);
   },
   populateLeafletMap: function () {

    let arrayOfLatLngs = [];

    this.markers = L.featureGroup();
    this.markers.clearLayers();

    for (let i = 0; i < this.data.length; i++) {

        arrayOfLatLngs.push(L.latLng(this.data[i].latitude, this.data[i].longitude));

        let marker = L.marker([this.data[i].latitude, this.data[i].longitude], { icon: this.data[i].state === 0 ? greenIcon : redIcon });

        this.markers.addLayer(marker);
    }

    this.mapDiv.addLayer(this.markers);

    var bounds = new L.LatLngBounds(arrayOfLatLngs);

    this.mapDiv.fitBounds(bounds);
    this.mapDiv.invalidateSize();
   },
 },
 watch: {
    isUpdateMapTriggered: function() {
        this.populateLeafletMap();
    }
 },
 mounted() {
   this.setupLeafletMap();
 }
};
</script>

<style scoped>
#mapContainer {
 max-width: 90rem;
 height: 40rem;
}
</style>