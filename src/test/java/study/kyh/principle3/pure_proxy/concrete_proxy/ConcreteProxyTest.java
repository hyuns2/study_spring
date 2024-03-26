package study.kyh.principle3.pure_proxy.concrete_proxy;

import org.junit.jupiter.api.Test;
import study.kyh.principle3.pure_proxy.concrete_proxy.code.ConcreteClient;
import study.kyh.principle3.pure_proxy.concrete_proxy.code.ConcreteLogic;
import study.kyh.principle3.pure_proxy.concrete_proxy.code.TimeProxy;

public class ConcreteProxyTest {
    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient concreteClient = new ConcreteClient(concreteLogic);
        concreteClient.execute();
    }

    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient concreteClient = new ConcreteClient(timeProxy);
        concreteClient.execute();
    }
}
