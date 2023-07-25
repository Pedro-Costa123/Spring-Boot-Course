package com.pedro.crudemo;

import com.pedro.crudemo.dao.AppDAO;
import com.pedro.crudemo.entity.Instructor;
import com.pedro.crudemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
            deleteInstructor(appDAO);
        };
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 2;
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
