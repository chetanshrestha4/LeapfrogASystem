/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.LFASystem.DAO;

import com.leapfrog.LFASystem.entity.Student;
import java.util.List;

/**
 *
 * @author Chetan
 */
public interface StudentDAO {
   
    List<Student> getAll();
    Student getById(int id);
    int insert(Student s);
    int count();
    int update(Student s);
    int delete(int id);
    List<Student> search(String param);
    
}
