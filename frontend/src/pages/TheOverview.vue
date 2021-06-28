<template>
<div>
  <section>
    <base-card></base-card>
  </section>
  <section>
    <the-map>
    </the-map>
  </section>
</div>
</template>

<script>
import TheMap from '../components/ui/TheMap.vue';

export default {
  components: {
    TheMap
  }
};
</script>
