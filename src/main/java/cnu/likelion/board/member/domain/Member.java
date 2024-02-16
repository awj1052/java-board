package cnu.likelion.board.member.domain;

import lombok.Getter;

// TODO [5단계] Member 를 Entity로 만들어보자
@Getter
public class Member {

    // TODO [5단계] 해당 값을 DB의 AUTO_INCREMENT 되는 PK로 설정한다.
    private Long id;

    // TODO [5단계] 아이디는 unique 해야 한다
    private String username;

    private String password;
    private String name;

    public Member(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public void signup(MemberValidator validator) {
        // TODO [1단계] validator를 통해 닉네임 중복 검증을 진행하세요
    }

    public void login(String password) {
        // TODO [2단계] 비밀번호가 일치하지 않으면 예외를 발생시킵니다.
        // TODO [2단계] 발생하는 예외는 테스트를 참고합니다.
    }
}
