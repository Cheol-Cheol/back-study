package cheolcheol.SpringCoreBasic;

import cheolcheol.SpringCoreBasic.member.Grade;
import cheolcheol.SpringCoreBasic.member.Member;
import cheolcheol.SpringCoreBasic.member.MemberService;
import cheolcheol.SpringCoreBasic.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        // ApplicationContext: 스프링 컨테이너, @Bean 을 적용한 모든 메서드들을 호출해서 반환된 객체를 스프링 컨테이너에 등록한다.(스프링 빈)
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 원하는 스프링 빈 꺼내쓰기
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
