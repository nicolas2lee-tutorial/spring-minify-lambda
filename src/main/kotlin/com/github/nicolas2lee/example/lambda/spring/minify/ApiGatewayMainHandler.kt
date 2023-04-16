package com.github.nicolas2lee.example.lambda.spring.minify

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import com.github.nicolas2lee.example.lambda.spring.minify.function.Function
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApiGatewayMainHandler : RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private val function: Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>

    init {
        val context =
            AnnotationConfigApplicationContext("com.github.nicolas2lee.example.lambda.spring.minify")
        function =
            context.getBean("gatewayUpperFunction") as Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>
    }

    override fun handleRequest(input: APIGatewayProxyRequestEvent, context: Context?): APIGatewayProxyResponseEvent {
        return function.apply(input)
    }

}