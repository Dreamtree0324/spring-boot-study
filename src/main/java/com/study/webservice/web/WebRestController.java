package com.study.webservice.web;

import com.study.webservice.domain.posts.dto.PostSaveRequestDTO;
import com.study.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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

    @RequestMapping("/delete/{id}")
    public RedirectView deletePosts(@PathVariable Long id){
        postsService.deletePosts(id);

        return new RedirectView("/");
    }
}
