package com.laboon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
 * @since 2021-05-24
 */
@Entity
@Data

public class Cmtchild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //自增
    private Integer ccId;

    /**
     * 回复的评论的id
     */
    private Integer cmtId;

    private String username;

    /**
     * 回复的内容
     */
    private String cmtChildren;

    private String replyTime;


}
