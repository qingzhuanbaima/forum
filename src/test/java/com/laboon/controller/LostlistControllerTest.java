package com.laboon.controller;

import com.laboon.entity.Lostlist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LostlistControllerTest {

    @Autowired
    LostController lostController;

    @Test
    void addlost(){
        Lostlist lostlist =new Lostlist();

        lostlist.setLostname("眼镜");
        lostlist.setDescri("眼镜丢失了");
        lostlist.setLost_time("2021-5-10 18:25:30");
        lostlist.setConnect("123456");
        System.out.println(lostlist);
        System.out.println(lostController.lostPost(lostlist));
    }
}