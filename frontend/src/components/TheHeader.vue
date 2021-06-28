<template>
  <header>
   <nav>
      <div id="logo">
        <router-link to="/"><img src="../assets/logo.svg"/></router-link>
      </div>
      <ul>
        <li>
          <router-link to="/overview">Overview</router-link>
        </li>
        <li>
          <router-link to="/myprofile">My Profile</router-link>
        </li>
      </ul>
   </nav>
  </header>
</template>

<style scoped>

img {
  max-height: 7rem;
  max-width: 11rem;
  filter: brightness(140%);
}

header {
  margin-top: 0%;
  width: 100%;
  height: 6rem;
  background-color: #FDDB27FF;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 8px;
}

header a {
  text-decoration: none;
  color: #5CC8D7FF;
  font-weight: 500;
  display: inline-block;
  padding: 0.75rem 1.5rem;
  border: 1.5px solid transparent;
}

a:active,
a:hover,
a.router-link-active {
  border: 1.5px solid #5CC8D7FF;
  border-radius: 20px;
}

div #logo a:hover,
div #logo a:active,
div #logo a.router-link-active {
  border-color: transparent;
}

header nav {
  width: 90%;
  margin: 1px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

header ul {
  list-style: none;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: center;
  align-items: center;
}

li {
  margin: 0 0.5rem;
}
</style>