package com.laboon.controller;

import com.laboon.entity.Comments;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommentsControllerTest {
    @Autowired
    CommentsController commentsController;

    @Test
    void showComt() {
        System.out.println(commentsController.finAllById(4));
    }

    @Test
    void addcmt(){
        Comments comment=new Comments();
        comment.setAid(4);
        comment.setUsername("ming");
        comment.setReplytime("2021-04-14 00:36:16");
        comment.setComment("，都是马甲看到阿克江看到绿卡麻辣空间拉客的美女看阿卡你");
        System.out.println(comment);
        System.out.println(commentsController.addComment(comment));
    }
}