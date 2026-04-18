<script setup>
import { ref } from 'vue'
import axios from 'axios'

const result = ref(null)

const getDivination = async () => {
  try {
    const res = await axios.get('http://localhost:8081/divination/generate')
    result.value = res.data
    console.log(res.data)
  } catch (err) {
    console.error(err)
  }
}
</script>

<template>
  <div>
    <h1>易经起卦</h1>

    <button @click="getDivination">
      点击起卦
    </button>

    <div v-if="result">
      <p>卦名：{{ result.name }}</p>
      <p>上卦：{{ result.upper }}</p>
      <p>下卦：{{ result.lower }}</p>
    </div>
  </div>
</template>