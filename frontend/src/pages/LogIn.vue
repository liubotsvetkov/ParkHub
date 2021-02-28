<template>
  <v-container>
    <v-layout row class="text-xs-center">
      <v-flex xs4 class="grey lighten-4">
        <v-container
          style="position: relative;top: 8%; padding-right: 0px;"
          class="text-xs-center container"
        >
          <v-card flat class="form">
            <v-card-title primary-title>
              <h4>Login</h4>
            </v-card-title>
            <v-form>
              <v-text-field name="Username" label="Username"></v-text-field>
              <v-text-field
                name="Password"
                label="Password"
                type="password"
              ></v-text-field>
              <router-link to="/home">
                <v-btn primary large block>Log In</v-btn>
              </router-link>
              <router-link to="/register" class="pt-2">
                <v-btn primary large block>Sign Up</v-btn>
              </router-link>
            </v-form>
          </v-card>
        </v-container>
      </v-flex>
      <v-flex xs4 class="grey lighten-4">
        <v-container style="position: relative;top: 8%; padding-left: 0px;">
          <img
            height="395px"
            width="650px"
            src="../assets/smarter-parking.jpg"
          />
        </v-container>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<style>
.form {
  background-color: #a4ce7a !important;
  padding: 25px;
}
.v-btn {
  margin-top: 18px !important;
}
.container {
  margin-left: 32px;
  padding-bottom: 34px;
}
</style>
