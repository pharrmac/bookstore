<!--//  v-if="$route.params.name === category.name" -->
<template>
  <div>
    <nav class="categoryNav">
      <div class="category-nav-image-items">
        <template
          v-for="(category, index) in $store.state.categories"
          :class="{ active: index == active }"
          @click="active = index"
        >
          <div
            :key="category.categoryId"
            v-if="index <= 9"
            class="category-box"
          >
            <router-link
              :to="{ name: 'category', params: { name: category.name } }"
            >
              {{ category.name }}
            </router-link>
          </div>
        </template>
      </div>
    </nav>
    <div class="header-wrapper">
      <h1>{{ $store.state.selectedCategoryName }}</h1>
    </div>
  </div>
</template>

<script>
export default {
  name: "Nav",
  data: function () {
    return {
      active: 1,
    };
  },
};
</script>

<style>
@import "../assets/css/sub-category.css";
</style>
