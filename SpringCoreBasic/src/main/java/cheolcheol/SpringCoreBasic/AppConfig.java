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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
