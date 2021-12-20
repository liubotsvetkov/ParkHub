<template>
    <select class="custom-select" :value="modelValue" @input="$emit('update:modelValue', $event.target.value)">
        <option v-for="option in options" :key="option" :value="option">{{ option }}</option>
    </select>
</template>

<script>
export default {
    props: {
        modelValue: String,
        options: Array
    }
}
</script>

<style>
    .custom-select {
        width: 16rem;
        height: 2rem;
        border: 1px solid #E5E5E5;
        border-radius: 15px 15px 15px 15px;
        box-shadow: 0 0 10px #E8E8E8 inset;
        -webkit-appearance: none;
        -moz-appearance: none;
        padding: 4px 15px 4px 15px;
        color: #818181;
        font-size: 17px;
        margin-top: 0.4rem;
        margin-left: 0.5rem;
    }
</style>