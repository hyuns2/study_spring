package study.kyh.principle3.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import study.kyh.principle3.app.v1.OrderRepositoryV1;
import study.kyh.principle3.trace.TraceStatus;
import study.kyh.principle3.trace.log_trace.LogTrace;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {
    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.save()");
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
