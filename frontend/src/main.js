import Vue from 'vue';
import vuetify from './plugins/vuetify';
import App from './App.vue';
import router from './router/index.js';
import store from './service/vuex-store.js';
import Axios from 'axios';

Axios.defaults.headers.common['Authorization'] = `Bearer ${store.state.token}`;


new Vue({
  el: '#app',
  router,
  vuetify,
  store,
  render: h => h(App)
})
