<template>
  <div class="header-dropdown">
    <router-link to="/category/New releases" tag="a" class="dropdown-cat"
      >New releases</router-link
    >
    <router-link to="/category/Best sellers" tag="a" class="dropdown-cat"
      >Best sellers</router-link
    >
    <a class="category-hover dropdown-cat" href="#" @click="toggleCatMenu"
      >Categories</a
    >
    <div class="category-dropdown" :class="{ 'cat-menu-open': catMenuOpen }">
      <template v-for="category in $store.state.categories">
        <div
          :key="category.categoryId"
          v-if="$store.state.selectedCategoryName === category.name"
          class="category-box"
        >
          {{ category.name }}
        </div>
        <div :key="category.categoryId" v-else class="category-box">
          <router-link
            :to="{ name: 'category', params: { name: category.name } }"
          >
            {{ category.name }}
          </router-link>
        </div>
      </template>
    </div>
    <section class="account">
      <router-link to="/" class="dropdown-cat">
        <a href="#">Log in</a>
      </router-link>
    </section>
    <section class="search">
      <a href="#" class="magnify">
        <img src="@/assets/images/site/magnifying_icon.png" />
      </a>
      <form action="category.html" class="search-field">
        <input type="text" class="search-bar" />
        <input type="submit" class="button" value="Search" />
      </form>
    </section>
  </div>
</template>

<script>
export default {
  name: "Dropdown",
  data: function () {
    return {
      catMenuOpen: false,
    };
  },
  created: function () {
    this.$store.dispatch(
      "selectCategory",
      this.$store.state.selectedCategoryName
    );
  },
  watch: {
    $route() {
      this.catMenuOpen = false;
    },
  },
  methods: {
    toggleCatMenu() {
      this.catMenuOpen = !this.catMenuOpen;
    },
  },
};
</script>

<style>
@import "../assets/css/header-dropdown.css";
@import "../assets/css/mobile.css";
</style>
