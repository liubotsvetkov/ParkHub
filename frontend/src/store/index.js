import { createStore } from 'vuex';

import parkingDataModule from './modules/parkingData/index.js';

const store = createStore({
  modules: {
    parkingData: parkingDataModule,
  },
  state() {
    return {
      token: ''
    };
  },
  getters: {
    token(state) {
      return state.token;
    }
  }
});

export default store;