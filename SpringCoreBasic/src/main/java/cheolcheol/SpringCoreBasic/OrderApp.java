package cheolcheol.SpringCoreBasic;

import cheolcheol.SpringCoreBasic.member.Grade;
import cheolcheol.SpringCoreBasic.member.Member;
import cheolcheol.SpringCoreBasic.member.MemberService;
import cheolcheol.SpringCoreBasic.member.MemberServiceImpl;
import cheolcheol.SpringCoreBasic.order.Order;
import cheolcheol.SpringCoreBasic.order.OrderService;
import cheolcheol.SpringCoreBasic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        // MemberService memberService = new MemberServiceImpl(null);
        // OrderService orderService = new OrderServiceImpl(null, null);
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order.toString());
    }
}
