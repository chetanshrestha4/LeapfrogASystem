/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.LFASystem.DAO.Impl;

import com.leapfrog.LFASystem.DAO.CourseDAO;
import com.leapfrog.LFASystem.entity.Course;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chetan
 */
public class CourseDAOImpl implements CourseDAO {

    private List<Course> courseList = new ArrayList<>();

    @Override
    public List<Course> getAll() {
        return courseList;
    }

    @Override
    public Course getById(int id) {
        for (Course c : courseList) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public int insert(Course c) {
        courseList.add(c);
        return 1;
    }

    @Override
    public int count() {
        return courseList.size();
    }

    @Override
    public int update(Course c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        Course c = getById(id);
        if (c != null) {
            courseList.remove(c);
            return 1;
        }
        return 0;
    }

    @Override
    public List<Course> search(String param) {
        List<Course> cList = new ArrayList<>();
        for (Course c: courseList) {
            if(c.getCourseName().toLowerCase().contains(param.toLowerCase())){
                cList.add(c);
            }
        }
        return cList;
    }

}
