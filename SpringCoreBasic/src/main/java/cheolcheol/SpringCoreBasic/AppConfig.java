package cheolcheol.SpringCoreBasic;

import cheolcheol.SpringCoreBasic.discount.DiscountPolicy;
import cheolcheol.SpringCoreBasic.discount.FixDiscountPolicy;
import cheolcheol.SpringCoreBasic.discount.RateDiscountPolicy;
import cheolcheol.SpringCoreBasic.member.MemberRepository;
import cheolcheol.SpringCoreBasic.member.MemberService;
import cheolcheol.SpringCoreBasic.member.MemberServiceImpl;
import cheolcheol.SpringCoreBasic.member.MemoryMemberRepository;
import cheolcheol.SpringCoreBasic.order.OrderService;
import cheolcheol.SpringCoreBasic.order.OrderServiceImpl;

// 공연 기획자 역할, 의존관계는 여기서 해결한다. 즉, 구현 객체를 생성하고 연결시키자.
public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
