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

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;

    public ResponseModel addPost(String token, PostDTO postDTO) {
        UUID ownerByToken = getOwnerByToken(token);

        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setOwner(ownerByToken);
        post.setCreatedAt(LocalDate.now());

        postRepository.save(post);

        return new ResponseModel(200, Messages.MESSAGE_3.getDescription());
    }

    private UUID getOwnerByToken(String token) {
        Token tokenFound = tokenRepository.findByUuid(UUID.fromString(token)).orElse(null);

        if (Objects.nonNull(tokenFound)) {
            return tokenFound.getOwner();
        } else {
            throw new IllegalStateException(Messages.MESSAGE_1.getDescription());
        }
    }

    public List<PostDTO> getPostsByUuid(UUID uuid) {
        List<Post> posts = postRepository.findAllByOwner(uuid).orElse(null);

        if (Objects.isNull(posts)) {
            throw new IllegalStateException(Messages.MESSAGE_2.getDescription());
        }

        return postMapper.listPostToListPostDTO(posts);
    }

}
