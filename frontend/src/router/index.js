import Vue from "vue";
import Router from "vue-router";
import Register from "../pages/Register.vue";
import LogIn from "../pages/LogIn.vue";
import Home from '../pages/Home.vue';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "login",
      component: LogIn
    },
    {
      path: "/login",
      name: "login",
      component: LogIn
    },
    {
      path: "/register",
      name: "register",
      component: Register
    },
    {
      path: "/home",
      name: "home",
      component: Home
    },

  ]
});
