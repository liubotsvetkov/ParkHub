// Test.vue
<template>
  <div id="app" class="main-container">
    <div>
      <v-toolbar dark prominent src="./src/assets/cars-parked.jpg">
        <v-app-bar-nav-icon></v-app-bar-nav-icon>
        <v-toolbar-title><h3>ParkHub: Park decisively</h3></v-toolbar-title>
        <v-spacer></v-spacer>
      </v-toolbar>
    </div>
    <v-container>
      <router-view></router-view>
    </v-container>
    <v-footer padless>
      <v-card class="flex app-footer" flat tile>
        <v-card-title>
          <strong><h5>Get connected with us on social networks!</h5></strong>
          <v-spacer></v-spacer>
        </v-card-title>

        <v-card-text>
          {{ new Date().getFullYear() }} — <strong>ParkHub</strong>
        </v-card-text>
      </v-card>
    </v-footer>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "App",
  data: function() {
    return {
      message: "",
      form: {
        name: "",
        age: "",
        height: ""
      }
    };
  },
  methods: {
    viewAll: function() {
      console.log("authdata is: " + JSON.stringify(process.env));
      axios({
        method: "get",
        url: "http://localhost:8089/viewAll",
        headers: {
          "Access-Control-Allow-Origin": true,
          Authorization: "Basic YWRtaW46cGFzc3dvcmQ="
        }
      })
        .then(response => (this.message = response.data))
        .catch(err => console.log(err));
    },
    submitForm() {
      axios({
        method: "post",
        url: "http://localhost:8089/create",
        data: this.form,
        headers: {
          "Access-Control-Allow-Origin": true,
          Authorization: "Basic YWRtaW46cGFzc3dvcmQ="
        }
      })
        .then(res => {
          this.form.name = "";
          this.form.age = "";
          this.form.height = "";
          console.log(res);
        })
        .catch(error => {
          this.form.name = "";
          this.form.age = "";
          this.form.height = "";
          console.log(error);
        });
    }
  }
};
</script>

<style>
.main-container {
  background-color: #ccddff !important;
}
.app-footer {
  background-color: #97b6f7 !important;
}
h3 {
  font-family: "Ubuntu";
}
</style>
