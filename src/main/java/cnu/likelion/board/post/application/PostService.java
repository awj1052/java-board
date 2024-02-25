package cnu.likelion.board.post.application;

import cnu.likelion.board.common.exception.UnAuthorizedException;
import cnu.likelion.board.member.domain.Member;
import cnu.likelion.board.member.domain.MemberRepository;
import cnu.likelion.board.post.domain.Post;
import cnu.likelion.board.post.domain.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public Long write(
            Long memberId,
            String title,
            String content
    ) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new UnAuthorizedException("회원 정보가 존재하지 않습니다"));
        Post post = new Post(title, content, member);
        postRepository.save(post);
        return post.getId();
    }

    public void update(
            Long memberId,
            Long postId,
            String title,
            String content
    ) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new UnAuthorizedException("회원 정보가 존재하지 않습니다"));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new UnAuthorizedException("포스트 정보가 존재하지 않습니다"));
        post.validateAuthority(member);
        post.update(title, content);
    }

    public void delete(
            Long memberId,
            Long postId
    ) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new UnAuthorizedException("회원 정보가 존재하지 않습니다"));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new UnAuthorizedException("포스트 정보가 존재하지 않습니다"));
        post.validateAuthority(member);
        postRepository.delete(post);
    }
}
