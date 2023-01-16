package com.cheolcheol.SpringBeginners.service;

import com.cheolcheol.SpringBeginners.domain.Member;
import com.cheolcheol.SpringBeginners.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    // 테스트 할 객체 생성

    // before.
    // MemberService memberService = new MemberService();
    MemberService memberService;
    // before.
    // MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    //  | 현재 Test 파일에 있는 memberRepository 와 MemberService 에 있는 memberRepository 가 서로 다른 객체다.
    //  | 물론 현재 코드 상, store 을 static 으로 선언해서 문제가 없겠지만 static 이 아니면 문제가 발생하기도 하고,
    //  | 사실, 같은 것을 쓰는게 맞다. -> DI(의존성 주입)
    MemoryMemberRepository memberRepository;

    // 테스트 하기 전 DI(의존성 주입)
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void duplicateMemberException() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        // 뒤에 람다 함수를 실행, 예외가 있으면 예외 발생
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}