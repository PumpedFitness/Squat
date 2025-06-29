package ord.pumped.configuration

import io.ktor.server.application.*
import ord.pumped.io.websocket.websocketModule
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger()
        modules(websocketModule)
    }
}