/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.dao.custom;

import java.util.List;
import lk.edu.ijse.assignment.dao.SuperDAO;
import lk.edu.ijse.assignment.entity.OrderDetail;

/**
 *
 * @author Hansani Kariyawasam
 */
public interface OrderDetailDAO extends SuperDAO<OrderDetail>{
    
    public List<OrderDetail> getAll()throws Exception;
    
    public List<OrderDetail> searchOrder(int oid)throws Exception;
    
    public OrderDetail search(OrderDetail o)throws Exception;
}
