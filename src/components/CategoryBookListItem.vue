<template>
  <li class="book-holder">
    <div class="book-image">
      <img
        :src="require('@/assets/images/books/' + bookImageFileName(book.title))"
        :alt="book.title"
      />
    </div>
    <div class="book-box">
      <div class="book-title">{{ book.title }}</div>
      <div class="book-author">{{ book.author }}</div>
      <div class="book-price">
        Hardcover: ${{ book.price | currency }}
      </div>
      <div class="button-holder">

          <button class="button" @click="$store.dispatch('addToCart', book)">
            Add to cart
          </button>
        <button v-if="book.isFeatured" class="button read-now-btn">
          Read me
        </button>
      </div>
    </div>
  </li>
</template>

<script>
export default {
  name: "BookListItem",
  props: {
    book: {
      type: Object,
      required: true,
    },
  },
  filters: {
    currency(val) {
      return (val /100).toFixed(2);
    },
  },
  methods: {
    bookImageFileName: function (book) {
      console.log("book: " + book);
      let name = book.toLowerCase();
      name = name.replace(/:/g, "");
      name = name.replace(/ /g, "-");
      return `${name}.gif`;
    },
  },
};
</script>

<style scoped>

.check-icon circle {
  fill: #4e70a6;
}
.flex-inner li {
  width: 100px;
}
</style>