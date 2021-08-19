<template>
  <section class="category">
    <div class="category-image-items">
      <template v-for="(category, index) in $store.state.categories">
        <div :key="category.categoryId" v-if="index <= 9" class="category-box">
          <router-link
            :to="{ name: 'category', params: { name: category.name } }"
          >
            {{ category.name }}
          </router-link>
        </div>
      </template>
    </div>
  </section>
</template>

<script>
export default {
  name: "CategoryNav",
  created: function () {
    this.$store.dispatch(
      "selectCategory",
      this.$store.state.selectedCategoryName
    );
  },
};
</script>

<style>
@import "../assets/css/home-category.css";
</style>
