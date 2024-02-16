package cnu.likelion.board.post.domain;

import cnu.likelion.board.common.exception.ForbiddenException;
import cnu.likelion.board.member.domain.Member;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class Post {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private Member writer;

    public Post(String title, String content, Member writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdDate = LocalDateTime.now();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void validateAuthority(Member member) {
        if (!writer.getId().equals(member.getId())) {
            throw new ForbiddenException("포스트에 대한 권한이 없습니다.");
        }
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
