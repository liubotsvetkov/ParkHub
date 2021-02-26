// Test.vue
<template>
  <div>
    <v-container>
      <v-form v-on:submit.prevent="submitForm">
        <v-text-field v-model="form.name" label="Name"></v-text-field>
        <v-text-field v-model="form.age" label="Age"></v-text-field>
        <v-text-field v-model="form.height" label="Height"></v-text-field>
        <v-btn type="submit">Submit</v-btn>
      </v-form>
    </v-container>
    <v-container>
      <v-btn @click="viewAll()">View All</v-btn>
      <div>{{ message }}</div>
    </v-container>
  </div>
</template>

<script>
import axios from "axios";

export default {
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
