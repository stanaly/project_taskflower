package taskflower.taskflower.security;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import taskflower.taskflower.security.model.LoginRequset;
import taskflower.taskflower.security.model.LoginResponse;
import taskflower.taskflower.security.model.SignupRequset;
import taskflower.taskflower.security.model.SignupResponse;
import taskflower.taskflower.user.User;
import taskflower.taskflower.user.UserService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final TokenProvider tokenProvider;
    private final UserService userService;
    private final AuthService authService;

    public AuthController(TokenProvider tokenProvider, UserService userService, AuthService authService) {
        this.tokenProvider = tokenProvider;
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequset loginRequset) {
        Authentication auth = authService.authenticateUser(loginRequset);

        String token = tokenProvider.createToken(auth);

        return ResponseEntity.ok().body(new LoginResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@Valid @RequestBody SignupRequset signupRequset) throws Exception {
        User user = new User(signupRequset);
        userService.signup(user);
        return ResponseEntity.ok().body(new SignupResponse("회원가입 성공"));
    }
}
