package vibroad.service.graphql

import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest
import strikt.api.expectThat
import strikt.assertions.isEqualTo

@MicronautTest
class HelloIntegrationTest(
        private val graphQlTestClient: GraphQlTestClient
): StringSpec({

    "should return Hello Si" {
        val queryFile = "hello.txt"

        val result = graphQlTestClient.sendQuery(queryFile)

        expectThat(result) {
            get { get("data").get("hello").textValue() }.isEqualTo("Hello Si!")
        }
    }
})