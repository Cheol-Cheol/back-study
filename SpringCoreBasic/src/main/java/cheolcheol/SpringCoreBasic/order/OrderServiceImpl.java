package cheolcheol.SpringCoreBasic.order;

import cheolcheol.SpringCoreBasic.discount.DiscountPolicy;
import cheolcheol.SpringCoreBasic.discount.FixDiscountPolicy;
import cheolcheol.SpringCoreBasic.discount.RateDiscountPolicy;
import cheolcheol.SpringCoreBasic.member.Member;
import cheolcheol.SpringCoreBasic.member.MemberRepository;
import cheolcheol.SpringCoreBasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    // private final MemberRepository memberRepository = new MemoryMemberRepository();

    // OCP & DIP 위반
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 해결 방안, 인터페이스(추상)만 의존하게 코드 변경하기(DIP 해결), 하지만 할당이 되지않아 널 포인트 예외(NPE)가 발생한다.
    // -> 누군가가 클라이언트인 OrderServiceImpl에 DiscountPolicy의 구현 객체를 대신 생성하고 주입해줘야한다.

    // after
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 생성자 주입을 통한 DIP 해결
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
