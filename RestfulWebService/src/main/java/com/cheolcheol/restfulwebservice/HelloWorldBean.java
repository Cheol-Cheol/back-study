package com.cheolcheol.restfulwebservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// [lombok] Bean 클래스를 만들 때 세터&게터, 생성자, toString, equals 같은 메서드를 자동으로 생성하는 기능이 포함되어 있다.
// @Data: @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor 모두를 자동으로 적용한다.
// @AllArgsConstructor: 생성자를 자동으로 만들어준다.
// @NoArgsConstructor: 기본 생성자를 자동으로 만들어준다.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelloWorldBean {
    private String message;
}
