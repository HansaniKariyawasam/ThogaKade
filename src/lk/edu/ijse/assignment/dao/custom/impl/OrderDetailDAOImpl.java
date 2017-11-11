/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.dao.custom.impl;

import java.io.Serializable;
import java.util.List;
import lk.edu.ijse.assignment.dao.custom.OrderDetailDAO;
import lk.edu.ijse.assignment.entity.OrderDetail;
import lk.edu.ijse.assignment.entity.OrderDetail_PK;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Hansani Kariyawasam
 */
public class OrderDetailDAOImpl implements OrderDetailDAO{

    private Session session;
    
    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }

    @Override
    public boolean add(OrderDetail t) throws Exception {
        Serializable saveOrderDetail=session.save(t);
        if(saveOrderDetail!=null)return true;
        return false;
    }
    
    @Override
    public boolean delete(OrderDetail t)throws Exception{
        try{
            session.delete(t);
            return true;
        }catch(HibernateException e){
            throw e;
        }
    }

    @Override
    public boolean update(OrderDetail t) throws Exception {
        try{
            OrderDetail od=search(t);
            if(od!=null){
                t.setOrderDetail_PK(new OrderDetail_PK(
                        od.getOrderDetail_PK().getOid(), 
                        od.getOrderDetail_PK().getItemCode())
                );
                session.merge(t);
                return true;
            }else{
                return add(t);
            }
        }catch(HibernateException e){
            throw e;
        }
    }
    
    @Override
    public OrderDetail search(OrderDetail o)throws Exception{
        try{
            List<OrderDetail> or=session.createCriteria(OrderDetail.class)
                    .createAlias("item", "i")
                    .createAlias("orders", "o")
                    .add(Restrictions.eq("o.oid", o.getOrderDetail_PK().getOid()))
                    .add(Restrictions.eq("i.itemCode", o.getOrderDetail_PK().getItemCode())).list();
            
            OrderDetail order=null;
            for (OrderDetail od : or) {
                order=od;
            }
            return order;
        }catch(HibernateException e){
            throw e;
        }
    }

    @Override
    public List<OrderDetail> getAll()throws Exception{
        try{
            List<OrderDetail> list=session.createCriteria(OrderDetail.class).list();
            return list;
        }catch(HibernateException e){
            throw e;
        }
    }  

    @Override
    public List<OrderDetail> searchOrder(int oid) throws Exception {
        try{
            List<OrderDetail> list=session.createCriteria(OrderDetail.class).add(Restrictions.eq("Orders_oid", oid)).list();
            return list;
        }catch(HibernateException e){
            throw e;
        }
    }

   

    
}
