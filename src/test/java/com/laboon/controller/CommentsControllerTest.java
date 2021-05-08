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
        comment.setComment("ytuiajsgdjbdhiahanckahiuhdakndakbdjagvdjafkn");
        System.out.println(comment);
        System.out.println(commentsController.addComment(comment));
    }
}