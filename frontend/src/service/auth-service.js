import axios from 'axios';

const url = 'http://localhost:8089/';

export default {
  login(credentials) {
    return axios
      .post(url + 'login/', credentials)
      .then(response => response.data);
  },
  signUp(credentials) {
      console.log(credentials);
    return axios
      .post(url + 'register', credentials)
      .then(response => response.data);
  },
  getSecretContent() {
    return axios.get(url + 'secret-route/').then(response => response.data);
  }
};
