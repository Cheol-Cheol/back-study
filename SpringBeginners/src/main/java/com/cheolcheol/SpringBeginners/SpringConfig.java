package com.cheolcheol.SpringBeginners;

import com.cheolcheol.SpringBeginners.repository.MemberRepository;
import com.cheolcheol.SpringBeginners.repository.MemoryMemberRepository;
import com.cheolcheol.SpringBeginners.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
