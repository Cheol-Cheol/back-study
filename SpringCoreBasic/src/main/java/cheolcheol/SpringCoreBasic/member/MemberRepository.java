package cheolcheol.SpringCoreBasic.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
