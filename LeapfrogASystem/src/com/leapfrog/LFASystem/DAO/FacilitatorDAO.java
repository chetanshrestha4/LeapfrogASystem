/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.LFASystem.DAO;

import com.leapfrog.LFASystem.entity.Facilitator;
import java.util.List;

/**
 *
 * @author Chetan
 */
public interface FacilitatorDAO {
    List<Facilitator> getAll();
    Facilitator getById(int id);
    int insert(Facilitator e);
    int count();
    int update(Facilitator e);
    int delete(int id);
    List<Facilitator> search(String param);
}
