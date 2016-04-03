/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.LFASystem.view;

import com.leapfrog.LFASystem.DAO.Impl.FacilitatorDAOImpl;
import com.leapfrog.LFASystem.DAO.Impl.StudentDAOImpl;
import java.util.Scanner;

/**
 *
 * @author Chetan
 */
public class MainView {
    private StudentView s = new StudentView(new Scanner(System.in), new StudentDAOImpl());
    private FacilitatorView f = new FacilitatorView(new Scanner(System.in), new FacilitatorDAOImpl());
    
    public MainView() {
    }
    
    
    public void studentView(){
        s.menu();
        s.controller();
    }
    
    public void facilitatorView(){
        f.menu();
        f.controller();
    }
}
