package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

public class HelloTraceV2Test {

    @Test
    void begin_end() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "helloTwo");
        trace.beginSync(status.getTraceId(), "helloTwo");
        trace.end(status);
        trace.end(status2);
    }

    @Test
    void begin_exception() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "helloTwo");
        trace.exception(status, new IllegalStateException());
        trace.exception(status2, new IllegalStateException());
    }
}
