package com.yjcloud.chatroom.demo.mapper;

import com.yjcloud.chatroom.demo.model.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
    public int addTeacher(Teacher teacher);
    public int deleteTeacher(Integer id) ;
    public int updateTeacher(Teacher teacher);
    public List<Teacher> findAll();
    public List<Teacher> findByIdLike(String id);
    public Teacher findById(Integer id);
}
