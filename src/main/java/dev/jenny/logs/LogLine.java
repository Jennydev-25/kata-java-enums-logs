package dev.jenny.logs;

public class LogLine {

    private LogLevel logLevel;

    public LogLine(String logLine) {
        parseLogLevel(logLine);
    }

    private void parseLogLevel(String logLine) {
        String code = logLine.substring(1, 4);
        this.logLevel = LogLevel.fromCode(code);
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getOutputForShortLog() {
        throw new UnsupportedOperationException("Please implement the getOutputForShortLog() method");
    }

}
