package stackit.coding.challenge

import jakarta.enterprise.context.ApplicationScoped
import org.jboss.logging.Logger

@ApplicationScoped
class NotificationService {

    val LOG: Logger = Logger.getLogger(this.javaClass)

    fun triageNotification(notification: Notification) {
        LOG.debug("Triage notification: $notification")
    }
}