package com.yjcloud.chatroom.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChatMessage implements Serializable {
    private static final long serialVersionUID = -1817185990326243660L;
    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}

