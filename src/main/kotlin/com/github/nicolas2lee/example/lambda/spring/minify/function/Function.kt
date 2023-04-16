package com.github.nicolas2lee.example.lambda.spring.minify.function

interface Function<Input, Output> {
    fun apply(input: Input): Output
}