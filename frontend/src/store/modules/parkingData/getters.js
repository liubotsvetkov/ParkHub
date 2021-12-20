export default {
  parkingSlots(state) {
    return state.parkingSlots;
  },
  hasParkingSlots(state) {
    return state.parkingSlots && state.parkingSlots.length > 0;
  }
};