package cnu.likelion.board.post.domain;

import cnu.likelion.board.common.exception.ForbiddenException;
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
        if (!this.writer.getId().equals(member.getId())) {
            throw new ForbiddenException("포스트에 대한 권한이 없습니다.");
        }
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
