package cnu.likelion.board.member.domain;

import cnu.likelion.board.common.exception.UnAuthorizedException;
import lombok.Getter;

@Getter
public class Member {

    private Long id;
    private String username;
    private String password;
    private String name;

    public Member(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void signup(MemberValidator validator) {
        validator.validateDuplicatedUsername(username);
    }

    public void login(String password) {
        if (!password.equals(this.password)) {
            throw new UnAuthorizedException("비밀번호가 일치하지 않습니다.");
        }
    }
}
