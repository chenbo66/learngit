package com.yuna.repostitory;


import com.yuna.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepostitory extends JpaRepository<Student, Integer> {
    @Query(value = "select * from t_student where teacher_id=?1", nativeQuery = true)
    List<Student> getStudentsByTeacherId(Integer id);

}