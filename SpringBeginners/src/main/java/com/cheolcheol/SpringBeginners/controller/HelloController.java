package com.cheolcheol.SpringBeginners.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    // 템플릿 엔진을 사용한 방법1
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring!!");
        return "hello";
    }

    // 템플릿 엔진을 사용한 방법2, (url) Request-parameter 값 받기
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API 방법1, 오직 문자 데이터만 전달하는 방법
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        // 응답 Body 에 해당 데이터를 넣을 것이다.
        return "hello " + name;
    }

    // API 방법2, JSON 데이터를 전달하는 방법
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        // 3. 객체 생성
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    // 1. 클래스 안에서 또 다른 클래스 선언
     static class Hello{
        private String name;
        // 2. getter, setter 생성 = property 접근 방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
