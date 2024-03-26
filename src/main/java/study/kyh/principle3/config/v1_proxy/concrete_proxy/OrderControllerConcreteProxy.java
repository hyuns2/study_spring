package study.kyh.principle3.config.v1_proxy.concrete_proxy;

import study.kyh.principle3.app.v2.OrderControllerV2;
import study.kyh.principle3.trace.TraceStatus;
import study.kyh.principle3.trace.log_trace.LogTrace;

public class OrderControllerConcreteProxy extends OrderControllerV2 {
    private final OrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(OrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String reqeust(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.request()");
            String result = target.reqeust(itemId);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
