package com.advertise.mappers;

import com.advertise.dto.PostDTO;
import com.advertise.entities.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostMapper {

    public List<PostDTO> listPostToListPostDTO(List<Post> posts) {
        ArrayList<PostDTO> postsDTO = new ArrayList<>();

        for (Post post : posts) {
            postsDTO.add(toDto(post));
        }

        return postsDTO;
    }

    private PostDTO toDto(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setUuid(post.getUuid());
        postDTO.setTitle(post.getTitle());
        postDTO.setDescription(post.getDescription());
        postDTO.setOwner(post.getOwner());
        postDTO.setCreatedAt(post.getCreatedAt());
        postDTO.setCity(post.getCity());
        postDTO.setState(post.getState());

        return postDTO;
    }

}
