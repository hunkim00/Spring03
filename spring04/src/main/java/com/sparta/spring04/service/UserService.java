package com.sparta.spring04.service;

import com.sparta.spring04.domain.Dto.LoginRequestDto;
import com.sparta.spring04.domain.Dto.SignupRequestDto;
import com.sparta.spring04.domain.entity.User;
import com.sparta.spring04.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public String checkPassword(String password, String username) {

        // 비밀번호 포맷 확인(영문, 특수문자, 숫자 포함 8자 이상)
        Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[0-9]).{4,32}$");
        Matcher passMatcher1 = passPattern1.matcher(password);
        if (!passMatcher1.find()) {
            return "최소 4자 이상이며, 32자 이하 알파벳 소문자(a~z), 숫자(0~9)";
        }
        return password;
    }

    public String checkNickname(String id) {

        // 비밀번호 포맷 확인(영문, 특수문자, 숫자 포함 8자 이상)
        Pattern nicknamePattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[0-9]).{4,12}$");
        Matcher nicknameMatcher1 = nicknamePattern1.matcher(id);
        if (!nicknameMatcher1.find()) {
            return "최소 4자 이상이며, 32자 이하 알파벳 소문자(a~z), 숫자(0~9)";
        }
        return id;
    }

    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        String passwordConfirm = requestDto.getPasswordConfirm();
        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }
        userRepository.save(new User(username,passwordEncoder.encode(password),passwordConfirm));
    }

    // 접근제어자, 변환매개체, 메소드
    public User logdb(LoginRequestDto requestDto){
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();

        Optional<User> find = userRepository.findByUsernameAndPassword(username, password);
        if(!find.isPresent()){
            throw  new NullPointerException("Error");
        }
        return find.get();
    }


}
