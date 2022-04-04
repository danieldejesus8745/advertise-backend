package com.advertise.controllers;

import com.advertise.dto.PostDTO;
import com.advertise.services.PostService;
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

    @PostMapping
    public ResponseModel addPost(@RequestBody PostDTO postDTO) {
        return postService.addPost(postDTO);
    }

    @GetMapping(path = "/{uuid}")
    public List<PostDTO> getAllPostsByUuid(@PathVariable("uuid") UUID uuid) {
        return postService.getAllPostsByUuid(uuid);
    }

}
