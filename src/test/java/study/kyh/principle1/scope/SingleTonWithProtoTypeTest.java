package study.kyh.principle1.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingleTonWithProtoTypeTest {

    @Test
    void protoTypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);

        ProtoTypeBean protoTypeBean1 = ac.getBean(ProtoTypeBean.class);
        ProtoTypeBean protoTypeBean2 = ac.getBean(ProtoTypeBean.class);

        protoTypeBean1.addCount();
        protoTypeBean2.addCount();

        Assertions.assertThat(protoTypeBean1.getCount()).isEqualTo(1);
        Assertions.assertThat(protoTypeBean2.getCount()).isEqualTo(1);
    }

    @Test
    void singleTonClientUseProtoType() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, ProtoTypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        ClientBean clientBean2 = ac.getBean(ClientBean.class);

        int count1 = clientBean1.logic();
        int count2 = clientBean2.logic();

        Assertions.assertThat(count1).isEqualTo(1);
        Assertions.assertThat(count2).isEqualTo(2);
    }

    static class ClientBean {
        private final ProtoTypeBean protoTypeBean;

        @Autowired
        public ClientBean(ProtoTypeBean protoTypeBean) {
            this.protoTypeBean = protoTypeBean;
        }

        public int logic() {
            protoTypeBean.addCount();
            int count = protoTypeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class ProtoTypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("ProtoTypeBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("ProtoTypeBean.destroy");
        }
    }

}
