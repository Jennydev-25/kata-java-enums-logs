package dev.jenny.logs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LogsTest {

    @Test
    @Tag("task:1")
    @DisplayName("Parsing log level TRC")
    public void getLogLevelTrace() {
        var logLine = new LogLine("[TRC]: Line 84 - System.out.println(\"Hello World\");");
        assertThat(logLine.getLogLevel(), is(equalTo(LogLevel.valueOf("TRACE"))));
    }

    @Test
    @Tag("task:1")
    @DisplayName("Parsing log level DBG")
    public void parseLogLevelDbg() {
        var logLine = new LogLine("[DBG]: ; expected");
        assertThat(logLine.getLogLevel(), is(equalTo(LogLevel.valueOf("DEBUG"))));
    }

    @Test
    @Tag("task:1")
    @DisplayName("Parsing log level INF")
    public void parseLogLevelInf() {
        var logLine = new LogLine("[INF]: Timezone changed");
        assertThat(logLine.getLogLevel(), is(equalTo(LogLevel.valueOf("INFO"))));
    }

    @Test
    @Tag("task:1")
    @DisplayName("Parsing log level WRN")
    public void parseLogLevelWrn() {
        var logLine = new LogLine("[WRN]: Timezone not set");
        assertThat(logLine.getLogLevel(), is(equalTo(LogLevel.valueOf("WARNING"))));
    }

    @Test
    @Tag("task:1")
    @DisplayName("Parsing log level ERR")
    public void parseLogLevelErr() {
        var logLine = new LogLine("[ERR]: Disk full");
        assertThat(logLine.getLogLevel(), is(equalTo(LogLevel.valueOf("ERROR"))));
    }

    @Test
    @Tag("task:1")
    @DisplayName("Parsing log level FTL")
    public void parseLogLevelFtl() {
        var logLine = new LogLine("[FTL]: Not enough memory");
        assertThat(logLine.getLogLevel(), is(equalTo(LogLevel.valueOf("FATAL"))));
    }

    @Test
    @Tag("task:2")
    @DisplayName("Parsing unknown log level XYZ")
    public void parseLogLevelXyz() {
        var logLine = new LogLine("[XYZ]: Gibberish message.. beep boop..");
        assertThat(logLine.getLogLevel(), is(equalTo(LogLevel.valueOf("UNKNOWN"))));
    }

    @Test
    @Tag("task:2")
    @DisplayName("Parsing unknown log level ABC")
    public void parseLogLevelAbc() {
        var logLine = new LogLine("[ABC]: Gibberish message.. beep boop..");
        assertThat(logLine.getLogLevel(), is(equalTo(LogLevel.valueOf("UNKNOWN"))));
    }

    @Test
    @Tag("task:3")
    @DisplayName("Get short log output for log level UNKNOWN")
    public void getShortLogOutputUnknown() {
        var logLine = new LogLine("[ABC]: We're no strangers to love");
        assertThat(logLine.getOutputForShortLog(), is(equalTo("0:We're no strangers to love")));
    }

    @Test
    @Tag("task:3")
    @DisplayName("Get short log output for log level TRACE")
    public void getShortLogOutputTrace() {
        var logLine = new LogLine("[TRC]: You know the rules and so do I");
        assertThat(logLine.getOutputForShortLog(), is(equalTo("1:You know the rules and so do I")));
    }

    @Test
    @Tag("task:3")
    @DisplayName("Get short log output for log level DEBUG")
    public void getShortLogOutputDebug() {
        var logLine = new LogLine("[DBG]: A full commitment's what I'm thinking of");
        assertThat(logLine.getOutputForShortLog(), is(equalTo("2:A full commitment's what I'm thinking of")));
    }

    @Test
    @Tag("task:3")
    @DisplayName("Get short log output for log level INFO")
    public void getShortLogOutputInfo() {
        var logLine = new LogLine("[INF]: You wouldn't get this from any other guy");
        assertThat(logLine.getOutputForShortLog(), is(equalTo("4:You wouldn't get this from any other guy")));

    }

    @Test
    @Tag("task:3")
    @DisplayName("Get short log output for log level WARNING")
    public void getShortLogOutputWarning() {
        var logLine = new LogLine("[WRN]: I just wanna tell you how I'm feeling");
        assertThat(logLine.getOutputForShortLog(), is(equalTo("5:I just wanna tell you how I'm feeling")));
    }

    @Test
    @Tag("task:3")
    @DisplayName("Get short log output for log level ERROR")
    public void getShortLogOutputError() {
        var logLine = new LogLine("[ERR]: Gotta make you understand");
        assertThat(logLine.getOutputForShortLog(), is(equalTo("6:Gotta make you understand")));
    }

    @Test
    @Tag("task:3")
    @DisplayName("Get short log output for log level FATAL")
    public void getShortLogOutputFatal() {
        var logLine = new LogLine("[FTL]: Never gonna give you up");
        assertThat(logLine.getOutputForShortLog(), is(equalTo("42:Never gonna give you up")));
    }

}
