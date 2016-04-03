/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.LFASystem.DAO.Impl;

import com.leapfrog.LFASystem.DAO.StudentDAO;
import com.leapfrog.LFASystem.entity.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chetan
 */
public class StudentDAOImpl implements StudentDAO {

    private List<Student> studentList = new ArrayList<>();

    @Override
    public List<Student> getAll() {
        return studentList;
    }

    @Override
    public Student getById(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public int insert(Student s) {
        studentList.add(s);
        return 1;
    }

    @Override
    public int count() {
        return studentList.size();

    }

    @Override
    public int update(Student s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        Student s = getById(id);
        if (s != null) {
            studentList.remove(s);
            return 1;
        }
        return 0;
    }

    @Override
    public List<Student> search(String param) {
        List<Student> stdList = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getFirstName().toLowerCase().contains(param.toLowerCase()) || s.getLastName().toLowerCase().contains(param.toLowerCase())) {
                stdList.add(s);
            }
        }
        return stdList;
    }

}
