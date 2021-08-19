<template>
  <div class="checkout-page">
    <section class="checkout-page-body" v-if="!cart.empty">
      <form @submit.prevent="submitOrder" class="checkout">
        <ul class="flex-outer">
          <li>
            <label for="name">Name:</label>
            <div class="input-validation">
              <input
                type="text"
                id="name"
                name="name"
                v-model.lazy="$v.name.$model"
                placeholder="Enter your full name."
              />
              <template v-if="$v.name.$error">
                <span class="error" v-if="!$v.name.required"
                  >Name is required.</span
                >
                <span class="error" v-else-if="!$v.name.minLength">
                  Name must have at least
                  {{ $v.name.$params.minLength.min }} letters.
                </span>
                <span class="error" v-else-if="!$v.name.maxLength">
                  Name can have at most
                  {{ $v.name.$params.maxLength.max }} letters.
                </span>
                <span class="error" v-else>
                  An unexpected error occurred.
                </span>
              </template>
            </div>
          </li>
          <li>
            <label for="address">Address:</label>
            <div class="input-validation">
              <input
                type="text"
                id="address"
                name="address"
                v-model.lazy="$v.address.$model"
                placeholder="Enter your address."
              />

              <template v-if="$v.address.$error">
                <span class="error" v-if="!$v.address.required"
                  >Address is required.</span
                >
                <span class="error" v-else>
                  An unexpected error occurred.
                </span>
              </template>
            </div>
          </li>
          <li>
            <label for="phone">Phone:</label>
            <div class="input-validation">
              <input
                class="textField"
                type="text"
                id="phone"
                name="phone"
                v-model.lazy="$v.phone.$model"
                placeholder="Enter your phone number."
              />
              <template v-if="$v.phone.$error">
                <span class="error" v-if="!$v.phone.required"
                  >Phone is required.</span
                >
                <span class="error" v-else-if="!$v.phone.minLength">
                  Phone number must have at least
                  {{ $v.phone.$params.minLength.min }} digits.
                </span>
                <span class="error" v-else-if="!$v.phone.maxLength">
                  Phone number can have at most
                  {{ $v.phone.$params.maxLength.max }} digits.
                </span>
                <span class="error" v-else>
                  An unexpected error occurred.
                </span>
              </template>
            </div>
          </li>
          <li>
            <label for="email">Email:</label>
            <div class="input-validation">
              <input
                type="text"
                id="email"
                name="email"
                v-model.lazy="$v.email.$model"
                placeholder="Enter your email."
              />

              <template v-if="$v.email.$error">
                <span class="error" v-if="!$v.email.required"
                  >Email is required.</span
                >
                <span class="error" v-if="!$v.email.email"
                  >Your email is not the correct format.</span
                >
                <span class="error" v-else>
                  An unexpected error occurred.
                </span>
              </template>
            </div>
          </li>
          <li>
            <label for="ccNumber">Credit card:</label>
            <div class="input-validation">
              <input
                type="text"
                id="ccNumber"
                name="ccNumber"
                v-model.lazy="$v.ccNumber.$model"
                placeholder="xxxx xxxx xxxx xxxx"
              />

              <template v-if="$v.ccNumber.$error">
                <span class="error" v-if="!$v.ccNumber.required"
                  >Credit card number is required.</span
                >
                <span class="error" v-else-if="!$v.ccNumber.creditCard">
                  You've entered an invalid credit card number.
                </span>
                <span class="error" v-else>
                  An unexpected error occurred.
                </span>
              </template>
            </div>
          </li>
          <li>
            <label for="ccExpiryMonth">Expiration month/year:</label>
            <div class="exp-yearmonth">
              <select
                v-model="ccExpiryMonth"
                id="ccExpiryMonth"
                class="small-input"
              >
                <option
                  v-for="(month, index) in months"
                  :key="index"
                  :value="index + 1"
                  selected
                >
                  {{ month }} ({{ index + 1 }})
                </option>
              </select>
              <template v-if="$v.ccExpiryMonth.$error">
                <span class="error" v-if="!$v.ccExpiryMonth.required"
                  >Month is required.</span
                >
                <span class="error" v-else>
                  An unexpected error occurred.
                </span>
              </template>
              <select v-model="ccExpiryYear" class="small-input">
                <option
                  v-for="index in 15"
                  :value="ccExpiryYear"
                  :key="index + 1"
                >
                  {{ yearFrom(index) }}
                </option>
              </select>

              <template v-if="$v.ccExpiryYear.$error">
                <span class="error" v-if="!$v.ccExpiryYear.required"
                  >Year is required.</span
                >
                <span class="error" v-else>
                  An unexpected error occurred.
                </span>
              </template>
            </div>
          </li>
          <li>
            <label></label>
            <section
              v-show="checkoutStatus != ''"
              class="checkout-status exp-yearmonth"
            >
              <div v-if="checkoutStatus == 'ERROR'">
                Please fix the problems above and try again.
              </div>

              <div v-else-if="checkoutStatus == 'PENDING'">Processing...</div>

              <div v-else-if="checkoutStatus == 'OK'">Order placed...</div>

              <div v-else>
                <!-- "checkoutStatus == 'SERVER_ERROR'" -->
                An unexpected error occurred, please try again.
              </div>
            </section>
          </li>
        </ul>
        <div class="bottom-wrapper mobile">
          <section class="checkout-details">
            Your credit card will be charged&nbsp;
            <strong> <Price :amount="$store.state.cart.total" />. </strong>
            <p>
              <Price :amount="$store.state.cart.subtotal" /> +
              <Price :amount="cart.surcharge" /> shipping.
            </p>
          </section>
          <div class="button-wrapper">
            <input
              type="submit"
              name="submit"
              class="button"
              :disabled="checkoutStatus == 'PENDING'"
              value="Complete Purchase"
            />
          </div>
        </div>
      </form>

      <!--    <div
          class="tree-view"
        style="
          border: 1px solid black;
          padding: 1em;
          margin-left: 1em;
          text-align: left;
        "
      >
        <tree-view
          :data="$v"
          :options="{ rootObjectKey: '$v', maxDepth: 1 }"
        ></tree-view>
      </div>
