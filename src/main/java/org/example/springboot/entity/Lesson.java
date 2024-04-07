package org.example.springboot.entity;

@Getter
@Setter
@Entity
@Table(name = "courses")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title_course")
    String titleCourse;
}
