package study.kyh.principle1.order;

import study.kyh.principle1.discount.DiscountPolicy;
import study.kyh.principle1.discount.FixDiscountPolicy;
import study.kyh.principle1.discount.RateDiscountPolicy;
import study.kyh.principle1.member.Member;
import study.kyh.principle1.member.MemberRepository;
import study.kyh.principle1.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
