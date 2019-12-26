package com.education.edu.pojo;

import lombok.Data;
/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/10/010 8:50
 * @descriptio 用户
 */
@Data
public class User {
    private Integer user_id;
    private String user_name;
    private String password;
    private String username;
    private Integer r_id;

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", r_id=" + r_id +
                '}';
    }
}
