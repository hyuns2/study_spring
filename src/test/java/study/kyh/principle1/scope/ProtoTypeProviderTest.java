package study.kyh.principle1.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Provider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class ProtoTypeProviderTest {

    @Test
    void providerTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, ProtoTypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        ClientBean clientBean2 = ac.getBean(ClientBean.class);

        int count1 = clientBean1.logic();
        int count2 = clientBean2.logic();

        Assertions.assertThat(count1).isEqualTo(1);
        Assertions.assertThat(count2).isEqualTo(1);
    }

    static class ClientBean {
//        @Autowired
//        private ApplicationContext ac;

//        @Autowired
//        private ObjectProvider<ProtoTypeBean> protoTypeBeanProvider;

        @Autowired
        private Provider<ProtoTypeBean> provider;

//        public int logic() {
//            ProtoTypeBean protoTypeBean = ac.getBean(ProtoTypeBean.class);
//            protoTypeBean.addCount();
//            int count = protoTypeBean.getCount();
//            return count;
//        }
//        public int logic() {
//            ProtoTypeBean protoTypeBean = protoTypeBeanProvider.getObject();
//            protoTypeBean.addCount();
//            int count = protoTypeBean.getCount();
//            return count;
//        }
        public int logic() {
            ProtoTypeBean protoTypeBean = provider.get();
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
