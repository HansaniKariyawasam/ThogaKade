/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.controller.custom;

import lk.edu.ijse.assignment.controller.SuperController;
import lk.edu.ijse.assignment.dto.ItemDTO;
import lk.edu.ijse.assignment.dto.SuperDTO;

/**
 *
 * @author Hansani Kariyawasam
 */
public interface ManagerController extends SuperController<SuperDTO>{
    public boolean stockHandling(ItemDTO item)throws Exception;
}
