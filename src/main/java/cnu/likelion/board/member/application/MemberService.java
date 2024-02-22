package cnu.likelion.board.member.application;

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
        Member member = new Member(username, password, name);
        member.signup(memberValidator);
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }
}
