package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

public class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus status = trace.begin("hello");
        TraceStatus statusTwo = trace.begin("helloTwo");
        trace.end(statusTwo);
        trace.end(status);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status = trace.begin("hello");
        TraceStatus statusTwo = trace.begin("helloTwo");
        trace.exception(statusTwo, new IllegalStateException());
        trace.exception(status, new IllegalStateException());
    }
}
