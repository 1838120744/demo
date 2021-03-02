package com.yjcloud.chatroom.demo.model;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Teacher implements Serializable {
    private static final long serialVersionUID = -5840061270128800435L;
    @NotNull
    private String name;
    @NotNull
    private String psw;
    private Integer id;
}
