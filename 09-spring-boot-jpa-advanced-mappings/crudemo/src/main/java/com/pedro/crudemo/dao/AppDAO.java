package com.pedro.crudemo.dao;

import com.pedro.crudemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

}
