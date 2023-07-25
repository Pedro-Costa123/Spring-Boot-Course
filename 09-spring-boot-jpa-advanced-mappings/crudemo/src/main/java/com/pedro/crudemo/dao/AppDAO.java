package com.pedro.crudemo.dao;

import com.pedro.crudemo.entity.Instructor;
import com.pedro.crudemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

}
