package com.yuna.demo;

import com.yuna.entity.Student;
import com.yuna.entity.Teacher;

import com.yuna.repostitory.StudentRepostitory;
import com.yuna.repostitory.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private StudentRepostitory studentRepostitory;

    @Autowired
    private TeacherRepository teacherRepository;

    /**
     * 增加
     */
    @PostMapping("/insert")
    public Teacher insertTeacher(@RequestBody Teacher teacher) {

        return teacherRepository.save(teacher);
    }

    /**
     * 更改
     */
    @PutMapping("/update")
    public Teacher updateDepartment(@RequestBody Teacher teacher) {

        return teacherRepository.save(teacher);
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteDepartment(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();

        List<Student> studentsByTeacherId = studentRepostitory.getStudentsByTeacherId(id);
        if (studentsByTeacherId.size() == 0) {
            teacherRepository.deleteById(id);
            map.put("status", true);
        } else {
            map.put("status", false);
        }
        return map;
    }

    /**
     * 查询所有
     */
    @GetMapping("/all")
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    /**
     * 查单个
     */
    @GetMapping("/get/{id}")
    public Teacher getDepartmentById(@PathVariable Integer id) {

        return teacherRepository.findById(id).get();
    }
}
