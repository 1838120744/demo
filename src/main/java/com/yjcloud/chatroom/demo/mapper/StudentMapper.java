package com.yjcloud.chatroom.demo.mapper;

import com.yjcloud.chatroom.demo.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    public int addStudent(Student student);
    public int deleteStudentById(Integer id);
    public int updateStudent(Student student);
    public List<Student> findAll();
    public List<Student> findByIdLike(String id);
    public Student findById(int id);
}
