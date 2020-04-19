package vibroad.service.model

import java.util.UUID

data class Video(

        val id: UUID,

        val name: String,

        val description: String,

        val tags: List<Tag>
) {}