/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.LFASystem;

;
import com.leapfrog.LFASystem.DAO.Impl.CourseDAOImpl;
import com.leapfrog.LFASystem.DAO.Impl.FacilitatorDAOImpl;
import com.leapfrog.LFASystem.DAO.Impl.StudentDAOImpl;
import com.leapfrog.LFASystem.DAO.StudentDAO;
import com.leapfrog.LFASystem.view.CourseView;
import com.leapfrog.LFASystem.view.FacilitatorView;
import com.leapfrog.LFASystem.view.MainView;
import com.leapfrog.LFASystem.view.StudentView;
import java.util.Scanner;

/**
 *
 * @author Chetan
 */


public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentView studentView = new StudentView(new Scanner(System.in), new StudentDAOImpl());
        FacilitatorView facilitatorView = new FacilitatorView(new Scanner(System.in), new FacilitatorDAOImpl());
        CourseView courseView = new CourseView(new Scanner(System.in), new CourseDAOImpl());
        while (true) {
            System.out.println("1. Student");
            System.out.println("2. Facilitator");
            System.out.println("3. Course");
            System.out.println("4. Search by key");
            System.out.println("5. Delete ");
            System.out.println("6. Exit");
            System.out.println("Enter your choice[1-6]:");

            switch (input.nextInt()) {
                case 1:
                    while (true) {
                        studentView.menu();
                        studentView.controller();
                        break;
                    }
                case 2:
                    facilitatorView.menu();
                    facilitatorView.controller();
                    break;
                case 3:
                    courseView.menu();
                    courseView.controller();
                    break;
                case 4:
                    break;
                case 5:

                    break;
                case 6:
                    System.exit(0);
                    break;

            }

        }

    }

}
