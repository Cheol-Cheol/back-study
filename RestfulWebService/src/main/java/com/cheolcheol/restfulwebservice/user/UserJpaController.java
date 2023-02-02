package com.cheolcheol.restfulwebservice.user;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/users")
    public List<UserDomain> retrieveAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public UserDomain retrieveUser(@PathVariable int id) {
        Optional<UserDomain> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        return user.get();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDomain> createUser(@Valid @RequestBody UserDomain user) {
        UserDomain savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{id}/posts")
    public List<PostDomain> retrieveAllPostsByUser(@PathVariable int id) {
        Optional<UserDomain> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        return user.get().getPosts();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<PostDomain> createPost(@PathVariable int id, @RequestBody PostDomain post) {
        Optional<UserDomain> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        post.setUser(user.get());
        PostDomain savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
