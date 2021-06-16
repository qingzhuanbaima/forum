package com.laboon.repository;

import com.laboon.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

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

    @Test
    public void search(){
//        List<Article> articleList=articleRepository.findAllByUsernameLikeOrTitleLikeOrContentLike("%测试%","%测试%","%测试%");
//        for (Article article:articleList
//             ) {
//            System.out.println(article);
//        }
    }
}