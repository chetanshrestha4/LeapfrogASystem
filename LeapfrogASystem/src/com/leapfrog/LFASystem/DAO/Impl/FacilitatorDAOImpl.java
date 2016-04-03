/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.LFASystem.DAO.Impl;

import com.leapfrog.LFASystem.DAO.FacilitatorDAO;
import com.leapfrog.LFASystem.entity.Facilitator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chetan
 */
public class FacilitatorDAOImpl implements FacilitatorDAO{
    private List<Facilitator> facilitatorList = new ArrayList<>();

    @Override
    public List<Facilitator> getAll() {
        return facilitatorList;
    }

    @Override
    public Facilitator getById(int id) {
        for(Facilitator e: facilitatorList){
            if(e.getId()==id){
                return e;
            }
        }
        return null;
    }

    @Override
    public int insert(Facilitator e) {
        facilitatorList.add(e);
        return 1;
    }

    @Override
    public int count() {
      return facilitatorList.size();
    }

    @Override
    public int update(Facilitator e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        Facilitator e =getById(id);
            if(e!=null){
                facilitatorList.remove(e);
                return 1;
            }
        return 0;
    }

    @Override
    public List<Facilitator> search(String param) {
        List<Facilitator> fList  = new ArrayList<>();
        for(Facilitator e:facilitatorList){
            if(e.getFirstName().toLowerCase().contains(param.toLowerCase())|| e.getLastName().toLowerCase().contains(param.toLowerCase())){
                fList.add(e);
            }
        }
        return fList;
    }
    
}
