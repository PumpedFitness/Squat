package ord.pumped.configuration

import io.github.damir.denis.tudor.ktor.server.rabbitmq.RabbitMQ
import io.ktor.server.application.*
import ord.pumped.io.env.EnvVariables

fun Application.configureRabbitMQ() {
    log.info("Connecting to RabbitMQ")
    install(RabbitMQ) {
        uri = "amqp://${secrets[EnvVariables.SQUAT_RABBITMQ_USER]}:${secrets[EnvVariables.SQUAT_RABBITMQ_PASSWORD]}@${secrets[EnvVariables.SQUAT_RABBITMQ_HOST]}:${secrets[EnvVariables.SQUAT_RABBITMQ_PORT]}"
        defaultConnectionName = "default-connection"
        dispatcherThreadPollSize = 4
        tlsEnabled = false
    }
}