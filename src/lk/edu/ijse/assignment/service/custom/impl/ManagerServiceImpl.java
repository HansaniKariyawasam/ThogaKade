/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.service.custom.impl;

import lk.edu.ijse.assignment.dao.DAOFactory;
import lk.edu.ijse.assignment.dao.SuperDAO;
import lk.edu.ijse.assignment.dao.custom.ItemDAO;
import lk.edu.ijse.assignment.dto.ItemDTO;
import lk.edu.ijse.assignment.entity.Item;
import lk.edu.ijse.assignment.service.custom.ManagerService;
import lk.edu.ijse.assignment.util.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Hansani Kariyawasam
 */
public class ManagerServiceImpl implements ManagerService{
    private SessionFactory sf=SessionFactoryUtil.getSession();
    
    private SuperDAO<Item> itemDAO;

    public ManagerServiceImpl() {
        itemDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    }

    @Override
    public boolean stockHandling(ItemDTO i) throws Exception {
        System.out.println("Session Factory :"+sf);
        Session session=sf.openSession();
        Transaction tr=null;

        try{
            tr=session.beginTransaction();
            itemDAO.setSession(session);
            Item item=new Item(i.getDescription(), i.getUnitPrice(), i.getQtyOnHand());
            boolean result=itemDAO.add(item);
            if(result){
                tr.commit();
                return true;
            }else{
                tr.rollback();
                return false;
            }    
        }catch(HibernateException e){
             e.printStackTrace();
             if(tr!=null)tr.rollback();
             return false;
        }finally{
            session.close();
        } 
       
    }
    
}
