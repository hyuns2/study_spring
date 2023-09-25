package study.kyh.principle1.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
