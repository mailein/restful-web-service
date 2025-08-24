package stackit.coding.challenge

import jakarta.ws.rs.POST
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient

@RegisterRestClient(configKey = "slack-channel-warnings")
interface SlackHttpClient {

    @POST
    fun sendWarning(notification: Notification)
}