<template>
  <div id="app">
    <h1>
      <img src="./assets/logo.svg" alt="Enroller" class="logo">
      System do zapisów na zajęcia
    </h1>

    <div v-if="authenticatedUsername">
      <h2>Witaj {{ authenticatedUsername }}!
        <a @click="logout()" class="float-right  button-outline button">Wyloguj</a>
      </h2>
      <meetings-page :username="authenticatedUsername"></meetings-page>
    </div>
    <div v-else>
      <button :class="isRegistering ? 'button-outline' : ''" @click="isRegistering=false" >Logowanie</button> 
      <button :class="!isRegistering ? 'button-outline' : ''" @click="isRegistering=true">Rejestracja</button>

    <!--    <login-form @login="isRegistering ? register($event) : login($event)" 
            :button-label="isRegistering ? 'Zarejestruj sie' : 'Zaloguj sie'"
            v-if="!isRegistering"></login-form> -->

    <login-form @login="login($event)" 
            v-if="!isRegistering"></login-form>
    <login-form @login="register($event)" 
            :button-label="'Zarejestruj sie'"
            v-else></login-form>  <!-- ten sam komponent ale rodzic reaguje na niego inaczej-->
    </div>
  </div>
</template>

<script>
import "milligram";
import LoginForm from "./LoginForm";
import MeetingsPage from "./meetings/MeetingsPage";

export default {
  components: { LoginForm, MeetingsPage },
  data() {
    return {
      authenticatedUsername: "",
      isRegistering: false
    };
  },
  methods: {
    login(user) {
      this.authenticatedUsername = user.login;
    },
  register(user) {
    //alert.user.login
    this.$http.post('participants', user) //biblioteka dodana wykorzystuje ioc kontener uruchamia usluge $http
    .then(response => {
         // udało się
     })
     .catch(response => {});
    },
    logout() {
      this.authenticatedUsername = "";
    }
  }
};
</script>

<style>
#app {
  max-width: 1000px;
  margin: 0 auto;
}

.logo {
  vertical-align: middle;
}
</style>

