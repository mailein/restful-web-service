package stackit.coding.challenge

import io.quarkus.test.InjectMock
import io.quarkus.test.junit.QuarkusTest
import jakarta.inject.Inject
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito

@QuarkusTest
class NotificationServiceTest {
    @Inject
    lateinit var notificationService: NotificationService

    @InjectMock
    @RestClient
    lateinit var slack: SlackHttpClient

    @Test
    fun `a warning should trigger slack msg`() {
        val notification = Notification("Warning", "hello", "world")

        notificationService.triageNotification(notification)
        Mockito.verify(slack).sendWarning(SlackMessage(notification.toString()))
    }

    @Test
    fun `an info should NOT trigger slack msg`() {
        val notification = Notification("Info", "hello", "world")

        notificationService.triageNotification(notification)
        Mockito.verify(slack, Mockito.never()).sendWarning(SlackMessage(notification.toString()))
    }

}