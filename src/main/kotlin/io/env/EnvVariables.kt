package ord.pumped.io.env

/**
 * Register all env variables inside of this class to make sure, they are loaded correctly
 */
enum class EnvVariables(
    val type: EnvType,
    val default: String? = null,
    val requiresNonEmpty: Boolean = true,
) {
    SQUAT_MODE(EnvType.STRING, "DEV"),

    SQUAT_DB_TYPE(EnvType.STRING),
    SQUAT_DB_HOST(EnvType.STRING),
    SQUAT_DB_PORT(EnvType.INT),
    SQUAT_DB_DATABASE(EnvType.STRING),
    SQUAT_DB_USER(EnvType.STRING),
    SQUAT_DB_PASSWORD(EnvType.STRING),

    SQUAT_REDIS_HOST(EnvType.STRING),
    SQUAT_REDIS_PORT(EnvType.STRING),

    SQUAT_RABBITMQ_USER(EnvType.STRING),
    SQUAT_RABBITMQ_PASSWORD(EnvType.STRING),
    SQUAT_RABBITMQ_PORT(EnvType.NUMBER),
    SQUAT_RABBITMQ_HOST(EnvType.STRING),
}

enum class EnvType(val cast: (value: String) -> Boolean) {
    STRING({ true }),
    LONG({ it.toLongOrNull() != null }),
    INT({ it.toIntOrNull() != null }),
    NUMBER({ it.toDoubleOrNull() != null }),
    BOOLEAN({ it.toBooleanStrictOrNull() != null }),
}