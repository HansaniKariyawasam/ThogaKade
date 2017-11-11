/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.dao;

import java.util.List;
import lk.edu.ijse.assignment.entity.SuperEntity;
import org.hibernate.Session;

/**
 *
 * @author Hansani Kariyawasam
 */
public interface SuperDAO <T extends SuperEntity>{
    public void setSession(Session session)throws Exception;
    
    public boolean add(T t)throws Exception;
    
    public boolean update(T t)throws Exception;
    
    public boolean delete(T t)throws Exception;
    
    
}
