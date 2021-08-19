<template>
  <ul id="book-boxes" >
    <template
        v-for="(book, index) in $store.state.selectedCategoryBooks">
      <category-book-list-item
          :key="book.bookId"
          v-if="index <= 3"
          :book="book"></category-book-list-item>

    </template>
  </ul>
</template>

<script>
import CategoryBookListItem from "./CategoryBookListItem";


export default {
  name: "BookList",
  components: {
    CategoryBookListItem,
  }
};

</script>

<style> @import '../assets/css/category-book-list.css'; </style>

