package com.laboon.entity;

import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
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

public class User {

    @Id
    private String username;

    private String password;

    private String mail;

    private String tel;

    private String birthday;

    private String introduction;


}
