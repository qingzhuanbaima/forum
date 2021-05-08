package com.laboon.entity;

import java.time.LocalDateTime;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <p>
 * 
 * </p>
 *
 * @author laboon
 * @since 2021-04-19
 */
@Entity
@Data
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //自增
    private Integer cid;

    private Integer aid;

    private String username;

    private String comment;

    private String replytime;


}
