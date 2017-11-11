/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.dao;

import lk.edu.ijse.assignment.dao.custom.impl.CustomerDAOImpl;
import lk.edu.ijse.assignment.dao.custom.impl.ItemDAOImpl;
import lk.edu.ijse.assignment.dao.custom.impl.OrderDetailDAOImpl;
import lk.edu.ijse.assignment.dao.custom.impl.OrdersDAOImpl;

/**
 *
 * @author Hansani Kariyawasam
 */
public class DAOFactory {
    private static DAOFactory daoFactory;
    
    public enum DAOTypes{
        CUSTOMER,ITEM,ORDERS,ORDERDETAIL;
    }

    private DAOFactory() {
    }
    
    public static DAOFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();            
        }
        return daoFactory;
    }
    
    public SuperDAO getDAO(DAOTypes dao){
        switch(dao){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDERS:
                return new OrdersDAOImpl();
            case ORDERDETAIL:
                return new OrderDetailDAOImpl();
            default:
                return null;
        }
    }
}
