/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.controller.custom.impl;

import java.util.List;
import lk.edu.ijse.assignment.controller.custom.CashierController;
import lk.edu.ijse.assignment.dto.CustomerDTO;
import lk.edu.ijse.assignment.dto.ItemDTO;
import lk.edu.ijse.assignment.dto.OrderDetailDTO;
import lk.edu.ijse.assignment.dto.OrdersDTO;
import lk.edu.ijse.assignment.service.ServiceFactory;
import lk.edu.ijse.assignment.service.custom.CashierService;

/**
 *
 * @author Hansani Kariyawasam
 */
public class CashierControllerImpl implements CashierController{
    private CashierService cashierService;

    public CashierControllerImpl() {
        cashierService=(CashierService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CASHIER);
    }
    
    

    @Override
    public boolean manageCustomer(CustomerDTO customer) throws Exception {
        return cashierService.manageCustomer(customer);
    }

    @Override
    public List<ItemDTO> getStockDetails() throws Exception {
        return cashierService.getStockDetails();
    }

    @Override
    public List<CustomerDTO> viewCustomerDetails() throws Exception {
        return cashierService.viewCustomerDetails();
    }

    @Override
    public boolean placeNewOrder(OrdersDTO orders, List<OrderDetailDTO> ordersList, List<ItemDTO> itemList,CustomerDTO customer) throws Exception {
        return cashierService.placeNewOrder(orders, ordersList, itemList,customer);
    }

    @Override
    public List<OrdersDTO> viewOrders() throws Exception {
        return cashierService.viewOrders();
    }

    @Override
    public List<OrdersDTO> searchcustomerOrders(int cid) throws Exception {
        return cashierService.searchcustomerOrders(cid);
    }

    @Override
    public List<OrderDetailDTO> viewOrderDetails() throws Exception {
        return cashierService.viewOrderDetails();
    }

    @Override
    public List<OrderDetailDTO> getOrderDetail(int oid) throws Exception {
        return cashierService.getOrderDetail(oid);
    }

    @Override
    public boolean modifyOrder(List<OrderDetailDTO> list,List<ItemDTO> updateItem,OrdersDTO order,List<OrderDetailDTO> removeList) throws Exception {
        return cashierService.modifyOrder(list,updateItem,order,removeList);
    }
    
}
