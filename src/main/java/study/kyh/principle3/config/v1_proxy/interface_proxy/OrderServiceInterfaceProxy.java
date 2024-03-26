package study.kyh.principle3.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import study.kyh.principle3.app.v1.OrderServiceV1;
import study.kyh.principle3.trace.TraceStatus;
import study.kyh.principle3.trace.log_trace.LogTrace;

@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderServiceV1 {
    private final OrderServiceV1 target;
    private final LogTrace logTrace;

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.orderItem()");
            target.orderItem(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
