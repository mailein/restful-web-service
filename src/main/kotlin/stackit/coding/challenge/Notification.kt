package stackit.coding.challenge

data class Notification(
    val type: String,
    val name: String,
    val description: String,
) {
    override fun toString() = "${name} (${description})"
}