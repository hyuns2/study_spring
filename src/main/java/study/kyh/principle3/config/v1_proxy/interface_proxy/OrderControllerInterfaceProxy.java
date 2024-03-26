package study.kyh.principle3.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import study.kyh.principle3.app.v1.OrderControllerV1;
import study.kyh.principle3.trace.TraceStatus;
import study.kyh.principle3.trace.log_trace.LogTrace;

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {
    private final OrderControllerV1 target;
    private final LogTrace logTrace;

    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.request()");
            String result = target.request(itemId);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
