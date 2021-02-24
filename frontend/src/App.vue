// Test.vue
<template>
  <div>
    <div>
      <form v-on:submit.prevent="submitForm">
        <div class="form-group">
          <label for="name">Name</label>
          <input type="text" class="form-control" id="name" placeholder="Your name" v-model="form.name">
        </div>
        <div class="form-group">
          <label for="age">Age</label>
          <input type="number" class="form-control" id="age" placeholder="20"
                  v-model="form.age">
        </div>
        <div class="form-group">
          <label for="age">Height</label>
          <input type="number" class="form-control" id="height" placeholder="180"
                  v-model="form.height">
        </div>
        <div class="form-group">
          <button class="btn btn-primary">Submit</button>
        </div>
      </form>
    </div>
    <div>
      <button v-on:click="viewAll()">View All</button>
      <div>
        {{ message }}
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data: function() {
    return {
      message: '',
      form: {
        name: '',
        age: '',
        height: ''
      }
    }
  },
  methods: {
    viewAll: function() {
      console.log("authdata is: " + JSON.stringify(process.env))
      axios({
        method: 'get',
        url: 'http://localhost:8089/viewAll',
        headers: {
          'Access-Control-Allow-Origin': true,
          'Authorization': 'Basic YWRtaW46cGFzc3dvcmQ='
        }
      })
      .then(response => this.message = response.data)
      .catch(err => console.log(err))
    },
    submitForm(){
      axios({
        method: 'post',
        url: 'http://localhost:8089/create',
        data: this.form,
        headers: {
          'Access-Control-Allow-Origin': true,
          'Authorization': 'Basic YWRtaW46cGFzc3dvcmQ='
        }
      })
      .then((res) => {
        this.form.name = ''
        this.form.age = ''
        this.form.height = ''
        console.log(res)
      })
      .catch((error) => {
        this.form.name = ''
        this.form.age = ''
        this.form.height = ''
        console.log(error)
      })
    }
  }
};
</script>
