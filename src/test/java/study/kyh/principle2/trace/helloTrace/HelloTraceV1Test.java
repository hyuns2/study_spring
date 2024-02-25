package study.kyh.principle2.trace.helloTrace;

import org.junit.jupiter.api.Test;
import study.kyh.principle2.trace.TraceStatus;
import study.kyh.principle2.trace.helloTrace.HelloTraceV1;

public class HelloTraceV1Test {

    @Test
    void begin_end() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    void begin_exception() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException());
    }

}
