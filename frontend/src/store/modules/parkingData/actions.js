import axios from 'axios';
import { BACKEND_URL } from '../../../utils/Constants.js';

export default {

  async loadParkingSlots(context) {

    const response = await axios({
        method: "get",
        url: BACKEND_URL + '/parkingSlots',
        headers: {
          "Access-Control-Allow-Origin": true
        }
    });

    const parkingSlots = response.data;

    if (response.status != 200) {
      const error = new Error('Failed to fetch!');
      throw error;
    }

    context.commit('setParkingSlots', parkingSlots);
  }

};
