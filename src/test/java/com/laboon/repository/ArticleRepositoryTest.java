package com.laboon.repository;

import com.laboon.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void findAll(){
        System.out.println(articleRepository.findAll());
    }

    @Test
    void test(){
        Article article=articleRepository.findByUsername("qqqq");
        System.out.println(article.toString());
    }

    @Test
    void test1(){
        System.out.println(articleRepository.findAllByUsername("laboon"));
    }

    @Test
    public void updatestar(){
        articleRepository.updateStarById(3);
    }

}