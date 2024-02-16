package cnu.likelion.board.post.presentation;

import cnu.likelion.board.auth.Auth;
import cnu.likelion.board.post.application.PostService;
import cnu.likelion.board.post.presentation.request.PostUpdateRequest;
import cnu.likelion.board.post.presentation.request.PostWriteRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/posts")
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> write(
            @Auth Long memberId,
            @RequestBody PostWriteRequest request
    ) {
        Long postId = postService.write(memberId, request.title(), request.title());
        return ResponseEntity.created(URI.create("/posts/" + postId)).build();
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable("id") Long id,
            @Auth Long memberId,
            @RequestBody PostUpdateRequest request
    ) {
        postService.update(memberId, id, request.title(), request.content());
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") Long id,
            @Auth Long memberId
    ) {
        postService.delete(memberId, id);
    }
}
