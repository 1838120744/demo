package com.yjcloud.chatroom.demo.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class Student implements Serializable {
	private static final long serialVersionUID = 4096376950096875396L;
	private Integer id;
	@NotNull
	private String name;
	private Integer age;
	private String classroom;
	private String parent;
	@NotNull
	@Pattern(regexp = "[0-9]{11}", message = "请输入正确的电话号码")
	private String tel;
}
