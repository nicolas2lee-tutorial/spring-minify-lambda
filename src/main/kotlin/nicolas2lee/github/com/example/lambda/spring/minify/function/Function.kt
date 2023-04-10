package nicolas2lee.github.com.example.lambda.spring.minify.function

interface Function {
    fun apply(input: String?): String
}

class UpperFunction : Function {
    override fun apply(input: String?): String {
        return input ?: "".uppercase()
    }

}