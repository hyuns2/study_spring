package study.kyh.principle2.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.kyh.principle2.trace.TraceId;
import study.kyh.principle2.trace.TraceStatus;
import study.kyh.principle2.trace.helloTrace.HelloTraceV2;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "orderService.orderItem()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

}
