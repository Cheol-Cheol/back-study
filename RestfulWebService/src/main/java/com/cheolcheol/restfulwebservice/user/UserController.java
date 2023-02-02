package com.cheolcheol.restfulwebservice.user;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@Data
public class UserController {
    private UserDaoService service;

    // 생성자 의존성 주입
    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    @Operation(summary = "retrieveAllUsers", description = "전체 사용자 리스트를 조회합니다.")
    public List<UserDomain> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    @Operation(summary = "retrieveUser", description = "단일 사용자 정보를 조회합니다.")
    public EntityModel<UserDomain> retrieveUser(@PathVariable int id) {
        UserDomain user = service.findOne(id);

        // 예외 처리
        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        // HATEOAS
        EntityModel<UserDomain> model = EntityModel.of(user);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        model.add(linkTo.withRel("all-users"));

        return model;
    }

    @PostMapping("/users")
    @Operation(summary = "createUser", description = "사용자 정보를 추가합니다.")
    public ResponseEntity<UserDomain> createUser(@Valid @RequestBody UserDomain user) {
        UserDomain savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build(); // status code -> 201 Created (GET의 200과 구분)
    }

    @DeleteMapping("/users/{id}")
    @Operation(summary = "deleteUser", description = "사용자 정보를 삭제합니다.")
    public void deleteUser(@PathVariable int id) {
        UserDomain user = service.deleteById(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
    }
}
