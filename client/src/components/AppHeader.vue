<template>
  <header class="container" :class="{ mobile: mainMenuOpen }">
    <section class="bookstore-logo">
      <router-link to="/">
        <img
          class="logo responsive"
          alt="Lost in a Book"
          srcset="
            @/assets/images/site/bookstore-logo.png       248w,
            @/assets/images/site/bookstore-logo-small.png 150w
          "
          src="@/assets/images/site/bookstore-logo.png"
        />
      </router-link>
    </section>
    <section class="cart-section">
      <router-link to="/cart">
        <a href="" class="cart">
          <span class="cart-number">{{ $store.state.cart.numberOfItems }}</span>
          <svg viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
            <circle cx="50" cy="50" r="50" />
          </svg>
        </a>
      </router-link>
    </section>
    <a href="#" class="hamburger" @click="toggleMainMenu">
      <i class="fas fa-bars" alt="menu navigation icon"></i>
    </a>
    <section class="categories">
      <section
        class="mobile-dropdown"
        id="myLinks"
        :class="{ 'main-menu-open': mainMenuOpen }"
      >
        <header-dropdown-menu></header-dropdown-menu>
      </section>
    </section>
  </header>
</template>

<script>
import HeaderDropdownMenu from "@/components/HeaderDropdown";
export default {
  name: "Header",
  components: {
    "header-dropdown-menu": HeaderDropdownMenu,
  },
  data: function () {
    return {
      mainMenuOpen: false,
    };
  },
  methods: {
    toggleMainMenu() {
      this.mainMenuOpen = !this.mainMenuOpen;
    },
  },
};
</script>

<style>
@import "../assets/css/app-header.css";
@import "../assets/css/mobile.css";
</style>
