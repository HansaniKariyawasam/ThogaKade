/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.service.custom;

import java.util.List;
import lk.edu.ijse.assignment.dto.CustomerDTO;
import lk.edu.ijse.assignment.dto.ItemDTO;
import lk.edu.ijse.assignment.dto.OrderDetailDTO;
import lk.edu.ijse.assignment.dto.OrdersDTO;
import lk.edu.ijse.assignment.dto.SuperDTO;
import lk.edu.ijse.assignment.service.SuperService;

/**
 *
 * @author Hansani Kariyawasam
 */
public interface CashierService extends SuperService<SuperDTO>{
    public boolean manageCustomer(CustomerDTO customer)throws Exception;
    
    public List<ItemDTO> getStockDetails()throws Exception;
    
    public List<CustomerDTO> viewCustomerDetails()throws Exception;
    
    public List<OrdersDTO> viewOrders()throws Exception;
    
    public List<OrdersDTO> searchcustomerOrders(int cid)throws Exception;
    
    public List<OrderDetailDTO> viewOrderDetails()throws Exception;
    
    public List<OrderDetailDTO> getOrderDetail(int oid)throws Exception;
    
    public boolean modifyOrder(List<OrderDetailDTO> list,List<ItemDTO> updateItem,OrdersDTO order,List<OrderDetailDTO> removeList)throws Exception;
    
    public boolean placeNewOrder(OrdersDTO orders, List<OrderDetailDTO> ordersList, List<ItemDTO> itemList,CustomerDTO customer) throws Exception;
}
