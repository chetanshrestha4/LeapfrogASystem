/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.LFASystem.view;

import com.leapfrog.LFASystem.DAO.StudentDAO;
import com.leapfrog.LFASystem.entity.Student;
import java.util.Scanner;

/**
 *
 * @author Chetan
 */
public class StudentView {

    private StudentDAO studentDAO;
    private Scanner input;

    public StudentView(Scanner input, StudentDAO studentDAO) {
        this.input = input;
        this.studentDAO = studentDAO;
    }

    public void menu() {
        System.out.println("1. Add Student");
        System.out.println("2. Show all Students");
        System.out.println("3. Search by Id");
        System.out.println("4. Search by key");
        System.out.println("5. Edit the Student");
        System.out.println("6. Exit");
        System.out.println("Enter your choice[1-6]:");
    }

    public void add() {
        while (true) {
            System.out.println("Add Student");
            Student s = new Student();

            s.setId(studentDAO.count() + 1);
            System.out.println("Enter First Name of Student:");
            s.setFirstName(input.next());
            System.out.println("Enter Last Name of Student:");
            s.setLastName(input.next());
            System.out.println("Enter Contact number of Student:");
            s.setContact(input.next());
            System.out.println("Enter Email of Student:");
            s.setEmail(input.next());
            studentDAO.insert(s);
            System.out.println("Do you want to continue[Y/N]?");
            if (input.next().equalsIgnoreCase("n")) {

                break;
            }

        }
    }

    public void showAll() {
        studentDAO.getAll().forEach(s -> {
            System.out.println(s.toString());
        });
    }

    public void searchById() {
        while (true) {
            System.out.println("Enter Id:");
            Student student = studentDAO.getById(input.nextInt());
            if (student != null) {
                System.out.println(student.toString());
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
            studentDAO.search(input.next()).forEach(s -> {
                System.out.println(s.toString());
            });
            System.out.println("Do you want to continue[Y/N]?");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void controller() {
        boolean back =false;
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
                back =true;
                break;

        }
    }

    public boolean confirm(String param) {

        return (param.equalsIgnoreCase("y"));

    }
}
