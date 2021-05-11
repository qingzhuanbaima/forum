package com.laboon.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class Lostlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //自增
    private Integer lid;

    /**
     * 失物名称
     */
    private String lostname;

    /**
     * 失物描述
     */
    private String descri;

    /**
     * 联系方式
     */
    private String connect;

    /**
     * 发布时间
     */
    private String lost_time;

}
