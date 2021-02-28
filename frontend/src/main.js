import Vue from "vue";
import vuetify from "./plugins/vuetify";
import App from "./App.vue";
import router from "./router/index.js";
import store from "./service/vuex-store.js";
import Axios from "axios";
import * as VueGoogleMaps from "vue2-google-maps";

Axios.defaults.headers.common["Authorization"] = `Bearer ${store.state.token}`;

Vue.use(VueGoogleMaps, {
  load: {
    key: "AIzaSyBKESw8ifV6zuWbIUOxYlllJ82--YFdmtE",
    libraries: "places"
  }
});

new Vue({
  el: "#app",
  router,
  vuetify,
  store,
  render: h => h(App)
});
