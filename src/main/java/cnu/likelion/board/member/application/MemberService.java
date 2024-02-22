package cnu.likelion.board.member.application;

import cnu.likelion.board.common.exception.UnAuthorizedException;
import cnu.likelion.board.member.domain.Member;
import cnu.likelion.board.member.domain.MemberRepository;
import cnu.likelion.board.member.domain.MemberValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
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
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UnAuthorizedException("존재하지 않는 아이디입니다."));
        member.login(password);
        return member.getId();
    }
}
