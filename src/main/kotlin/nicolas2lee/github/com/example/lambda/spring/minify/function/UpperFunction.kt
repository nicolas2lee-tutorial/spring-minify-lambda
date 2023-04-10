package nicolas2lee.github.com.example.lambda.spring.minify.function

import nicolas2lee.github.com.example.lambda.spring.minify.TestStringType
import org.springframework.stereotype.Service


@Service
class UpperFunction : Function<TestStringType, TestStringType> {
    override fun apply(input: TestStringType): TestStringType {
        return input?.entries?.associate {
            it.key.uppercase() to it.value.uppercase()
        }
    }
}