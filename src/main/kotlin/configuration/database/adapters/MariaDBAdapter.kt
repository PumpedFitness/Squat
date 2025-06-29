package ord.pumped.configuration.database.adapters

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.Application
import ord.pumped.configuration.database.DBAdapter
import ord.pumped.configuration.secrets
import ord.pumped.io.env.EnvVariables
import javax.sql.DataSource

class MariaDBAdapter: DBAdapter {

    override fun asDataSource(application: Application): DataSource {
        val secrets = application.secrets

        val config = HikariConfig().apply {
            username = secrets[EnvVariables.SQUAT_DB_USER]
            password = secrets[EnvVariables.SQUAT_DB_PASSWORD]
            jdbcUrl = "jdbc:mariadb://${secrets[EnvVariables.SQUAT_DB_HOST]}:${secrets[EnvVariables.SQUAT_DB_PORT]}/${secrets[EnvVariables.SQUAT_DB_DATABASE]}"
        }

        return HikariDataSource(config)
    }
}