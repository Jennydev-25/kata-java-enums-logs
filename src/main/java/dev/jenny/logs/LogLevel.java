package dev.jenny.logs;

public enum LogLevel {
    TRACE("TRC", 1),
    DEBUG("DBG", 2),
    INFO("INF", 4),
    WARNING("WRN", 5),
    ERROR("ERR", 6),
    FATAL("FTL", 42),
    UNKNOWN("", 0);

    private final String code;
    private final int encodedValue;

    LogLevel(String code, int encodedValue) {
        this.code = code;
        this.encodedValue = encodedValue;
    }

    public int getEncodedValue() {
        return encodedValue;
    }

    public static LogLevel fromCode(String code) {
        for (LogLevel level : values()) {
            if (level.code.equals(code)) {
                return level;
            }
        }
        return UNKNOWN;
    }
}
