package com.example.ajaxsample.controller;

import com.example.ajaxsample.domain.Member;
import com.example.ajaxsample.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/member")
@ResponseBody
public class MemberRestController {

    @Autowired
    private MemberRepository repository;

    @PostMapping("/idcheck")
    public boolean idcheck(String email) {
        log.debug("email: {}", email);

        Optional<Member> member = repository.findById(email);
        // null인지 아닌지 check
        log.debug("result: {}", member.isPresent());

        return member.isPresent();
    }
}
