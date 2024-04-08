package org.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lessons")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int lessonId;

    @Column(name = "title_lesson")
    String titleLesson;

    @JsonIgnoreProperties(value = "studentLessons")
    @ManyToMany(mappedBy = "studentLessons")
    List<Student> lessonStudents;

}
