<template>
  <div class="register">
    <router-view></router-view>
    <v-container>
      <v-layout row class="text-xs-center">
        <v-flex xs4 class="grey lighten-4">
          <v-container
            style="position: relative;top: 13%;"
            class="text-xs-center"
          >
            <v-card flat class="form">
              <v-card-title primary-title>
                <h4>Sign Up</h4>
              </v-card-title>
              <v-form>
                <v-text-field
                  v-model="form.username"
                  name="email"
                  label="Email"
                ></v-text-field>
                <v-text-field
                  v-model="form.password"
                  name="Password"
                  label="Password"
                  type="password"
                ></v-text-field>
                <router-link :to="route">
                  <v-btn class="button" primary large block @click="signUp()">Sign Up</v-btn>
                </router-link>
                <h5>{{ msg }}</h5>
              </v-form>
            </v-card>
          </v-container>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "register",
  data() {
    return {
      form: {
        username: null,
        password: null
      },
      route: "/register",
      msg: ""
    };
  },
  methods: {
    signUp() {
      if (!this.form.username || !this.form.password) {
        this.msg = "Please enter both username and password";
      } else {
        const credentials = {
          username: this.form.username,
          password: this.form.password
        };
        try {
          axios
            .post("http://localhost:8089/register", credentials)
            .then(response => {
              response.data;
            })
            .catch(error => {
              console.log(error);
              this.route = "/register";
              this.msg = "Couldn't Sign Up";
            });
          this.route = "/home";
        } catch (error) {
          this.route = "/register";
          this.msg = "Couldn't Sign Up";
        }
      }
    }
  }
};
</script>

<style>
.form {
  background-color: #a4ce7a !important;
  padding: 25px;
}
.button {
  margin-top: 18px !important;
  margin-bottom: 18px !important;
}
</style>
