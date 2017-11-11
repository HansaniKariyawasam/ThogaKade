/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.dao.custom;

import java.util.List;
import lk.edu.ijse.assignment.dao.SuperDAO;
import lk.edu.ijse.assignment.entity.Customer;

/**
 *
 * @author Hansani Kariyawasam
 */
public interface CustomerDAO extends SuperDAO<Customer>{
    public List<Customer> getAllCustomers()throws Exception;
}
