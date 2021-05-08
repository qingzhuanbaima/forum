package com.laboon.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Cmt2cmt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //自增
    private Integer c2cId;

    private Integer cId;

    private Integer aId;

    private String username;

    private String cmtChildren;

    private String reply_time;
}
