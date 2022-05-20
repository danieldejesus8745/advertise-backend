package com.advertise.controllers;

import com.advertise.dto.PostDTO;
import com.advertise.services.PostService;
import com.advertise.services.TokenService;
import com.advertise.utils.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/posts")
public class PostController {

    private final PostService postService;
    private final TokenService tokenService;

    @PostMapping
    public ResponseModel addPost(@RequestHeader("Authorization") String token, @RequestBody PostDTO postDTO) {
        tokenService.validateToken(UUID.fromString(token));
        return postService.addPost(token, postDTO);
    }

    @GetMapping(path = "/your-posts")
    public List<PostDTO> getPostsByUuid(@RequestHeader("Authorization") String token) {
        tokenService.validateToken(UUID.fromString(token));
        return postService.getPostsByUuid(token);
    }

    @GetMapping
    public List<PostDTO> getAllPosts(@RequestHeader("Authorization") String token) {
        tokenService.validateToken(UUID.fromString(token));
        return postService.getAllPosts();
    }

}
