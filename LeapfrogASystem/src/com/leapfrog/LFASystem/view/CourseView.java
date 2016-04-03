/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.LFASystem.view;

import com.leapfrog.LFASystem.DAO.CourseDAO;
import com.leapfrog.LFASystem.entity.Course;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Chetan
 */
public class CourseView {

    private Scanner input;
    private CourseDAO courseDAO;

    public CourseView(Scanner input, CourseDAO courseDAO) {
        this.input = input;
        this.courseDAO = courseDAO;
    }

    public void menu() {
        System.out.println("1. Add Course");
        System.out.println("2. Show all Courses");
        System.out.println("3. Search by Id");
        System.out.println("4. Search by key");
        System.out.println("5. Edit the Course");
        System.out.println("6. Exit");
        System.out.println("Enter your choice[1-6]:");
    }

    public void add() {

        while (true) {
            System.out.println("Add Course");
            Course c = new Course();
            c.setId(courseDAO.count() + 1);
            System.out.println("Enter Name of Course:");
            c.setCourseName(input.next());
            System.out.println("Enter Cost of Course:");
            c.setCost(input.next());
            System.out.println("Enter Duration of Course:");
            c.setDuration(input.next());

            courseDAO.insert(c);
            System.out.println("Do you want to continue[Y/N]?");
            if (!confirm(input.next())) {
                break;
            }
        }

    }

    public void showAll() {
        courseDAO.getAll().forEach(f -> {
            System.out.println(f.toString());
        });
    }

    public void searchById() {
        while (true) {
            System.out.println("Enter search key:");
            Course course = courseDAO.getById(input.nextInt());
            if (course != null) {
                System.out.println(course.toString());
            } else {
                System.out.println("Id not found");
            }
            System.out.println("Do you want to continue[Y/N]?");
            if (!confirm(input.next())) {
                break;
            }
        }
    }

    public void search() {
        while (true) {
            System.out.println("Enter search key:");
            courseDAO.search(input.next()).forEach(s -> {
                System.out.println(s.toString());
            });
            System.out.println("Do you want to continue[Y/N]?");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void controller() {

        while (true) {
            boolean back = false;
            switch (input.nextInt()) {
                case 1:
                    add();
                    break;

                case 2:
                    showAll();
                    break;
                case 3:
                    searchById();
                    break;
                case 4:
                    search();
                    break;
                case 5:

                    break;
                case 6:
                    back = true;
                    break;
            }
            if (back) {
                break;
            }

        }
    }

    public static void generateCSV(String data) throws IOException {
        FileWriter fwriter = new FileWriter(new File("d:/record.csv"), true);
        fwriter.write(data);
        fwriter.write("\n");
        fwriter.close();

    }

    public boolean confirm(String param) {

        return (param.equalsIgnoreCase("y"));

    }

}
