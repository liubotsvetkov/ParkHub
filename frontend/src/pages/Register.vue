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
                <router-link to="/home">
                  <v-btn primary large block @click="signUp()">Sign Up</v-btn>
                </router-link>
              </v-form>
            </v-card>
          </v-container>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
import AuthService from "../service/auth-service.js";

export default {
  name: "register",
  data() {
    return {
      form: {
        username: "",
        password: ""
      },
      msg: ""
    };
  },
  methods: {
    signUp() {
      try {
        const credentials = {
          username: this.form.username,
          password: this.form.password
        };
        const response = AuthService.signUp(credentials);
        this.msg = response.msg;
      } catch (error) {
        this.msg = error.response.data.msg;
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
.v-btn {
  margin-top: 18px !important;
}
</style>
