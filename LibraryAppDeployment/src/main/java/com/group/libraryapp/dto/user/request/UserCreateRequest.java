package com.group.libraryapp.dto.user.request;

public class UserCreateRequest {
    private String name;
    private Integer age;
    // int: NULL을 표현할 수 없다. Integer: NULL을 표현할 수 있다. (요구사항: 나이는 선택)

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
