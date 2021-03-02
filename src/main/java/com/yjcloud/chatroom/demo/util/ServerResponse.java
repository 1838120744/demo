package com.yjcloud.chatroom.demo.util;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author qyw
 * @Description 服务响应通用对象
 * @Date Created in 20:51 2019/5/27
 * 杭州云嘉云计算公司
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "ServerResponse", description = "服务端通用响应对象")
public class  ServerResponse<T> implements Serializable {

    private static final long serialVersionUID = -206696267977993096L;

    @ApiModelProperty(required = true, value = "响应码")
    private  int code;
    @ApiModelProperty(required = false, value = "响应消息")
    private  String msg;
    @ApiModelProperty(required = false, value = "响应数据对象")
    private  T data;
    @ApiModelProperty(required = false, value = "数据长度")
    private  Long count;

    private ServerResponse(int code) {
        this.code = code;
    }
    private ServerResponse(String msg) {
        this.msg = msg;
    }
    private ServerResponse(T data) {
        this.data = data;
    }

    private ServerResponse(int code,String msg) {
        this.code=code;
        this.msg = msg;
    }
    private ServerResponse(int code,T data) {
        this.code=code;
        this.data = data;
    }

    private ServerResponse(int code,T data,Long count) {
        this.count=count;
        this.data = data;
        this.code=code;
    }

    private ServerResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }


    @JsonIgnore
    public  boolean isSuccess(){
        return  this.code == ServerCodeEnum.SUCCESS.code();
    }

    public  static <T> ServerResponse<T> success(){
        return  new ServerResponse<>(ServerCodeEnum.SUCCESS.code());
    }

    public  static <T> ServerResponse<T> success(String msg){
        return  new ServerResponse<>(ServerCodeEnum.SUCCESS.code(),msg);
    }

    public  static <T> ServerResponse<T> success(T data){
        return  new ServerResponse<>(ServerCodeEnum.SUCCESS.code(),data);
    }

    public  static <T> ServerResponse<T> success(String msg,T data){
        return  new ServerResponse<>(ServerCodeEnum.SUCCESS.code(),msg,data);
    }
    //添加 layuitable
    public static <T> ServerResponse<T> layui (T data,Long count) {
        return  new ServerResponse<>(0,data,count);
    }

    public  static <T> ServerResponse<T> fail(String failMsg,T data){
        return  new ServerResponse<>(ServerCodeEnum.ERROR.code(),failMsg,data);
    }

    public  static <T> ServerResponse<T> fail(){
        return  new ServerResponse<>(ServerCodeEnum.ERROR.code(), ServerCodeEnum.ERROR.desc());
    }

    public  static <T> ServerResponse<T> fail(String failMsg){
        return  new ServerResponse<>(ServerCodeEnum.ERROR.code(),failMsg);
    }


    public  static <T> ServerResponse<T> fail(int code,String failMsg){
        return  new ServerResponse<>(code,failMsg);
    }


    public  static <T> ServerResponse<T> fail(int code,String failMsg,T date){
        return  new ServerResponse<>(code,failMsg,date);
    }

    public  static <T> ServerResponse<T> init(){
        return  new ServerResponse<>(ServerCodeEnum.INIT.code());
    }


    public  static <T> ServerResponse<T> empty(String failMsg){
        return  new ServerResponse<>(ServerCodeEnum.EMPTY.code(),failMsg);
    }

    public  static <T> ServerResponse<T> forbidden(){
        return  new ServerResponse<>(ServerCodeEnum.UN_AUTHORIZED.code(), ServerCodeEnum.UN_AUTHORIZED.desc());
    }

    public  static <T> ServerResponse<T> illegalArguments(){
        return  new ServerResponse<>(ServerCodeEnum.ILLEGAL_ARGUMENTS.code(), ServerCodeEnum.ILLEGAL_ARGUMENTS.desc());
    }

    public  static <T> ServerResponse<T> illegalArguments(String failMsg){
        return  new ServerResponse<>(ServerCodeEnum.ILLEGAL_ARGUMENTS.code(),failMsg);
    }
}
