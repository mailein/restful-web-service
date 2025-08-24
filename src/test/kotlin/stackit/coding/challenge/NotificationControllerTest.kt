package stackit.coding.challenge

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class NotificationControllerTest {

    @Test
    fun createNotificationEndpoint() {
        val body = Notification("Warning", "hello", "world")

        given()
            .body(body)
            .contentType("application/json")
            .`when`().post("/notifications")
            .then()
            .statusCode(204)
    }

}