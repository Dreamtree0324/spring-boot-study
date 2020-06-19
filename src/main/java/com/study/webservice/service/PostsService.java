package com.study.webservice.service;

import com.study.webservice.domain.posts.PostSaveRequestDTO;
import com.study.webservice.domain.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDTO postSaveRequestDTO){
        return postsRepository.save(postSaveRequestDTO.toEntity()).getId();
    }
}
