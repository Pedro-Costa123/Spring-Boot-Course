package com.pedro.crudemo.dao;

import com.pedro.crudemo.entity.Course;
import com.pedro.crudemo.entity.Instructor;
import com.pedro.crudemo.entity.InstructorDetail;
import com.pedro.crudemo.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewsByCourse(int id);

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentAndCourseByStudentId(int id);

    void update(Student student);

    void deleteStudentById(int id);

}
