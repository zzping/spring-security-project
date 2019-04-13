package com.imooc.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Trig
 * @create 2019-04-12 23:06
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -5938895711036110482L;
    private String username;
    private String password;
}
