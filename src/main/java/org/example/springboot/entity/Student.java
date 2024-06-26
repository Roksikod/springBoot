package org.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "students")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "email")
    String email;

    @Column(name = "nick_tg")
    String nickTg;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "city")
    String city;

    @Column(name = "age")
    Integer age;

    @JsonIgnoreProperties(value="lessonStudents")
    @ManyToMany
    @JoinTable(name= "student_lesson",
            joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "studentId")},
            inverseJoinColumns = {
            @JoinColumn(name = "lesson_id", referencedColumnName = "lessonId")
    })
    List<Lesson> studentLessons;
}
