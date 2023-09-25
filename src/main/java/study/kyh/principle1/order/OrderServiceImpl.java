package study.kyh.principle1.order;

import study.kyh.principle1.discount.DiscountPolicy;
import study.kyh.principle1.discount.FixDiscountPolicy;
import study.kyh.principle1.member.Member;
import study.kyh.principle1.member.MemberRepository;
import study.kyh.principle1.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{


    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
