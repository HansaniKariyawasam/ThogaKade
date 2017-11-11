/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.service.custom;

import lk.edu.ijse.assignment.dto.ItemDTO;
import lk.edu.ijse.assignment.dto.SuperDTO;
import lk.edu.ijse.assignment.service.SuperService;

/**
 *
 * @author Hansani Kariyawasam
 */
public interface ManagerService extends SuperService<SuperDTO>{
    public boolean stockHandling(ItemDTO item) throws Exception;
}
