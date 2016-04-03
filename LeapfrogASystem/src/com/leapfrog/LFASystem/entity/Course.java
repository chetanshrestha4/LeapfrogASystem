/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.LFASystem.entity;

/**
 *
 * @author Chetan
 */
public class Course {
    private int id;
    private String courseName, duration, cost;

    public Course() {
    }

    public Course(int id, String courseName, String duration, String cost) {
        this.id = id;
        this.courseName = courseName;
        this.duration = duration;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", courseName=" + courseName + ", duration=" + duration + ", cost=" + cost + '}';
    }
    
    
    
}
