package stackit.coding.challenge

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.jboss.logging.Logger

@ApplicationScoped
class NotificationService {

    val LOG: Logger = Logger.getLogger(this.javaClass)

    @Inject
    @RestClient
    private lateinit var slack: SlackHttpClient

    fun triageNotification(notification: Notification) {
        LOG.debug("Triage notification: ${notification.type}")

        if (notification.type == "Info") {
            LOG.debug("Notification type is Info, skipping Slack API call")
        } else if (notification.type == "Warning") {
            // https://api.slack.com/messaging/webhooks
            val response = slack.sendWarning(
                message = SlackMessage(notification.toString())
            )
            LOG.debug("Slack API Test response: ${response}")
        }
    }
}