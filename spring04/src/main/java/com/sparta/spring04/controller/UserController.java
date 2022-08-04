package com.sparta.spring04.controller;


import com.sparta.spring04.domain.Dto.SignupRequestDto;
import com.sparta.spring04.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    // 회원 로그인 페이지
    @GetMapping("/api/member/login")
    public String login() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/api/member/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/api/member/signup")
    public String registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return "redirect:/api/member/login";
    }

//    @PostMapping("/api/member/login")
//        public ResponseEntity<?> login(@RequestBody LoginRequestDto requestDto){
//        User user = userService.logdb(requestDto);
//        Authentication authentication = new UserAuthentication(user.getUsername(), null, null);
//        String token = JwtTokenProvider.generateToken(authentication);
//
//        return ResponseEntity.ok(token);
//    }


}
