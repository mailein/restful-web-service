package stackit.coding.challenge

import com.fasterxml.jackson.annotation.JsonProperty

data class Notification(
    @JsonProperty("Type")
    val type: String,
    @JsonProperty("Name")
    val name: String,
    @JsonProperty("Description")
    val description: String,
) {
    override fun toString() = "${name} (${description})"
}