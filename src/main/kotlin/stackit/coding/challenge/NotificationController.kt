package stackit.coding.challenge

import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.MediaType

@Path("/notifications")
class NotificationController {

    @Inject
    lateinit var notificationService: NotificationService

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun createNotification(notification: Notification) =
        notificationService.triageNotification(notification)
}