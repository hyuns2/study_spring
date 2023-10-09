package study.kyh.principle1.singleTon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.kyh.principle1.AppConfig;
import study.kyh.principle1.member.MemberService;

public class springContainerService {

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("singleTonService1 = " + memberService1);
        System.out.println("singleTonService2 = " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }

}
