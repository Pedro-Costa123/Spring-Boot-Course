package com.pedro.cruddemo;

import com.pedro.cruddemo.dao.StudentDAO;
import com.pedro.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);
            createMultipleStudents(studentDAO);
            //readStudent(studentDAO);
            //queryForStudents(studentDAO);
            //queryForStudentsByLastName(studentDAO);
            //updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            //deleteAllStudents(studentDAO);
        };

    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        System.out.println("Rows deleted: " + studentDAO.deleteAll());
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student student = studentDAO.findById(studentId);

        System.out.println("Updating student");
        student.setFirstName("João");
        studentDAO.update(student);

        System.out.println("Updated student: " + student);

    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("Costa");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Pedro", "Costa", "1234@gmail.com");

        //save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        //display id of the saved student
        System.out.println("Saved student. Id: " + tempStudent.getId());

        //retrieve student base on id
        Student student = studentDAO.findById(tempStudent.getId());
        System.out.println("Found the student: " + student);

    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        for (int i = 0; i < 3; i++) {
            //create the student object
            System.out.println("Creating new student object ...");
            Student tempStudent = new Student(i + "Pedro", i + "Costa", i + "1234@gmail.com");

            //save the student object
            System.out.println("Saving the student ...");
            studentDAO.save(tempStudent);

            //display id of the saved student
            System.out.println("Saved student. Id: " + tempStudent.getId());
        }
    }

    private void createStudent(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Pedro", "Costa", "1234@gmail.com");

        //save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        //display id of the saved student
        System.out.println("Saved student. Id: " + tempStudent.getId());

    }

}
