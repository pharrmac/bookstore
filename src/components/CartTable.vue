<template>
  <div>
    <table class="cart-table mobile">
      <tbody>
        <tr v-for="item in $store.state.cart.items" :key="item.book.bookId">
          <td>
            <img
              :src="
                require('@/assets/images/books/' +
                  bookImageFileName(item.book.title))
              "
              :alt="item.book.title"
              class="cart-img"
            />
          </td>
          <td>{{ item.book.title }}</td>
          <td class="price-col"><Price :amount="item.book.price" /></td>
          <td>
            <span v-if="item.quantity > 1">quantity: {{ item.quantity }}</span>
          </td>
          <td class="add-sub mobile">
            <a href="#" @click="updateCart(item.book, item.quantity + 1)">
              <i class="fas fa-plus-circle"></i>
            </a>
            <a
              href="#"
              @click="updateCart(item.book, item.quantity - 1)"
              class="minus-btn"
            >
              <i class="fas fa-minus-circle"></i>
            </a>
          </td>
        </tr>
        <tr>
          <td colspan="3" class="subtotal-td">
            <p class="subtotal">
              Subtotal: <Price :amount="$store.state.cart.subtotal" />
            </p>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import Price from "@/components/Price";

export default {
  name: "CartTable",
  components: {
    Price,
  },
  methods: {
    bookImageFileName: function (book) {
      console.log("book (bookImageFileName in cart): " + book);
      let name = book.toLowerCase();
      name = name.replace(/:/g, "");
      name = name.replace(/ /g, "-");
      console.log("book image file name: " + name);
      return `${name}.gif`;
    },
    updateCart: function (book, quantity) {
      this.$store.dispatch("updateCart", { book, quantity });
    },
  },
};
</script>

<style scoped>
table {
  width: 66%;
  border-spacing: 18px;
  border-collapse: separate;
  margin: 5em 8em;
}
p.subtotal {
  text-align: right;
  font-size: large;
}
.minus-btn {
  margin-left: 1em;
}
.price-col {
  text-align: right;
}
.subtotal-td {
  text-align: right;
  border-top: 2px solid #d4d9e3;
}
.add-sub {
  width: 50px;
  min-width: 30px;
}
table.cart-table .cart-img {
  min-width: 30px;
  max-width: 75px;
}
</style>
