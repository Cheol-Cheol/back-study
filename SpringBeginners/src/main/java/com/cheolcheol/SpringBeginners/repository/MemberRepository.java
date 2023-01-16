package com.cheolcheol.SpringBeginners.repository;

import com.cheolcheol.SpringBeginners.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    // 반환값이 null일 때 요즘에는 null을 그대로 반환하기 보단, optional로 한번 감싸서 반환한다.
    List<Member> findAll();
}
