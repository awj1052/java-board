package cnu.likelion.board.post.domain;

import cnu.likelion.board.member.domain.Member;
import java.time.LocalDateTime;
import lombok.Getter;

// TODO [5단계] Post 를 Entity로 만들어보자 (Member 클래스를 먼저 진행하고 진행한다)
@Getter
public class Post {

    // TODO [5단계] 해당 값을 DB의 AUTO_INCREMENT 되는 PK로 설정한다.
    private Long id;

    private String title;
    private String content;
    private LocalDateTime createdDate;

    // TODO [5단계] Member 엔티티와의 연관관계를 설정한다. FK 컬럼명은 writer_id로 설정한다.
    // TODO [5단계] 지연 로딩되도록 설정한다.
    private Member writer;

    public Post(String title, String content, Member writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdDate = LocalDateTime.now();
    }

    public void validateAuthority(Member member) {
        // TODO [4단계] 포스트 작성자와 주어진 회원이 동일한지 검사하고, 동일하지 않으면 예외를 발생시킵니다.
        // TODO [4단계] 회원은 Id가 같다면 필드가 달라도 동일한 회원이라 판단합니다.
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
