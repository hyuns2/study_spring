package study.kyh.principle3.pure_proxy.proxy;

import org.junit.jupiter.api.Test;
import study.kyh.principle3.pure_proxy.proxy.code.CacheProxy;
import study.kyh.principle3.pure_proxy.proxy.code.ProxyPatternClient;
import study.kyh.principle3.pure_proxy.proxy.code.RealSubject;
import study.kyh.principle3.pure_proxy.proxy.code.Subject;

public class ProxyPatternTest {
    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest() {
        Subject realSubject = new RealSubject();
        Subject cacheProxy = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);
        client.execute();
        client.execute();
        client.execute();
    }
}
