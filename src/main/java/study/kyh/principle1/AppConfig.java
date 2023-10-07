package study.kyh.principle1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.kyh.principle1.discount.DiscountPolicy;
import study.kyh.principle1.discount.FixDiscountPolicy;
import study.kyh.principle1.discount.RateDiscountPolicy;
import study.kyh.principle1.member.MemberRepository;
import study.kyh.principle1.member.MemberService;
import study.kyh.principle1.member.MemberServiceImpl;
import study.kyh.principle1.member.MemoryMemberRepository;
import study.kyh.principle1.order.OrderService;
import study.kyh.principle1.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
