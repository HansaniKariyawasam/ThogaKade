/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.dao.custom.impl;

import java.io.Serializable;
import java.util.List;
import lk.edu.ijse.assignment.dao.custom.ItemDAO;
import lk.edu.ijse.assignment.entity.Item;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Hansani Kariyawasam
 */
public class ItemDAOImpl implements ItemDAO{
    
    private Session session;
    
    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }

    @Override
    public boolean add(Item t) throws Exception {
        Serializable addItem=session.save(t);
        if(addItem!=null)return true;
        return false;
    }

    @Override
    public boolean delete(Item t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Item> getAllItems() throws Exception {
        try{
            List<Item> list=session.createCriteria(Item.class).list();
            return list;
        }catch(HibernateException e){
            throw e;
        }
    }

    @Override
    public boolean update(Item item) throws Exception {
        try{
            session.merge(item);
            return true;
        }catch(HibernateException e){
            throw e;
        }
    }

    @Override
    public boolean updateItems(List<Item> item) throws Exception {
        try{
            for (Item i : item) {
                session.update(i);
            }
                
            
            return true;
        }catch(HibernateException e){
            throw e;
        }
    }

    
}
