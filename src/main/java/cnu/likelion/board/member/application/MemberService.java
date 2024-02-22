package cnu.likelion.board.member.application;

import cnu.likelion.board.member.domain.Member;
import cnu.likelion.board.member.domain.MemberRepository;
import cnu.likelion.board.member.domain.MemberValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberValidator memberValidator;

    public Long signup(
            String username,
            String password,
            String name
    ) {
        Member member  = new Member(username, password, name);
        member.signup(memberValidator);
        return memberRepository.save(member).getId();
    }

    public Long login(
            String username,
            String password
    ) {
        // TODO [2단계] 저장소에서 주어진 username이라는 아이디를 갖는 회원을 찾습니다.
        // TODO [2단계] 해당 회원이 없다면 테스트를 참고하여 예외를 발생시킵니다.
        // TODO [2단계] 회원을 찾아왔다면 로그인을 진행합니다. 이때 비밀번호 비교 로직은 이곳에서 진행하지 말고 member 객체에게 시킵니다.
        // TODO [2단계] 로그인에 성공하면 회원 id를 반환합니다.
        return null;
    }
}
