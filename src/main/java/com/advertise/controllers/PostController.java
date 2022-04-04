package com.advertise.controllers;

import com.advertise.dto.PostDTO;
import com.advertise.services.PostService;
import com.advertise.utils.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseModel addPost(@RequestBody PostDTO postDTO) {
        return postService.addPost(postDTO);
    }

}