package study.kyh.principle3.config.v1_proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.kyh.principle3.app.v2.*;
import study.kyh.principle3.config.v1_proxy.concrete_proxy.OrderControllerConcreteProxy;
import study.kyh.principle3.config.v1_proxy.concrete_proxy.OrderRepositoryConcreteProxy;
import study.kyh.principle3.config.v1_proxy.concrete_proxy.OrderServiceConcreteProxy;
import study.kyh.principle3.trace.log_trace.LogTrace;

@Configuration
public class ConcreteProxyConfig {
    @Bean
    public OrderControllerV2 orderController(LogTrace logTrace) {
        OrderControllerV2 controllerImpl = new OrderControllerV2(orderService(logTrace));
        return new OrderControllerConcreteProxy(controllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV2 orderService(LogTrace logTrace) {
        OrderServiceV2 serviceImpl = new OrderServiceV2(orderRepository(logTrace));
        return new OrderServiceConcreteProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV2 orderRepository(LogTrace logTrace) {
        OrderRepositoryV2 repositoryImpl = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(repositoryImpl, logTrace);
    }
}
