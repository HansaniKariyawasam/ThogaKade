/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.service;

import lk.edu.ijse.assignment.service.custom.impl.CashierServiceImpl;
import lk.edu.ijse.assignment.service.custom.impl.ManagerServiceImpl;

/**
 *
 * @author Hansani Kariyawasam
 */
public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    
    public enum ServiceType{
        CASHIER,MANAGER;
    }

    private ServiceFactory() {
    }
    
    public static ServiceFactory getInstance(){
        if(serviceFactory==null){
            serviceFactory=new ServiceFactory();
        }
        return serviceFactory;
    }
    
    public SuperService getService(ServiceType service){
        switch(service){
            case CASHIER:
                return new CashierServiceImpl();
            case MANAGER:
                return new ManagerServiceImpl();
            default:
                return null;
        }
    }
}
