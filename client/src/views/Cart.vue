<template>
  <div class="cart-page mobile">
    <p class="items">Your shopping cart contains {{ $store.state.cart.numberOfItems }} item<span v-if="$store.state.cart.numberOfItems == 0 || $store.state.cart.numberOfItems > 1">s</span>.
     <a href="#" @click="clearCart" >Clear cart</a>
    </p>

    <section class="button-group mobile">
      <button class="button shopping" @click="continueShopping" >Continue shopping</button>
      <button v-if="$store.state.cart.numberOfItems != 0" class="button checkout mobile" @click="proceedToCheckout" >Proceed to checkout</button>
    </section>

    <cart-table v-if="$store.state.cart.numberOfItems != 0"></cart-table>
    <p class="empty-msg" v-else>Your cart is empty, continue shopping to fill it up.</p>
  </div>
</template>

<script>
import CartTable from "@/components/CartTable";

export default {
  name: "Cart",
  components: { CartTable },
  methods: {
    continueShopping() {
      console.log("Value of categoryName is:" +this.$store.getters.categoryName);
      this.$router.push({name: "category", params: {name: this.$store.getters.categoryName }});
    },
    proceedToCheckout() {
      this.$router.push( { name: "checkout" } );
    },
    clearCart: function (){
      this.$store.dispatch("clearCart" );
    }
  }
};
</script>


<style scoped>
.cart-page {
  margin: 1.5em 2.1em;
}
p.items {
  border-top: 3px solid #d4d9e3;
  font-size: small;
  margin-bottom: 2em;
}
p.items a {
  color: #4d5f7d;
  margin-left: 1em;
  text-decoration: underline;
}
table {
  margin: 3em
}
th {
  text-align: left;
}
.empty-msg {
  height: 328px;
  font-size: xx-large;
  text-align: center;
  margin: 3em 0;
}
button.checkout {
  font-size: larger;
  background: none;
  border: 3px solid #b4caef;
  position: relative;
  margin-left: 1em;
}
button.shopping {
  font-size: larger;
  background: none;
  border: 1px solid #b4caef;
  position: relative;
}
section {
  float: right;
  top: -13px;
  position: relative;
}
</style>