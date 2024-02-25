package study.kyh.principle2.app.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.kyh.principle2.trace.TraceId;
import study.kyh.principle2.trace.TraceStatus;
import study.kyh.principle2.trace.helloTrace.HelloTraceV2;
import study.kyh.principle2.trace.logTrace.LogTrace;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("orderService.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

}
