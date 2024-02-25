package cnu.likelion.board.member.domain;

import cnu.likelion.board.common.exception.UnAuthorizedException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;
    private String name;

    public Member(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public void signup(MemberValidator validator) {
        validator.validateDuplicatedUsername(username);
    }

    public void login(String password) {
        if (!this.password.equals(password)) {
            throw new UnAuthorizedException("비밀번호가 일치하지 않습니다.");
        }
    }
}
