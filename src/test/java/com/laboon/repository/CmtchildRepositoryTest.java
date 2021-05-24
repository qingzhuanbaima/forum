package com.laboon.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CmtchildRepositoryTest {
    @Autowired
    CmtchildRepository cmtchildRepository;

    @Test
    void cc(){
        System.out.println(cmtchildRepository.findAll());
        System.out.println(cmtchildRepository.findAllByCmtId(52));
    }

}