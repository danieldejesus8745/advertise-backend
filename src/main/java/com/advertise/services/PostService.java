package com.advertise.services;

import com.advertise.dto.PostDTO;
import com.advertise.entities.Post;
import com.advertise.repositories.PostRepository;
import com.advertise.utils.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public ResponseModel addPost(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setPostDesc(postDTO.getPostDesc());
        post.setOwner(postDTO.getOwner());
        post.setCreatedAt(LocalDate.now());

        postRepository.save(post);

        return new ResponseModel(200, "Novo post adicionado com sucesso");
    }

}
