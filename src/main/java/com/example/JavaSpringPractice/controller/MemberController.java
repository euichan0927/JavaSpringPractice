package com.example.JavaSpringPractice.controller;

import com.example.JavaSpringPractice.dto.MemberForm;
import com.example.JavaSpringPractice.entity.Member;
import com.example.JavaSpringPractice.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUpPage()
    {
        return "members/new";
    }
    @PostMapping("/join")
    public String createUser(MemberForm memberForm){
        Member member = memberForm.toEntity();
        Member saved = memberRepository.save(member);

        return "";
    }
}
