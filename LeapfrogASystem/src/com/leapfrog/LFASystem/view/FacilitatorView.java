/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.LFASystem.view;

import com.leapfrog.LFASystem.DAO.FacilitatorDAO;
import com.leapfrog.LFASystem.entity.Facilitator;
import java.util.Scanner;

/**
 *
 * @author Chetan
 */
public class FacilitatorView {

    private Scanner input;
    private FacilitatorDAO facilitatorDAO;

    public FacilitatorView(Scanner input, FacilitatorDAO facilitatorDAO) {
        this.input = input;
        this.facilitatorDAO = facilitatorDAO;
    }

    public void menu() {
        System.out.println("1. Add Facilitator");
        System.out.println("2. Show all Facilitators");
        System.out.println("3. Search by Id");
        System.out.println("4. Search by key");
        System.out.println("5. Edit the Facilitator");
        System.out.println("6. Exit");
        System.out.println("Enter your choice[1-6]:");
    }

    public void add() {
        while (true) {
            System.out.println("Add Facilitator");
            Facilitator f = new Facilitator();
            f.setId(facilitatorDAO.count() + 1);
            System.out.println("Enter First Name of Facilitator:");
            f.setFirstName(input.next());
            System.out.println("Enter Last Name of Facilitator:");
            f.setLastName(input.next());
            System.out.println("Enter Course of Facilitator:");
            f.setCourse(input.next());
            System.out.println("Enter email of Facilitator:");
            f.setEmail(input.next());
            System.out.println("Enter Contact of Facilitator:");
            f.setContact(input.next());

            facilitatorDAO.insert(f);
            System.out.println("Do you want to continue[Y/N]?");
            if (!confirm(input.next())) {
                break;
            }
        }

    }

    public void showAll() {
        facilitatorDAO.getAll().forEach(f -> {
            System.out.println(f.toString());
        });
    }

    public void searchById() {
        while (true) {
            System.out.println("Enter search key:");
            Facilitator facilitator = facilitatorDAO.getById(input.nextInt());
            if (facilitator != null) {
                System.out.println(facilitator.toString());
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
            facilitatorDAO.search(input.next()).forEach(s -> {
                System.out.println(s.toString());
            });
            System.out.println("Do you want to continue[Y/N]?");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void controller() {
        boolean back=false;
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
                back= false;
                break;

        }
    }

    public boolean confirm(String param) {

        return (param.equalsIgnoreCase("y"));

    }
}
