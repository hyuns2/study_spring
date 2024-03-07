package study.kyh.principle2.app.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.kyh.principle2.trace.AbstractTemplate;
import study.kyh.principle2.trace.TraceStatus;
import study.kyh.principle2.trace.logTrace.LogTrace;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };
        template.execute("OrderService.orderItem()");
    }

}
