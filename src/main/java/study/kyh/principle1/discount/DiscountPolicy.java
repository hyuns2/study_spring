package study.kyh.principle1.discount;

import study.kyh.principle1.member.Member;

public interface DiscountPolicy {

    /**
     * 
     * @return 할인 금액
     */
    int discount(Member member, int price);
    
}
