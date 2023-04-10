package nicolas2lee.github.com.example.lambda.spring.minify.function

interface Function<Input, Output> {
    fun apply(input: Input): Output
}