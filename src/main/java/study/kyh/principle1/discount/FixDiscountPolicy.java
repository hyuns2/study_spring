package study.kyh.principle1.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import study.kyh.principle1.member.Grade;
import study.kyh.principle1.member.Member;

@Component
@Primary
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
            return discountFixAmount;
        return 0;
    }
}
