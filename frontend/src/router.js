import { createRouter, createWebHistory } from 'vue-router';

import TheOverview from './pages/TheOverview.vue';
import MyProfile from './pages/MyProfile.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', redirect: '/overview' },
    { path: '/overview', component: TheOverview },
    { path: '/myprofile', component: MyProfile }
  ]
});

export default router;
