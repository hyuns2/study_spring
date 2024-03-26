package study.kyh.principle3.config.v1_proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.kyh.principle3.app.v1.*;
import study.kyh.principle3.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import study.kyh.principle3.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import study.kyh.principle3.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import study.kyh.principle3.trace.log_trace.LogTrace;

@Configuration
public class InterfaceProxyConfig {
    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace) {
        OrderControllerV1Impl controllerImpl = new OrderControllerV1Impl(orderService(logTrace));
        return new OrderControllerInterfaceProxy(controllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace) {
        OrderServiceV1Impl serviceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1Impl repositoryImpl = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(repositoryImpl, logTrace);
    }
}