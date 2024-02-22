package cnu.likelion.board.member.domain;

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
        validator.validateDuplicatedUsername(this.username);
    }
}
