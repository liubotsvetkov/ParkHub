<template>
<div>
  <section>
    <base-card>
        <div class="filter-item">
            <label for="city-select">City</label>
            <custom-select id="city-select" v-model="selectedCity" :options="cityNames" required></custom-select>
        </div>
        <div class="filter-item">
            <label for="neighborhood-select">Neighborhood</label>
            <custom-select id="neighborhood-select" v-model="selectedNeighborhood" :options="neighborhoodNames" :disabled="neighborhoodsDisabled" required></custom-select>
        </div>
    </base-card>
  </section>
  <section>
    <the-map :data="parkingSlots" :isUpdateMapTriggered="updateMapTrigger" :isFitBoundsTriggered="fitBounds">
    </the-map>
  </section>
</div>
</template>

<script>
import TheMap from '../components/ui/TheMap.vue';
import CustomSelect from '../components/ui/CustomSelect.vue';
import axios from 'axios';
import { BACKEND_URL } from '../utils/Constants.js';

export default {
  components: {
    TheMap,
    CustomSelect
  },
  data() {
    return {
        selectedCity: "",
        selectedNeighborhood: "",
        cities: [],
        neighborhoods: [],
        parkingSlots: [],
        neighborhoodsDisabled: true,
        updateMapTrigger: false,
        fitBounds: false
    }
  },
  computed: {
    cityNames: function() {
        return this.cities.map(el => el.name);
    },
    neighborhoodNames: function() {
        return this.neighborhoods.map(el => el.name);
    },
    selectedCityId: function() {
        let city = this.cities.find(el => el.name === this.selectedCity);
        if (city == null) {
            return -1;
        }
        else {
            return city.id;
        }
    },
    selectedNeighborhoodId: function() {
        let neighborhood = this.neighborhoods.find(el => el.name === this.selectedNeighborhood);
        if (neighborhood == null) {
            return -1;
        }
        else {
            return neighborhood.id;
        }
    }
  },
  methods: {
    makeHttpRequest: async function(method, url) {
        const response = await axios({
            method: method,
            url: url,
            headers: {
                "Access-Control-Allow-Origin": true
            }
        });

        if (response.status != 200) {
            const error = new Error('Failed http request!');
            throw error;
        }

        return response;
    },
    loadCities: async function() {
    console.log("process env " + BACKEND_URL);

        const response = await this.makeHttpRequest("get", `${BACKEND_URL}/cities`);

        this.cities = response.data;
        const defaultChoice = {id: -1, name: ""};
        this.cities.unshift(defaultChoice);
    },
    loadNeighborhoodsByCity: async function() {

        const response = await this.makeHttpRequest("get", `${BACKEND_URL}/neighborhoods/byCity/${this.selectedCityId}`);

        this.neighborhoods = response.data;
        const defaultChoice = {id: -1, name: ""};
        this.neighborhoods.unshift(defaultChoice);
    },
    loadParkingSlots: async function(fitBounds) {

        let response = null;

        if (this.selectedNeighborhoodId != -1) {
            response = await this.makeHttpRequest("get", `${BACKEND_URL}/parkingSlots/byNeighborhood/${this.selectedNeighborhoodId}`);
        }
        else if (this.selectedCityId != -1) {
            response = await this.makeHttpRequest("get", `${BACKEND_URL}/parkingSlots/byCity/${this.selectedCityId}`);
        }
        else {
            response = await this.makeHttpRequest("get", `${BACKEND_URL}/parkingSlots`);
        }

        this.parkingSlots = response.data;
        this.updateMapTrigger = !this.updateMapTrigger;
        this.fitBounds = fitBounds;
    },
    updateLoopParkingSlots: function() {
        this.polling = setInterval(async () => {
            this.loadParkingSlots(false);
        }, 5000)
    }
  },
  watch: {
    selectedCity: function(newSelectedCity) {

        if (newSelectedCity === "") {
            this.neighborhoodsDisabled = true;
            this.neighborhoods = [];
        }
        else {
            this.neighborhoodsDisabled = false;
            this.loadNeighborhoodsByCity();
        }

        this.selectedNeighborhood = "";
        this.loadParkingSlots(true);
    },
    selectedNeighborhood: function() {
        this.loadParkingSlots(true);
    }
  },
  mounted() {
    this.loadCities();
    this.loadParkingSlots(true);
    this.updateLoopParkingSlots();
  },
};
</script>

<style>
    .filter-item {
        display: inline-block;
        margin-right: 5rem;
        margin-left: 5rem;
    }
    label {
        color: #909090;
        font-weight: bold;
    }
</style>