package com.laboon.controller;


import com.laboon.entity.Article;
import com.laboon.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * @return+
     */
    @GetMapping("/findAll")
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    /**
     * 根据id找帖子
     *
     * @param id
     * @return
     */
    @GetMapping("/id")
    public Article findById(@RequestParam("id") Integer id) {
        return articleRepository.findById(id).get();
    }

    /**
     * 根据用户名查找帖子
     *
     * @param username
     * @return
     */
    @GetMapping("/user")
    public List<Article> finAllByUsername(@RequestParam("username") String username) {
        return articleRepository.findAllByUsername(username);
    }

    /**
     * 根据club找帖子
     *
     * @param club
     * @return
     */
    @GetMapping("/club")
    public List<Article> findAllByClub(@RequestParam("label")  String club) {
        return articleRepository.findAllByClub(club);
    }

    /**
     * 根据label找帖子
     *
     * @param label
     * @return
     */
    @GetMapping("/label")
    public List<Article> findAllByLabel(String label) {
        return articleRepository.findAllByLabel(label);
    }

    /**
     * 发表帖子
     *
     * @param article
     * @return
     */
    @PostMapping("/articlePost")
    public String articlePost(@RequestBody Article article) {
        Article result = articleRepository.save(article);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 点赞
     * @param id
     */
    @PostMapping("/star")
    public void starClick(int id){
        articleRepository.updateStarById(id);
    }
}
