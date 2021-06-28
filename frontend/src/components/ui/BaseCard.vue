<template>
  <div class="card">
    <slot></slot>
  </div>
</template>

<style scoped>
    .card {
      border-radius: 12px;
      box-shadow: 0 5px 11px rgba(0, 0, 0, 0.38);
      padding: 1rem;
      margin: 2rem auto;
      max-width: 80rem;
    }
</style>