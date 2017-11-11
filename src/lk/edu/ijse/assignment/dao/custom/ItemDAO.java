/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.dao.custom;

import java.util.List;
import lk.edu.ijse.assignment.dao.SuperDAO;
import lk.edu.ijse.assignment.entity.Item;

/**
 *
 * @author Hansani Kariyawasam
 */
public interface ItemDAO extends SuperDAO<Item>{
    default boolean delete(Item t)throws Exception{
        return false;
    }
    
    default boolean update(Item t)throws Exception{
        return false;
    }
    
    public boolean updateItems(List<Item> item)throws Exception;
    
    public List<Item> getAllItems() throws Exception;
    

}
