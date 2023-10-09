package study.kyh.principle1.singleTon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingleTonServiceTest {

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singleTonServiceTest() {
        SingleTonService singleTonService1 = SingleTonService.getInstance();
        SingleTonService singleTonService2 = SingleTonService.getInstance();

        System.out.println("singleTonService1 = " + singleTonService1);
        System.out.println("singleTonService2 = " + singleTonService2);

        Assertions.assertThat(singleTonService1).isSameAs(singleTonService2);

        singleTonService1.logic();
    }

}
