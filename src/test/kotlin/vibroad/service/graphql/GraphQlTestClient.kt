package vibroad.service.graphql

import com.fasterxml.jackson.databind.JsonNode
import io.micronaut.core.io.ResourceResolver
import io.micronaut.core.io.scan.ClassPathResourceLoader
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import java.io.File
import javax.inject.Singleton

@Singleton
class GraphQlTestClient(
        private val httpTestClient: HttpTestClient
) {

    fun sendQuery(file: String): JsonNode {

        val graphQlQuery = GraphQlQuery(query = readFile(file))
        return httpTestClient.executeQuery(graphQlQuery)
    }
}

@Client("/")
interface HttpTestClient {

    @Post("/graphql")
    fun executeQuery(@Body query: GraphQlQuery): JsonNode
}

data class GraphQlQuery(
        val variables: Map<String, String>? = null,
        val query: String
)

internal fun readFile(file : String) : String {
    val loader = ResourceResolver().getLoader(ClassPathResourceLoader::class.java).get()
    val resource = loader.getResource("classpath:queries/$file")
    return File(resource.get().toURI()).readText()
}