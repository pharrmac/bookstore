<template>
  <div class="home-page">
    <home-carousel></home-carousel>
    <home-category></home-category>
  </div>
</template>

<script>
import HomeCarousel from "@/components/HomeCarousel";
import HomeCategory from "@/components/HomeCategory";
export default {
  name: "Home",
  components: {
    'home-carousel': HomeCarousel,
    'home-category': HomeCategory
  },
};
</script>
