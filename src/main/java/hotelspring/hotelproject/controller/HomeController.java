package hotelspring.hotelproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// 응답을 받거나 준다
@Controller
public class HomeController {

    // 홈
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // 호텔 찾기
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }


}

