package com.advertise.services;

import com.advertise.dto.PostDTO;
import com.advertise.entities.Post;
import com.advertise.mappers.PostMapper;
import com.advertise.repositories.PostRepository;
import com.advertise.utils.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public ResponseModel addPost(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setOwner(postDTO.getOwner());
        post.setCreatedAt(LocalDate.now());

        postRepository.save(post);

        return new ResponseModel(200, "Novo post adicionado com sucesso");
    }

    public List<PostDTO> getAllPostsByUuid(UUID uuid) {
        List<Post> posts = postRepository.findAllByOwner(uuid).orElse(null);

        if (Objects.isNull(posts)) {
            throw new IllegalStateException("Nenhum post encontrado");
        }

        return postMapper.listPostToListPostDTO(posts);
    }

}
