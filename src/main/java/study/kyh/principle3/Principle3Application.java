package study.kyh.principle3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import study.kyh.principle3.config.AppV1Config;
import study.kyh.principle3.config.AppV2Config;
import study.kyh.principle3.config.v1_proxy.ConcreteProxyConfig;
import study.kyh.principle3.config.v1_proxy.InterfaceProxyConfig;
import study.kyh.principle3.config.v2_dynamic_proxy.handler.DynamicProxyBasicConfig;
import study.kyh.principle3.trace.log_trace.LogTrace;
import study.kyh.principle3.trace.log_trace.ThreadLocalLogTrace;

// @Import({AppV1Config.class, AppV2Config.class})
// @Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
@Import(DynamicProxyBasicConfig.class)
@SpringBootApplication(scanBasePackages = "study.kyh.principle3.app.v3")
public class Principle3Application {

    public static void main(String[] args) {
        SpringApplication.run(Principle3Application.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
