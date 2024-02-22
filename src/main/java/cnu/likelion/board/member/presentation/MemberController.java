package cnu.likelion.board.member.presentation;

import cnu.likelion.board.member.application.MemberService;
import cnu.likelion.board.member.presentation.request.MemberSignupRequest;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Void> signup(
            @Valid @RequestBody MemberSignupRequest request
    ) {
        Long id = memberService.signup(request.username(), request.password(), request.name());
        return ResponseEntity.created(URI.create("/members/" + id)).build();
    }
}
