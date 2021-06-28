export default {
  parkingData(state) {
    return state.parkingData;
  },
  hasParkingData(state) {
    return state.parkingData && state.parkingData.length > 0;
  }
};