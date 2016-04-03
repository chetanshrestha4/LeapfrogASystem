/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.LFASystem.DAO;

import com.leapfrog.LFASystem.entity.Course;
import java.util.List;

/**
 *
 * @author Chetan
 */
public interface CourseDAO {
    List<Course> getAll();
    Course getById(int id);
    int insert(Course c);
    int count();
    int update(Course c);
    int delete(int id);
    List<Course> search(String param);
}
