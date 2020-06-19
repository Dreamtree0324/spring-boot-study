package com.study.webservice.web;

import com.study.webservice.service.PostsService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }

    @GetMapping("/detail/{id}")
    public String postDetail(@PathVariable Long id,
                             Model model) throws NotFoundException {
        model.addAttribute("post", postsService.detailPost(id));
        return "detail";
    }

}
