package com.study.webservice.service;

import com.study.webservice.domain.posts.Posts;
import com.study.webservice.domain.posts.dto.PostSaveRequestDTO;
import com.study.webservice.domain.posts.PostsRepository;
import com.study.webservice.domain.posts.dto.PostsMainResponseDTO;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDTO postSaveRequestDTO){
        return postsRepository.save(postSaveRequestDTO.toEntity()).getId();
    }

    @Transactional
    public List<PostsMainResponseDTO> findAllDesc(){
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deletePosts(Long id){
        postsRepository.deleteById(id);
    }

    public Posts detailPost(Long id) throws NotFoundException {
        return postsRepository.findById(id).orElseThrow(() -> new NotFoundException("해당하는 idx의 게시글이 없습니다."));
    }
}
