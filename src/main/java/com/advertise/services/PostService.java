package com.advertise.services;

import com.advertise.dto.PostDTO;
import com.advertise.entities.Post;
import com.advertise.entities.Token;
import com.advertise.entities.User;
import com.advertise.mappers.PostMapper;
import com.advertise.repositories.PostRepository;
import com.advertise.repositories.TokenRepository;
import com.advertise.repositories.UserRepository;
import com.advertise.utils.Messages;
import com.advertise.utils.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static com.advertise.utils.Messages.*;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;

    public ResponseModel addPost(String token, PostDTO postDTO) {
        User userFound = getOwnerByToken(token);

        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setOwner(userFound.getUuid());
        post.setCreatedAt(LocalDate.now());
        post.setCity(userFound.getCity());
        post.setState(userFound.getState());

        postRepository.save(post);

        return new ResponseModel(200, MESSAGE_3.getDescription());
    }

    private User getOwnerByToken(String token) {
        Token tokenFound = tokenRepository.findByUuid(UUID.fromString(token)).orElse(null);

        if (Objects.nonNull(tokenFound)) {
            User user = userRepository.findByUuid(tokenFound.getOwner()).orElse(null);
            if (Objects.nonNull(user)) {
                return user;
            } else {
                throw new IllegalStateException(MESSAGE_4.getDescription());
            }
        } else {
            throw new IllegalStateException(MESSAGE_1.getDescription());
        }
    }

    public List<PostDTO> getPostsByUuid(String token) {
        User userFoundByToken = getOwnerByToken(token);
        List<Post> posts = postRepository.findAllByOwner(userFoundByToken.getUuid()).orElse(null);

        if (Objects.isNull(posts)) {
            throw new IllegalStateException(MESSAGE_2.getDescription());
        }

        return postMapper.listPostToListPostDTO(posts);
    }

    public List<PostDTO> getAllPosts() {
        return postMapper.listPostToListPostDTO(postRepository.findAll());
    }
}
