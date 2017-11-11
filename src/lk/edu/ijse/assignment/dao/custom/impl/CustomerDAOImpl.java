/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.dao.custom.impl;

import java.io.Serializable;
import java.util.List;
import lk.edu.ijse.assignment.dao.custom.CustomerDAO;
import lk.edu.ijse.assignment.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;

/**
 *
 * @author Hansani Kariyawasam
 */
public class CustomerDAOImpl implements CustomerDAO{

    private Session session;
    
    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }
    
    @Override
    public boolean add(Customer t) throws Exception {
        Serializable saveCustomer=session.save(t);
        if(saveCustomer!=null)return true;
        return false;
    }

    @Override
    public boolean update(Customer t) throws Exception {
        try{
            session.update(t);
            return true;
        }catch(HibernateException e){
            throw e;
        }
    }

    @Override
    public boolean delete(Customer t) throws Exception {
        try{
            session.delete(t);
            return true;
        }catch(HibernateException e){
            throw e;
        }
    }


    @Override
    public List<Customer> getAllCustomers() throws Exception {
        try{
            List<Customer> list=session.createCriteria(Customer.class).list();
            return list;
        }catch(HibernateException e){
            throw e;
        }
    }

    
    
}
