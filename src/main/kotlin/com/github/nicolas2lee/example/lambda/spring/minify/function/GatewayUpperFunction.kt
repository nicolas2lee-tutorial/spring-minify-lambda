package com.github.nicolas2lee.example.lambda.spring.minify.function

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import org.springframework.stereotype.Service


@Service
class GatewayUpperFunction : Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    override fun apply(input: APIGatewayProxyRequestEvent): APIGatewayProxyResponseEvent {
        return APIGatewayProxyResponseEvent()
            .withStatusCode(200)
            .withHeaders(input.headers)
            .withBody(input.body.uppercase())
    }
}