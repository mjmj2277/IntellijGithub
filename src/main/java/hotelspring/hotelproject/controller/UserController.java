package hotelspring.hotelproject.controller;

import hotelspring.hotelproject.dto.UserDto;
import hotelspring.hotelproject.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

// 응답을 받거나 준다
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    // 회원 가입
    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("userDto", new UserDto.Request());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserDto.Request userDto, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("userDto", userDto);

            Map<String, String> validatedResult = userService.validateHandling(errors);
            for (String key : validatedResult.keySet()) {
                model.addAttribute(key, validatedResult.get(key));
            }
            return "signup";
        }

        userService.userSignup(userDto);
        return "index";
    }

    // 로그인
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
