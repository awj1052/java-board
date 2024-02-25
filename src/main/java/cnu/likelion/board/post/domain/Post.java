package cnu.likelion.board.post.domain;

import cnu.likelion.board.common.exception.ForbiddenException;
import cnu.likelion.board.member.domain.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
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
