package study.kyh.principle2.trace.logTrace;

import study.kyh.principle2.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);

}
