package com.yjcloud.chatroom.demo.util;

/**
 * @Author qyw
 * @Description 服务响应通用枚举
 * @Date Created in 20:51 2020/02/10
 * 杭州云嘉云计算公司
 **/
public enum ServerCodeEnum {
    SUCCESS(1,"SUCCESS"),
    INIT(-1,"初始化"),
    ERROR(99,"ERROR"),
    EMPTY(0,"内容为空"),
    NEED_LOGIN(2,"需要登录"),
    UN_AUTHORIZED(403,"UN_AUTHORIZED"),
    ILLEGAL_ARGUMENTS(3,"参素错误"),
    UNKNOW_EXCEPTION(4,"未知异常");

    private final int code;
    private final String desc;

    ServerCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int code() {
        return code;
    }

    public String desc() {
        return desc;
    }
}
