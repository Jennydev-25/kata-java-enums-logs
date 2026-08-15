package dev.jenny.logs;

public class LogLine {

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
        String code = logLine.substring(1, 4);
        this.logLevel = LogLevel.fromCode(code);
    }

    private void parseMessage(String logLine) {
        this.message = logLine.substring(logLine.indexOf(": ") + 2);
    }
}
