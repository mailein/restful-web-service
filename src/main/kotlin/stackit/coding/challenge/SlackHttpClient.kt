package stackit.coding.challenge

import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.POST
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient

@ApplicationScoped
@RegisterRestClient(configKey = "slack-channel-warnings")
interface SlackHttpClient {

    @POST
    fun sendWarning(message: SlackMessage)
}

data class SlackMessage(
    val text: String
)