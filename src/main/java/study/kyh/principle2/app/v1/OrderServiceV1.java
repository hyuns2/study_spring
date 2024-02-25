package study.kyh.principle2.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.kyh.principle2.trace.TraceStatus;
import study.kyh.principle2.trace.helloTrace.HelloTraceV1;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 trace;

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
