package study.kyh.principle2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.kyh.principle2.trace.logTrace.FieldLogTrace;
import study.kyh.principle2.trace.logTrace.LogTrace;
import study.kyh.principle2.trace.logTrace.ThreadLocalLogTrace;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
//        return new FieldLogTrace();
        return new ThreadLocalLogTrace();
    }

}
