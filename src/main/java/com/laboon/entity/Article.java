package com.laboon.entity;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data

public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //自增
    private Integer id;

    private String username;

    private String title;

    private String content;

    private String article_time;

    private String club;

    private String label;

    @Column(insertable = false, columnDefinition = "int default 0")
    private Integer star;

    @Column(insertable = false, columnDefinition = "int default 0")
    private Integer comment;

}
