package vibroad.service.service

import vibroad.service.model.Tag
import vibroad.service.model.Video
import java.util.HashMap
import java.util.UUID
import java.util.stream.Collectors
import javax.inject.Singleton

@Singleton
class VideoService {
    private val videoList: HashMap<UUID, Video> =
            hashMapOf(UUID.fromString("b670c9fe-ea3e-493f-b7f5-9186e640555e") to
                    Video(UUID.fromString("b670c9fe-ea3e-493f-b7f5-9186e640555e"), "Webshop in 5 minutes Part 1", "Building a webshop in 5 minutes with Javascript! - The Frontend", listOf(Tag.FRONTEND, Tag.JAVASCRIPT)))

    fun getAll(): List<Video> {
        return videoList.values.parallelStream().collect(Collectors.toList())
    }

    fun getById(id: UUID?): Video? {
        return videoList[id]
    }

    fun getByName(name: String?): List<Video> {
        return videoList.values.parallelStream().filter { it.name == name }.collect(Collectors.toList())
    }

}