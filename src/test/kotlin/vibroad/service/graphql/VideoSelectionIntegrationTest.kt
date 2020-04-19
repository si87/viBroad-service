package vibroad.service.graphql

import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest
import strikt.api.expectThat
import strikt.assertions.all
import strikt.assertions.isEqualTo

@MicronautTest
class VideoSelectionIntegrationTest(
        private val graphQlTestClient: GraphQlTestClient
) : StringSpec({

    "should return a array containing the single stored video entity" {
        val result = graphQlTestClient.sendQuery("select_all_videos.txt")

        expectThat(result.get("data").get("videos")).all {
            get { get("id").textValue() }.isEqualTo("b670c9fe-ea3e-493f-b7f5-9186e640555e")
            get { get("name").textValue() }.isEqualTo("Webshop in 5 minutes Part 1")
            get { get("description").textValue() }.isEqualTo("Building a webshop in 5 minutes with Javascript! - The Frontend")
        }
    }

    "should return the video identified by the passed id in the query" {
        val result = graphQlTestClient.sendQuery("select_video_by_id.txt")

        println(result)

        expectThat(result.get("data").get("video")) {
            get { get("id").textValue() }.isEqualTo("b670c9fe-ea3e-493f-b7f5-9186e640555e")
            get { get("name").textValue() }.isEqualTo("Webshop in 5 minutes Part 1")
            get { get("description").textValue() }.isEqualTo("Building a webshop in 5 minutes with Javascript! - The Frontend")
        }
    }
})