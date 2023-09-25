package study.kyh.principle1.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.kyh.principle1.member.Grade;
import study.kyh.principle1.member.Member;
import study.kyh.principle1.member.MemberService;
import study.kyh.principle1.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(member.getId(), "itemA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}
