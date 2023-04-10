package nicolas2lee.github.com.example.lambda.spring.minify

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import nicolas2lee.github.com.example.lambda.spring.minify.function.Function
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class Main : RequestHandler<String, String> {
    private val function: Function

    init {
        val context =
            AnnotationConfigApplicationContext("nicolas2lee.github.com.example.lambda.spring.minify")
        context.refresh()
        function = context.getBean("upperFunction") as Function
    }

    override fun handleRequest(input: String?, context: Context?): String {
        return function.apply(input)
    }
}


