package com.pedro.crudemo;

import com.pedro.crudemo.dao.AppDAO;
import com.pedro.crudemo.entity.Course;
import com.pedro.crudemo.entity.Instructor;
import com.pedro.crudemo.entity.InstructorDetail;
import com.pedro.crudemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createInstructor(appDAO);
//            findInstructor(appDAO);
//            deleteInstructor(appDAO);
//            findInstructorDetail(appDAO);
//            deleteInstructorDetail(appDAO);
//            createInstructorWithCourses(appDAO);
//            findInstructorWithCourses(appDAO);
//            findCoursesForInstructor(appDAO);
//            findInstructorWithCoursesJoinFetch(appDAO);
//            updateInstructor(appDAO);
//            updateCourse(appDAO);
//            deleteInstructor(appDAO);
//            deleteCourse(appDAO);
//            createCourseAndReviews(appDAO);
//            retrieveCourseAndReviews(appDAO);
            deleteCourseAndReviews(appDAO);

        };
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int id = 10;
        System.out.println("Deleting course id: " + id);
        appDAO.deleteCourseById(id);
        System.out.println("done");
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseAndReviewsByCourse(id);
        System.out.println(course);
        System.out.println(course.getReviews());
        System.out.println("done");
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        Course course = new Course("React.js - 2023 Version");
        course.addReview(new Review("Greet Course 10/10 - 1"));
        course.addReview(new Review("Greet Course 10/10 - 2"));
        course.addReview(new Review("Greet Course 10/10 - 3"));
        course.addReview(new Review("Greet Course 10/10 - 4"));
        System.out.println("Saving course and reviews");
        System.out.println(course);
        System.out.println(course.getReviews());
        appDAO.save(course);
        System.out.println("done");
    }

    private void deleteCourse(AppDAO appDAO) {
        int id = 10;
        System.out.println("Deleting course id: " + id);
        appDAO.deleteCourseById(id);
        System.out.println("done");
    }

    private void updateCourse(AppDAO appDAO) {
        int id = 10;
        System.out.println("Finding course id: " + id);
        Course course = appDAO.findCourseById(id);
        System.out.println("Updating course id: " + id);
        course.setTitle("Test Update Title");
        appDAO.update(course);
        System.out.println("done");
    }

    private void updateInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Updating instructor id: " + id);
        instructor.setLastName("TESTER");
        appDAO.update(instructor);
        System.out.println("done");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);
        Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
        System.out.println(instructor);
        System.out.println("The Courses: " + instructor.getCourses());
        System.out.println("done");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);

        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println(instructor);

        System.out.println("Finding Courses for instructor id: " + id);
        List<Course> courses = appDAO.findCoursesByInstructorId(id);
        instructor.setCourses(courses);
        System.out.println("The Courses: " + instructor.getCourses());
        System.out.println("done");

    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);

        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println(instructor);
        System.out.println("The Courses: " + instructor.getCourses());
        System.out.println("done");

    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor instructor = new Instructor("Pedro 3", "Costa 3", "pedro@gmail.com 3");
        InstructorDetail instructorDetail = new InstructorDetail("http://localhost 3", "Programming 3");

        instructor.setInstructorDetail(instructorDetail);

        Course course = new Course("Spring Boot Guide 2023");
        Course course1 = new Course("React.js Guide 2023");

        instructor.add(course);
        instructor.add(course1);

        System.out.println("Saving instructor: " + instructor);
        System.out.println("The courses: " + instructor.getCourses());
        appDAO.save(instructor);
        System.out.println("done");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int id = 4;
        System.out.println("Deleting instructor detail id: " + id);
        appDAO.deleteInstructorDetailById(id);
        System.out.println("deleted");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor detail id: " + id);
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
        System.out.println("Instructor Detail: " + instructorDetail);
        System.out.println("Associated Instructor: " + instructorDetail.getInstructor());
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Deleting instructor id: " + id);
        appDAO.deleteInstructorById(id);
        System.out.println("deleted");
    }

    private void findInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);

        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Instructor: " + instructor);
        System.out.println("Details: " + instructor.getInstructorDetail());

    }

    private void createInstructor(AppDAO appDAO) {
//        Instructor instructor = new Instructor("Pedro", "Costa", "pedro@gmail.com");
//        InstructorDetail instructorDetail = new InstructorDetail("http://localhost", "Programming");
//        instructor.setInstructorDetail(instructorDetail);

        Instructor instructor = new Instructor("Pedro 2", "Costa 2", "pedro@gmail.com 2");
        InstructorDetail instructorDetail = new InstructorDetail("http://localhost 2", "Programming 2");
        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving instructor: " + instructor);
        appDAO.save(instructor);
    }

}
