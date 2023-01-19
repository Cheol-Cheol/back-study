package cheolcheol.SpringCoreBasic.discount;

import cheolcheol.SpringCoreBasic.member.Member;

public interface DiscountPolicy {
    // @return 할인 대상 금액
    int discount(Member member, int price);
}
