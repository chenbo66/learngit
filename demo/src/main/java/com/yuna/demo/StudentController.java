package com.yuna.demo;

import com.yuna.entity.Teacher;
import com.yuna.entity.Student;
import com.yuna.repostitory.TeacherRepository;
import com.yuna.repostitory.StudentRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/student")

public class StudentController {

    @Autowired
    private StudentRepostitory studentRepostitory;

    @Autowired
    private TeacherRepository teacherRepository;

    /**
     * 增加
     */
    @PostMapping("/insert")
    public Student insertStudent(@RequestBody Student student) {

        return studentRepostitory.save(student);
    }

    /**
     * 增加
     */
    @PostMapping("/students")
    public List<Student> insertStudent() {
        Teacher teacher = new Teacher();
        teacher.setName("tea1");

        Student student = new Student();
        student.setName("stu1");
        student.setTeacher(teacher);

        Student student1 = new Student();
        student1.setName("skyline");
        student1.setTeacher(teacher);

        List<Student> students = Arrays.asList(student, student1);
        return studentRepostitory.saveAll(students);
    }


    /**
     * 根据id获取单个学生
     */
    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentRepostitory.findById(id).get();

    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable Integer id) {

        studentRepostitory.deleteById(id);
    }

    /**
     * 更改
     */
    @PutMapping("/update")
    public void updateStudent(Student student) {

        studentRepostitory.save(student);
    }

    /**
     * 获取所有
     */
    @GetMapping("/students")
    public List<Student> getStudent() {
        return studentRepostitory.findAll();
    }


    @GetMapping("/all")
    public List<Map<String, Object>> getAllStudent() {
        List<Student> studentList = studentRepostitory.findAll();
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            Map<String, Object> map1 = new HashMap<>();
            map1.put("student", studentList.get(i));
            map1.put("teacher", teacherRepository.findById(studentList.get(i).getId()));
            list.add(map1);
        }
            return list;
        }
    }



