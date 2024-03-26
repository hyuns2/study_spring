package study.kyh.principle3.pure_proxy.decorator;

import org.junit.jupiter.api.Test;
import study.kyh.principle3.pure_proxy.decorator.code.Component;
import study.kyh.principle3.pure_proxy.decorator.code.DecoratorPatternClient;
import study.kyh.principle3.pure_proxy.decorator.code.RealComponent;

public class DecoratorPatternTest {
    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }
}
