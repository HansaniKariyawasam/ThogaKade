/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.controller;

import lk.edu.ijse.assignment.controller.custom.impl.CashierControllerImpl;
import lk.edu.ijse.assignment.controller.custom.impl.ManagerControllerImpl;

/**
 *
 * @author Hansani Kariyawasam
 */
public class ControllerFactory {
    
    private static ControllerFactory controllerFactory;
    
    public enum ControllerType{
        CASHIER,MANAGER;
    }

    private ControllerFactory() {
    }
    
    public static ControllerFactory getInstance(){
        if(controllerFactory==null){
            controllerFactory=new ControllerFactory();
        }
        return controllerFactory;
    }
    
    public SuperController getControllerType(ControllerType controller){
        switch(controller){
            case CASHIER:
                return new CashierControllerImpl();
            case MANAGER:
                return new ManagerControllerImpl();
            default:
                return null;
        }
    }
    
}
