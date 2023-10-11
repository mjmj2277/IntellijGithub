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

    // 호텔 소개
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    // 호텔 소개 - 객실 정보
    @GetMapping("/room")
    public String room() {
        return "room";
    }

    // 객실 정보 - 디테일
    @GetMapping("/room_details/GrandDeluxe")
    public String GrandDeluxe(){
        return "/room_details/GrandDeluxe";
    }
    // 객실 정보 - 디테일
    @GetMapping("/room_details/Premier")
    public String Premier(){
        return "/room_details/Premier";
    }
    // 객실 정보 - 디테일
    @GetMapping("/room_details/PresidentialSuite")
    public String PresidentialSuitePr(){
        return "/room_details/PresidentialSuite";
    }
    // 객실 정보 - 디테일
    @GetMapping("/room_details/RoyalSuite")
    public String RoyalSuite(){
        return "/room_details/RoyalSuite";
    }

    @GetMapping("/reservation")
    public String reservation(){
        return "/reservation";
    }

    @GetMapping("/room_search")
    public String roomSearch(){
        return "/room_search";
    }

    @GetMapping("/tempt")
    public String tempt(){
        return "/tempt";
    }


}

