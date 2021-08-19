<template>
  <table>
    <tr
      v-for="(item, index) in this.$store.state.orderDetail.lineItems"
      :key="item.productId"
    >
      <td>
        {{ $store.state.orderDetail.books[index].title }}
      </td>
      <td>{{ item.quantity }}</td>
      <td>
        <Price
          :amount="$store.state.orderDetail.books[index].price * item.quantity"
        />
      </td>
    </tr>
  </table>
</template>

<script>
import Price from "@/components/Price.vue";

export default {
  name: "ConfirmationTable",
  components: {
    Price,
  },
};
</script>

<style scoped>
table {
  margin-top: 3em;
  margin-bottom: 1em;
  border-collapse: collapse;
  width: 100%;
}
table tr {
  border-bottom: 2px solid lavender;
}
td {
  display: table-cell;
  padding: 0.5em 0.5em;
  background-color: white;
  vertical-align: middle;
}

td:nth-child(1) {
  text-align: left;
}

td:nth-child(2) {
  text-align: center;
}

td:nth-child(3) {
  text-align: right;
}
</style>
