package study.kyh.principle3.pure_proxy.concrete_proxy;

import org.junit.jupiter.api.Test;
import study.kyh.principle3.pure_proxy.concrete_proxy.code.ConcreteClient;
import study.kyh.principle3.pure_proxy.concrete_proxy.code.ConcreteLogic;

public class ConcreteProxyTest {
    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient concreteClient = new ConcreteClient(concreteLogic);
        concreteClient.execute();
    }
}
