<template>
  <div id="confirmation">
    <section v-if="!$store.state.orderDetail" id="confirmation-invalid">
      <router-link
        :to="{
          name: 'category',
          params: { categoryName: this.categoryName },
        }"
      >
        <button class="normal-2x-button">Continue Shopping</button>
      </router-link>
    </section>
    <template>
      <div class="confirmation-page">
        <span class="check-icon">
          <i class="fas fa-check"></i>

          Thank you for your purchase!
        </span>
        <div id="confirmationView" class="conf-view">
          <ul>
            <li>
              Your confirmation number is
              <strong>{{
                $store.state.orderDetail.order.confirmationNumber
              }}</strong>
            </li>
            <li>{{ new Date($store.state.orderDetail.order.dateCreated) }}</li>
          </ul>
          <confirmation-table> </confirmation-table>
          <ul class="costs">
            <li>Surcharge: <Price :amount="$store.state.cart.surcharge" /></li>
            <li>
              Total:
              <strong>
                <Price :amount="$store.state.orderDetail.order.amount" />
              </strong>
            </li>
          </ul>
          <ul>
            <li>{{ $store.state.orderDetail.customer.customerName }}</li>
            <li>{{ $store.state.orderDetail.customer.address }}</li>
            <li>{{ $store.state.orderDetail.customer.email }}</li>
            <li>{{ $store.state.orderDetail.customer.getPhoneForDisplay }}</li>
            <li>{{ $store.state.orderDetail.customer.ccNumberForDisplay }}</li>
          </ul>
          <div id="customerInfo"></div>
        </div>
      </div>
    </template>
  </div>
</template>
<script>
import ConfirmationTable from "@/components/ConfirmationTable";
import Price from "@/components/Price.vue";

export default {
  name: "Confirmation",
  components: {
    ConfirmationTable,
    Price,
  },
  mounted() {
    this.$store.dispatch("clearCart");
  },
};
</script>

<style scoped>
confirmation-table {
  width: 100%;
}
.confirmation-page {
  min-height: 410px;
  text-align: center;
  margin-top: 2em;
}
.confirmation-page i {
  margin-right: 0.3em;
  font-size: larger;
  color: mediumseagreen;
}
.confirmation-page .check-icon {
  font-size: large;
  font-weight: bold;
}
.confirmation-page div {
  margin: 3em 2em;
}
.confirmation page ul {
  margin-top: 1.5em;
}
.conf-view {
  padding: 2em;
  border: 2px solid lavender;
  text-align: left;
}
ul.costs {
  text-align: right;
  line-height: 2em;
}
</style>
