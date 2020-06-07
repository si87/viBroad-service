package vibroad.service.graphql

import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import vibroad.service.model.Video
import vibroad.service.service.VideoService
import java.util.UUID
import javax.inject.Singleton

@Singleton
class VideosDataFetcher(
        private val videoService: VideoService
) : DataFetcher<List<Video>> {
    override fun get(env: DataFetchingEnvironment): List<Video> = videoService.getAll()
}

@Singleton
class VideoDataFetcher(
        private val videoService: VideoService
) : DataFetcher<Video> {
    override fun get(env: DataFetchingEnvironment): Video? {
        val id = UUID.fromString(env.getArgument<String>("id"))
        return videoService.getById(id)
    }
}

@Singleton
class VideoByNameFetcher(
        private val videoService: VideoService
) : DataFetcher<List<Video>> {
    override fun get(env: DataFetchingEnvironment): List<Video> {
        val name = env.getArgument<String>("name")
        return videoService.getByName(name)
    }
}