-->
    </section>
    <p class="empty-msg" v-else>
      Your cart is empty, continue shopping to fill it up.
    </p>
  </div>
</template>

<script>
import Price from "@/components/Price.vue";
import { required, minLength, maxLength } from "vuelidate/lib/validators";

import isCreditCard from "validator/lib/isCreditCard";
//import isMobilePhone from "validator/lib/isMobilePhone";
import isEmail from "validator/lib/isEmail";

//const phone = value => isMobilePhone(value, "en-US");
const email = (value) => isEmail(value);
const creditCard = (value) => isCreditCard(value);

export default {
  components: {
    Price,
  },
  data() {
    return {
      name: "",
      address: "",
      phone: "",
      email: "",
      ccNumber: "4444333322221111",
      ccExpiryMonth: new Date().getMonth() + 1,
      ccExpiryYear: new Date().getFullYear() + 5,
      checkoutStatus: "",
      years: [],
    };
  },
  validations: {
    name: {
      required,
      minLength: minLength(4),
      maxLength: maxLength(45),
    },
    address: {
      required,
    },
    phone: {
      required,
      minLength: minLength(10),
      maxLength: maxLength(20),
    },
    email: {
      required,
      email,
    },
    ccNumber: {
      required,
      creditCard,
    },
    ccExpiryMonth: {
      required,
    },
    ccExpiryYear: {
      required,
    },
  },
  computed: {
    cart() {
      return this.$store.state.cart;
    },

    months() {
      return [
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December",
      ];
    },
  },

  methods: {
    submitOrder() {
      console.log("Submit order, check");
      this.$v.$touch();
      if (this.$v.$invalid) {
        this.checkoutStatus = "ERROR";
      } else {
        this.checkoutStatus = "PENDING";
        this.$store
          .dispatch("placeOrder", {
            name: this.name,
            address: this.address,
            phone: this.phone,
            email: this.email,
            ccNumber: this.ccNumber,
            ccExpiryMonth: this.ccExpiryMonth,
            ccExpiryYear: this.ccExpiryYear,
          })
          .then(() => {
            this.checkoutStatus = "OK";
            this.$router.push({ name: "confirmation" });
          })
          .catch((reason) => {
            this.checkoutStatus = "SERVER_ERROR";
            console.log("Error placing order", reason);
          });
      }
      // if its still pending or an error is returned do not submit
      if (this.$v.$pending || this.$v.$error) return;
      // this.$store.dispatch("clearCart" );
    },
    /* NOTE: For example yearFrom(0) == 2021 */
    yearFrom(index) {
      return new Date().getFullYear() + index;
    },
  },
};
</script>

<style scoped>
.checkout-status {
  font-weight: bold;
}
.empty-msg {
  height: 469px;
  font-size: xx-large;
  text-align: center;
}

.error {
  color: red;
  text-align: left;
  font-size: smaller;
  display: block;
  margin: 0.3em 0 0.3em 7px;
}

.checkoutStatusBox {
  margin: 1em;
  padding: 1em;
  text-align: center;
}
.small-input {
  width: 178px;
}

.bottom-wrapper {
  flex: 0 0 auto;
  margin: 3em 0 3em 14em;
}
.bottom-wrapper input,
.bottom-wrapper section {
  margin-bottom: 0.5em;
}
.input-validation {
  display: grid;
  flex: 1 0 250px;
}
/*
.button-wrapper {
  display: flex;
  justify-content: flex-end;
  margin: 2em 0 2em 0;
}
*/
form {
  display: flex;
  max-width: 800px;
  margin: 2em auto 0 auto;
  flex-wrap: wrap;
  justify-content: end;
}
.flex-outer {
  flex: 3 0 100%;
}
.flex-outer li {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
}

.flex-outer > li:not(:last-child) {
  margin-bottom: 20px;
}

.flex-outer li label,
.flex-outer li p {
  padding: 8px;
  font-weight: 300;
  letter-spacing: 0.09em;
  text-transform: uppercase;
}

.flex-outer > li > label,
.flex-outer li p {
  flex: 1 0 120px;
  max-width: 220px;
}

.flex-outer > li > label + * {
  flex: 1 0 220px;
}

.flex-outer li p {
  margin: 0;
}

.flex-outer li input:not([type="checkbox"]),
.flex-outer li textarea,
.flex-outer li select {
  padding: 15px;
  border: 1px solid #ccc;
}

.flex-outer li button {
  margin-left: auto;
  padding: 8px 16px;
  border: none;
  background: #333;
  color: #f2f2f2;
  text-transform: uppercase;
  letter-spacing: 0.09em;
  border-radius: 2px;
}

.flex-inner li {
  width: 100px;
}
</style>
