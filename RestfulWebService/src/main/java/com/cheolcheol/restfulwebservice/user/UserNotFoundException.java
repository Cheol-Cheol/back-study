package com.cheolcheol.restfulwebservice.user;

// HTTP Status code
// 2XX -> OK
// 4XX -> Client 잘못
// 5XX -> Server 잘못

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
// 5XX 에러가 아니라 404 오류라고 전달할 수 있음 (데이터 부재로 인한 오류)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
