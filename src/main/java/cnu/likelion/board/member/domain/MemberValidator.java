package cnu.likelion.board.member.domain;

import cnu.likelion.board.common.exception.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberValidator {

    private final MemberRepository memberRepository;

    public void validateDuplicatedUsername(String username) {
        if(memberRepository.findByUsername(username).isPresent()) {
            throw new ConflictException("이미 사용중인 아이디입니다.");
        }
    }
}
