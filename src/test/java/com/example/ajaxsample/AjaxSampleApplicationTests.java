package com.example.ajaxsample;

import com.example.ajaxsample.domain.Member;
import com.example.ajaxsample.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class AjaxSampleApplicationTests {

    @Autowired
    private MemberRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    public void create() {
        Member member = new Member();
        member.setEmail("testId@test.com");
        member.setPassword("testPw123");

        Member newMember = repository.save(member);
    }

    @Test
    public void read() {
        Optional<Member> member = repository.findById("testId@test.com");

        /*
         * isPresent()
         * 현재 optional의 값이 null인지 확인한다.
         * if-else문을 사용하지 않고도 null값 존재 검사를 할 수 있다.
         */

        /*
         * ifPresent()
         * Optional의 값이 존재할 경우에만 실행될 로직이 함수의 인자로 전달된다.
         * 함수형 인자로 람다식이 넘어올 수 있다.
         */
        member.ifPresent(selectMember -> {
            System.out.println(selectMember.getEmail());
            System.out.println(selectMember.getPassword());
        });
    }
}
