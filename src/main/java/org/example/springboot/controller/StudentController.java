package org.example.springboot.controller;

import org.example.springboot.entity.Lesson;
import org.example.springboot.entity.Student;
import org.example.springboot.repository.LessonRepo;
import org.example.springboot.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    LessonRepo lessonRepo;

    @GetMapping("/all")
    public List<Student> getAll() {
        return studentRepo.findAll();
    }
    @GetMapping("/{id}")
    public Student getStudent(@RequestParam int studentId) {
        return studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student was not found"));
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    @PutMapping("/student-has-lessons")
    public Student updateStudent(@RequestParam int studentId, @RequestParam int lessonId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student was not found"));
        Lesson lesson = lessonRepo.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson was not found"));
        student.getStudentLessons().add(lesson);
        return studentRepo.save(student);
    }
}
