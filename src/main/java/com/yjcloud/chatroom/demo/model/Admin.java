package com.yjcloud.chatroom.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = 3939617782363697106L;
    private String name;
    private String psw;
}
