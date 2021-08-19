<template>
  <div class="book-wrapper">
    <category-nav :books="$store.state.selectedCategoryBooks"></category-nav>
    <category-book-list></category-book-list>
  </div>
</template>

<script>
import CategoryNav from "@/components/CategoryNav";
import CategoryBookList from "@/components/CategoryBookList";

export default {
  name: "category",
  components: {
    "category-nav": CategoryNav,
    "category-book-list": CategoryBookList,
  },
  created: function () {
    const self = this;
    this.$store.dispatch("selectCategory", this.$route.params.name);
    this.$store.dispatch("fetchSelectedCategoryBooks")
    .catch(function() {
      console.log("Category.vue catch - 404 ");
      self.$router.push('/404')
    });
  },
};
</script>
