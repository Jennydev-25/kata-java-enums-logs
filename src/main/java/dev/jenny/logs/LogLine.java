package dev.jenny.logs;

public class LogLine {

    private static final int LOG_LEVEL_CODE_START = 1;
    private static final int LOG_LEVEL_CODE_END = 4;
    private static final String MESSAGE_SEPARATOR = ": ";

    private LogLevel logLevel;
    private String message;

    public LogLine(String logLine) {
        parseLogLevel(logLine);
        parseMessage(logLine);
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getOutputForShortLog() {
        return String.format("%d:%s", logLevel.getEncodedValue(), message);
    }

    private void parseLogLevel(String logLine) {
        String code = logLine.substring(LOG_LEVEL_CODE_START, LOG_LEVEL_CODE_END);
        this.logLevel = LogLevel.fromCode(code);
    }

    private void parseMessage(String logLine) {
        this.message = logLine.substring(logLine.indexOf(MESSAGE_SEPARATOR) + MESSAGE_SEPARATOR.length());
    }
}
