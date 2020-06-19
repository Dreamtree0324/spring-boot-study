package com.study.webservice.web;

import com.study.webservice.domain.posts.PostSaveRequestDTO;
import com.study.webservice.domain.posts.PostsRepository;
import com.study.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello, World!!";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostSaveRequestDTO postSaveRequestDTO){
        postsService.save(postSaveRequestDTO);
    }
}
