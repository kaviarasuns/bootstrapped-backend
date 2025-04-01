package com.kaviarasu.bootstrapped_backend.Q43.models;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher_rating")  // Changed back to students_teachers
public class TeacherRating {
    @EmbeddedId
    private TeacherRatingId id = new TeacherRatingId();

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("teacherId")
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "rating")
    private int rating;

    public TeacherRating() {}

    public TeacherRating(Student student, Teacher teacher, int rating) {
        this.student = student;
        this.teacher = teacher;
        this.rating = rating;
        this.id = new TeacherRatingId(student.getId(), teacher.getId());
    }

    public TeacherRatingId getId() { return id; }
    public void setId(TeacherRatingId id) { this.id = id; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}