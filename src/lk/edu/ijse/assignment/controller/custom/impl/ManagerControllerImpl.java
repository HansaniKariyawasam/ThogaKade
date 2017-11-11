/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.controller.custom.impl;

import lk.edu.ijse.assignment.controller.custom.ManagerController;
import lk.edu.ijse.assignment.dto.ItemDTO;
import lk.edu.ijse.assignment.service.ServiceFactory;
import lk.edu.ijse.assignment.service.SuperService;
import lk.edu.ijse.assignment.service.custom.ManagerService;

/**
 *
 * @author Hansani Kariyawasam
 */
public class ManagerControllerImpl implements ManagerController{
    private ManagerService managerService;

    public ManagerControllerImpl() {
        managerService=(ManagerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MANAGER);
    }
    
    @Override
    public boolean stockHandling(ItemDTO item) throws Exception { 
        return managerService.stockHandling(item);
    }
    
}
