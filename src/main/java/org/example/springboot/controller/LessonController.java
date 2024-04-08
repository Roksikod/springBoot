package org.example.springboot.controller;

import org.example.springboot.entity.Lesson;
import org.example.springboot.entity.Student;
import org.example.springboot.repository.LessonRepo;
import org.example.springboot.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lessons")
public class LessonController {
    @Autowired
    private LessonRepo lessonRepo;

    @GetMapping("/all")
    public List<Lesson> getAll(){
        return lessonRepo.findAll();
    }

    @PostMapping
    public Lesson addLesson(@RequestBody Lesson lesson){
        return lessonRepo.save(lesson);
    }
}
