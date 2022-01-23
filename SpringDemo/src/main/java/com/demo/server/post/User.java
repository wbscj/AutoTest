package com.demo.server.post;

import lombok.Data;

@Data
public class User {
    public String username;
    private String password;
    private Integer age;

}
