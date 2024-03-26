package study.kyh.principle3.trace.log_trace;

import study.kyh.principle3.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);

}
