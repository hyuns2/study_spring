package study.kyh.principle1;

import study.kyh.principle1.discount.DiscountPolicy;
import study.kyh.principle1.discount.FixDiscountPolicy;
import study.kyh.principle1.discount.RateDiscountPolicy;
import study.kyh.principle1.member.MemberRepository;
import study.kyh.principle1.member.MemberService;
import study.kyh.principle1.member.MemberServiceImpl;
import study.kyh.principle1.member.MemoryMemberRepository;
import study.kyh.principle1.order.OrderService;
import study.kyh.principle1.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
