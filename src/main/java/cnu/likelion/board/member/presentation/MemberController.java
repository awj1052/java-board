package cnu.likelion.board.member.presentation;

import cnu.likelion.board.auth.jwt.JwtService;
import cnu.likelion.board.member.application.MemberService;
import cnu.likelion.board.member.presentation.request.LoginRequest;
import cnu.likelion.board.member.presentation.request.MemberSignupRequest;
import cnu.likelion.board.member.presentation.response.LoginResponse;
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
    private final JwtService jwtService;

    @PostMapping
    public ResponseEntity<Void> signup(
            @Valid @RequestBody MemberSignupRequest request
    ) {
        Long memberId = memberService.signup(request.username(), request.password(), request.name());
        return ResponseEntity.created(URI.create("/members/" + memberId)).build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request
    ) {
        // TODO [2단계] 회원 서비스를 사용하여 로그인을 진행합니다.
        // TODO [2단계] 로그인 결과 반환된 Id를 가지고 Jwt(AccessToken)를 생성합니다.
        // TODO [2단계] 생성한 accessToken을 LoginResponse로 감싸 반환합니다.
        return null;
    }
}
