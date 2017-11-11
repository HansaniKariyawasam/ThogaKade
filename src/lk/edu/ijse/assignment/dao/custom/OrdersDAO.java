/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.dao.custom;

import java.util.List;
import lk.edu.ijse.assignment.dao.SuperDAO;
import lk.edu.ijse.assignment.entity.Orders;

/**
 *
 * @author Hansani Kariyawasam
 */
public interface OrdersDAO extends SuperDAO<Orders>{
    default boolean delete(Orders t)throws Exception{
        return false;
    }
    
    public List<Orders> getAll()throws Exception;
    
    public List<Orders> searchOrder(int cid)throws Exception;
}
