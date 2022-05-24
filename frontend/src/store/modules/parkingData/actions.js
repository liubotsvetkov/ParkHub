import axios from 'axios';
import { BACKEND_PREFIX } from '../../../utils/Constants.js';

export default {

  async loadParkingSlots(context) {

    const response = await axios({
        method: "get",
        url: BACKEND_PREFIX + '/parkingSlots',
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
