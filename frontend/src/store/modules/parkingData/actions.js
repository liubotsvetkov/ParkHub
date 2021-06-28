import axios from 'axios';

export default {
  async loadParkingData(context) {

    const response = await axios({
        method: "get",
        url: "http://localhost:8089/parkingData/viewAll",
        headers: {
          "Access-Control-Allow-Origin": true
        }
    });

    const parkingData = response.data;

    if (response.status != 200) {
      const error = new Error('Failed to fetch!');
      throw error;
    }

    context.commit('setParkingData', parkingData);
  }
};
