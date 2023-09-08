package com.example.JavaSpringPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller                                     //컨트롤러 선언
public class FirstController {
    @GetMapping("/hi")                          //URL 요청 접수
    public String niceToMeetYou(Model model){   //매서드 수행 및 모델 객체 가져오기
        model.addAttribute("username","의찬");    // 모델 변수 등록
        return "greetings";                     //뷰 템플릿 페이지 반환
    }


    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname","euichan");
        return "goodbye";
    }
}


