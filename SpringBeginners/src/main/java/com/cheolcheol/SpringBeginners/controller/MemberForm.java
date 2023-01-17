package com.cheolcheol.SpringBeginners.controller;

public class MemberForm {
    // 회원가입 화면에서 입력한 name 값을 spring 이 setName 을 호출해서 값이 들어간다.
    // MemberForm 은 [GET] createForm 과 [POST] create 의 중간에 위치해서 데이터를 전달해주는 느낌?
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
