<template>

  <section class="carousel" aria-label="Gallery">
    <div class="slideshow-container">
      <div class="mySlides fade">
        <img :src="require('@/assets/images/carousel/carousel_slide1.png')" :alt="alt1" />
      </div>

      <div class="mySlides fade">
        <img :src="require('@/assets/images/carousel/carousel_slide2.png')" :alt="alt2" />
      </div>

      <!-- Next and previous buttons -->
      <a class="prev" v-show="'slideIndex != numSlides - 1'" @click="plusSlides(-1)">&#10094;</a>
      <a class="next" v-show="'slideIndex != 0 '" @click="plusSlides(1)">&#10095;</a>
    </div>

      <!-- The dots/circles -->
      <div class="div-dots">
        <span class="dot" @click="currentSlide(1)"></span>
        <span class="dot" @click="currentSlide(2)"></span>
      </div>

  </section>
</template>

<script>
export default {
  data() {
    return {
      alt1: "YA",
      alt2: "New releases",
      slideIndex: 1,
      numSlides: 2,
    };
  },
  name: "Carousel",
  methods: {
    showSlides(n) {
      let i;
      let slides = document.getElementsByClassName("mySlides");
      let dots = document.getElementsByClassName("dot");
      if (n > slides.length) {this.slideIndex = 1}
      if (n < 1) {this.slideIndex = slides.length}
      for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
      }
      for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
      }
      slides[this.slideIndex-1].style.display = "block";
      dots[this.slideIndex-1].className += " active";
    },
    currentSlide(n) {
      this.showSlides(this.slideIndex = n);
    },
    plusSlides(n) {
      this.showSlides(this.slideIndex += n);
    }
  },
  mounted() {
    this.showSlides(this.slideIndex = 0);
  }
  };
</script>

<style>
@import "../assets/css/home-carousel.css";
</style>
