package hotelspring.hotelproject.service;


import hotelspring.hotelproject.domain.SiteUser;
import hotelspring.hotelproject.dto.UserDto;
import hotelspring.hotelproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // User 서비스에는 User 리포지터리를 사용하여 User 데이터를 생성하는 create 메서드
    public SiteUser create(Long id, String username, String email, String password) {
        SiteUser user = new SiteUser();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }

    // 회원 가입
    @Transactional
    public void userSignup(UserDto.Request userDto) {

        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(userDto.createUser());

    }
    // 회원 가입 - 중복 체크, 유효성 검사
    @Transactional(readOnly = true)
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatedResult = new HashMap<>();
        for (FieldError error : errors.getFieldErrors()) {
            String validForm = String.format("valid_%s", error.getField());
            validatedResult.put(validForm, error.getDefaultMessage());
        }

        return validatedResult;
    }
}
