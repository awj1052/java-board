package cnu.likelion.board.post.presentation;

import cnu.likelion.board.auth.Auth;
import cnu.likelion.board.post.application.PostService;
import cnu.likelion.board.post.presentation.request.PostUpdateRequest;
import cnu.likelion.board.post.presentation.request.PostWriteRequest;
import jakarta.validation.Valid;
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
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> write(
            @Auth Long memberId,
            @Valid @RequestBody PostWriteRequest writeRequest
    ) {
        Long postId = postService.write(memberId, writeRequest.title(), writeRequest.content());
        return ResponseEntity.created(URI.create("/posts/" + postId)).build();
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable("id") Long postId,
            @Auth Long memberId,
            @Valid @RequestBody PostUpdateRequest updateRequest
    ) {
        postService.update(memberId, postId, updateRequest.title(), updateRequest.content());
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") Long postId,
            @Auth Long memberId
    ) {
        postService.delete(memberId, postId);
    }
}
