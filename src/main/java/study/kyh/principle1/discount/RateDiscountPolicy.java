package study.kyh.principle1.discount;

import org.springframework.stereotype.Component;
import study.kyh.principle1.member.Grade;
import study.kyh.principle1.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
            return price * discountPercent / 100;
        else
            return 0;
    }
}
