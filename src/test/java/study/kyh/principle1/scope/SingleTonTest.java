package study.kyh.principle1.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingleTonTest {

    @Test
    public void singleTonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingleTonBean.class);

        SingleTonBean singleTonBean1 = ac.getBean(SingleTonBean.class);
        SingleTonBean singleTonBean2 = ac.getBean(SingleTonBean.class);

        Assertions.assertThat(singleTonBean1).isSameAs(singleTonBean2);

        ac.close();

    }

    @Scope("singleton")
    static class SingleTonBean {
        @PostConstruct
        public void init() {
            System.out.println("SingleTonBean.init");
        }

        @PreDestroy
        public void destory() {
            System.out.println("SingleTonBean.destroy");
        }
    }

}
