/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.dao.custom.impl;

import java.io.Serializable;
import java.util.List;
import lk.edu.ijse.assignment.dao.custom.OrdersDAO;
import lk.edu.ijse.assignment.entity.Orders;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Hansani Kariyawasam
 */
public class OrdersDAOImpl implements OrdersDAO{
    
    private Session session;
    
    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }

    @Override
    public boolean add(Orders t) throws Exception {
        Serializable saveOrder=session.save(t);
        if(saveOrder!=null)return true;
        return false;
    }

    @Override
    public boolean update(Orders t) throws Exception {
        try{
            session.merge(t);
            return true;
        }catch(HibernateException e){
            throw e;
        }
    }


    @Override
    public List<Orders> getAll() throws Exception {
        try{
            List<Orders> list=session.createCriteria(Orders.class).list();
            System.out.println(list);
            return list;
        }catch(HibernateException e){
            throw e;
        }
    }

    @Override
    public List<Orders> searchOrder(int cid) throws Exception {
        try{
            List<Orders> list=session.createCriteria(Orders.class).add(Restrictions.eq("cid", cid)).list();
            System.out.println(list);
            return list;
        }catch(HibernateException e){
            throw e;
        }
    }
    
}
