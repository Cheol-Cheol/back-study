package cheolcheol.SpringCoreBasic.member;

public class MemberServiceImpl implements MemberService{
    // 클라이언트 코드(서비스 코드)는 구현체 말고 '인터페이스'에만 의존해야 DIP 원칙을 지킬 수 있다.
    // -> AppConfig 에서 메모리 회원 리포지토리(구현체) 연결을 관리할 거다.
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    // 생성자 주입을 통한 DIP 해결
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
