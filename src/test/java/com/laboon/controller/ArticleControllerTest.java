package com.laboon.controller;

import com.laboon.entity.Article;
import com.laboon.utils.img.dao.ImgBase64;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class ArticleControllerTest {

    @Autowired
    ArticleController articleController;

    ImgBase64 imgBase64;


    @Test
    void findbylab() {
        System.out.println(articleController.findAllByLabel("运动"));
    }

    @Test
    void star() {
        articleController.starClick(20);
    }

    @Test
    void articalImg() {
        Article article = new Article();
        ArrayList<ImgBase64> imgBase64List = new ArrayList<ImgBase64>();


        ImgBase64 imgBase641 = new ImgBase64();
        imgBase641.setImgid("0.112555155");
        imgBase641.setImgsrc("ashdgjkahbjnasdyvjhba");
        ImgBase64 imgBase642 = new ImgBase64();
        imgBase642.setImgid("0.5854565");
        imgBase642.setImgsrc("as5d56sad25asd56sa65a5a23");

        try {
            imgBase64List.add(imgBase641);
            imgBase64List.add(imgBase642);
            System.out.println(imgBase64List);
        } catch (Exception e) {
            e.printStackTrace();
        }
        article = articleController.findById(36);
        article.setId(null);
        ArrayList<String> stringList = new ArrayList<>();
        for (ImgBase64 imgBase64 : imgBase64List) {
            stringList.add(imgBase64.getImgid());
        }
        System.out.println(stringList);
        System.out.println(stringList.toString());

//        articleController.articlePost(article, imgBase64List);
    }

    @Test
    void img2BaseTest() {

    }

    @Test
    void sendimg64() {
        System.out.println(articleController.sendImg("396ce23e-769d-4b58-9d85-580192bd6cda"));
    }
}