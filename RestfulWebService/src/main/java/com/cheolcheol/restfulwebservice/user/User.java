package com.cheolcheol.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
// @JsonFilter("UserInfo")
@Schema(description = "사용자 상세 정보를 위한 도메인 객체")
public class User {
    private Integer id;
    @Size(min = 2, message = "Name은 2글자 이상 입력해 주세요!")
    @Schema(description = "사용자 이름을 입력해 주세요.")
    private String name;
    @Past
    @Schema(description = "사용자 등록일을 입력해 주세요.")
    private Date joinDate;
    @Schema(description = "사용자 패스워드를 입력해 주세요.")
    private String password;
    @Schema(description = "사용자 주민민호를 입력해 주세요.")
    private String ssn;
}
