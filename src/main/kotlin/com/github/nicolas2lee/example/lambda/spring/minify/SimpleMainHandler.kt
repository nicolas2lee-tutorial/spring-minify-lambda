package com.github.nicolas2lee.example.lambda.spring.minify

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.github.nicolas2lee.example.lambda.spring.minify.function.Function
import org.springframework.context.annotation.AnnotationConfigApplicationContext

typealias TestStringType = Map<String, String>?

class SimpleMainHandler : RequestHandler<TestStringType, TestStringType> {
    private val function: Function<TestStringType, TestStringType>

    init {
        val context =
            AnnotationConfigApplicationContext("com.github.nicolas2lee.example.lambda.spring.minify")
        function = context.getBean("upperFunction") as Function<TestStringType, TestStringType>
    }

    override fun handleRequest(input: TestStringType, context: Context?): TestStringType {
        return function.apply(input)
    }
}


