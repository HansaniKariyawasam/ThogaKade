/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.service.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.edu.ijse.assignment.dao.DAOFactory;
import lk.edu.ijse.assignment.dao.SuperDAO;
import lk.edu.ijse.assignment.dao.custom.CustomerDAO;
import lk.edu.ijse.assignment.dao.custom.ItemDAO;
import lk.edu.ijse.assignment.dao.custom.OrderDetailDAO;
import lk.edu.ijse.assignment.dao.custom.OrdersDAO;
import lk.edu.ijse.assignment.dto.CustomerDTO;
import lk.edu.ijse.assignment.dto.ItemDTO;
import lk.edu.ijse.assignment.dto.OrderDetailDTO;
import lk.edu.ijse.assignment.dto.OrdersDTO;
import lk.edu.ijse.assignment.entity.Customer;
import lk.edu.ijse.assignment.entity.Item;
import lk.edu.ijse.assignment.entity.OrderDetail;
import lk.edu.ijse.assignment.entity.Orders;
import lk.edu.ijse.assignment.service.custom.CashierService;
import lk.edu.ijse.assignment.ui.ManageOrder;
import lk.edu.ijse.assignment.util.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Hansani Kariyawasam
 */
public class CashierServiceImpl implements CashierService {

    private SuperDAO superDAO;
    private SessionFactory sf = SessionFactoryUtil.getSession();

    @Override
    public boolean manageCustomer(CustomerDTO c) throws Exception {
        superDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        Session session = sf.openSession();
        Transaction tr = null;

        try {
            tr = session.beginTransaction();
            superDAO.setSession(session);
            Customer customer = new Customer(c.getCustomerName(), c.getAddress(), c.getTel(), c.getNic());
            boolean isAdded = superDAO.add(customer);
            if (isAdded) {
                tr.commit();
                return true;
            } else {
                tr.rollback();
                return false;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<ItemDTO> getStockDetails() throws Exception {
        superDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
        ItemDAO itemDAO = (ItemDAO) superDAO;
        Session session = sf.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            superDAO.setSession(session);
            List<Item> list = itemDAO.getAllItems();
            if (list != null) {
                List<ItemDTO> itemList = new ArrayList<>();
                for (Item i : list) {
                    ItemDTO item = new ItemDTO(i.getItemCode(), i.getDescription(), i.getUnitPrice(), i.getQtyOnHand());
                    itemList.add(item);
                }
                tr.commit();
                return itemList;
            } else {
                tr.rollback();
                return null;
            }

        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<CustomerDTO> viewCustomerDetails() throws Exception {
        superDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        CustomerDAO customerDAO = (CustomerDAO) superDAO;
        Session session = sf.openSession();
        Transaction tr = null;

        try {
            tr = session.beginTransaction();
            superDAO.setSession(session);
            List<Customer> list = customerDAO.getAllCustomers();
            List<CustomerDTO> customerList = new ArrayList<>();
            if (list != null) {
                for (Customer c : list) {
                    CustomerDTO customer = new CustomerDTO(
                            c.getCid(),
                            c.getCustomerName(),
                            c.getAddress(),
                            c.getTel(),
                            c.getNic()
                    );
                    customerList.add(customer);
                }
                tr.commit();
                return customerList;
            } else {
                tr.rollback();
                return null;
            }

        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<OrdersDTO> viewOrders() throws Exception {
        superDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
        OrdersDAO ordersDAO = (OrdersDAO) superDAO;
        Session session = sf.openSession();
        Transaction tr = null;

        try {
            tr = session.beginTransaction();
            superDAO.setSession(session);
            List<Orders> list = ordersDAO.getAll();
            List<OrdersDTO> ordersList = new ArrayList<>();
            if (list != null) {
                for (Orders o : list) {
                    OrdersDTO orders = new OrdersDTO(o.getOid(), o.getOrderDate(), o.getOrderPriority());
                    ordersList.add(orders);
                }
                tr.commit();
                return ordersList;
            } else {
                tr.rollback();
                return null;
            }

        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    @Override
    public List<OrdersDTO> searchcustomerOrders(int cid) throws Exception {
        superDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
        Session session = sf.openSession();
        Transaction tr = null;
        OrdersDAO ordersDAO = (OrdersDAO) superDAO;

        try {
            tr = session.beginTransaction();
            superDAO.setSession(session);
            List<Orders> list = ordersDAO.searchOrder(cid);
            List<OrdersDTO> ordersList = new ArrayList<>();
            List<OrderDetailDTO> odList = new ArrayList<>();
            List<OrderDetail> od=null;
            if (list != null) {
                for (Orders o : list) {
//                    od=o.getOrderDetailList();
//                    for (OrderDetail or : od) {
//                        OrderDetailDTO dto=new OrderDetailDTO(or.getOrderDetail_PK().getItemCode(), or.getOrderDetail_PK().getOid(), or.getOrderQty());
//                        odList.add(dto);
//                    }
                    OrdersDTO orderDTO = new OrdersDTO(o.getOid(), o.getOrderDate(), o.getOrderPriority());
                    ordersList.add(orderDTO);
                }
                
                
                
                
                tr.commit();
                ManageOrder.list=odList;
                return ordersList;
            } else {
                tr.rollback();
                return null;
            }
        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<OrderDetailDTO> viewOrderDetails() throws Exception {
        superDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);
        
        Session session=sf.openSession();
        Transaction tr=null;
        
        try{
            tr=session.beginTransaction();
            superDAO.setSession(session);
            OrderDetailDAO orderdetailDAO=(OrderDetailDAO) superDAO;
            List<OrderDetail> list=orderdetailDAO.getAll();
            List<OrderDetailDTO> orderList=new ArrayList<>();
            if(list!=null){
                for (OrderDetail o : list) {
                    OrderDetailDTO ord=new OrderDetailDTO(
                            o.getOrderDetail_PK().getItemCode(), 
                            o.getOrderDetail_PK().getOid(), 
                            o.getOrderQty()
                    );
                    orderList.add(ord);
                }
                tr.commit();
                return orderList;
            }else{
                tr.rollback();
                return null;
            }
            
        }catch(HibernateException e){
            if(tr!=null)tr.rollback();
            e.printStackTrace();
            return null;
        }finally{
            session.close();
        }
    }

    @Override
    public List<OrderDetailDTO> getOrderDetail(int oid) throws Exception {
        superDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);
        
        Session session=sf.openSession();
        Transaction tr=null;
        
        try{
            tr=session.beginTransaction();
            superDAO.setSession(session);
            OrderDetailDAO ordDAO=(OrderDetailDAO) superDAO;
            List<OrderDetail> list=ordDAO.searchOrder(oid);
            List<OrderDetailDTO> ordList=new ArrayList<>();
            if(list!=null){
                for (OrderDetail o : list) {
                    OrderDetailDTO od=new OrderDetailDTO(
                            o.getOrderDetail_PK().getItemCode(),
                            o.getOrderDetail_PK().getOid(),
                            o.getOrderQty()
                    );
                    ordList.add(od);
                }
                tr.commit();
                return ordList;
            }else{
                tr.rollback();
                return null;
            }
        }catch(HibernateException e){
            if(tr!=null)tr.rollback();
            e.printStackTrace();
            return null;
        }finally{
            session.close();
        }
    }
    
    @Override
    public boolean placeNewOrder(OrdersDTO or, List<OrderDetailDTO> ordersList, List<ItemDTO> itemList, CustomerDTO c) throws Exception {
        //Create dependancies between DAO layer and Service layer
        ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
        OrdersDAO ordersDAO = (OrdersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
        OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);

        //Convert all DTO into Entity type objects
        Customer cust = new Customer(c.getCid(), c.getCustomerName(), c.getAddress(), c.getTel(), c.getNic());
        List<Item> updateItemList = new ArrayList<>();
        for (ItemDTO i : itemList) {
            Item item = new Item(i.getItemCode(), i.getDescription(), i.getUnitPrice(), i.getQtyOnHand());
            updateItemList.add(item);
        }

        Orders orders = new Orders(or.getOrderDate(), or.getOrderPriority(), cust.getCid());

        List<OrderDetail> orderDetailList = new ArrayList<>();

        int count = 0;
        for (OrderDetailDTO o : ordersList) {
            OrderDetail od = new OrderDetail(updateItemList.get(count), orders, o.getOrderQty());
            orderDetailList.add(od);
            count++;
        }

//        orders.setOrderDetailList(orderDetailList);
        
        //Open the Session
        Session session = sf.openSession();
        Transaction tr = null;
        
        try {
            //Begin the transaction
            tr = session.beginTransaction();
            ordersDAO.setSession(session);
            boolean isAdded = ordersDAO.add(orders);       // Add Orders
            if (isAdded) {
                orderDetailDAO.setSession(session);
                for (OrderDetail o : orderDetailList) {
                    o.getOrderDetail_PK().setOid(orders.getOid());  //Get OID from the saved Order's Object and set the OID in PK
                    isAdded=orderDetailDAO.add(o); //Add Order Details
                    if(!isAdded){
                        tr.rollback();
                        return false;
                    }
                }

                itemDAO.setSession(session);
                for (Item i : updateItemList) {
                    isAdded = itemDAO.update(i);  //Update the Item
                    if (!isAdded) {
                        tr.rollback();
                        return false;
                    }
                }

                tr.commit();
                return true;

            } else {
                tr.rollback();
                return false;
            }

        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }    

    @Override
    public boolean modifyOrder(List<OrderDetailDTO> list,List<ItemDTO> updateItem,OrdersDTO or,List<OrderDetailDTO> removeList) throws Exception {
        ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
        OrdersDAO ordersDAO = (OrdersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
        superDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);
        
        Session session=sf.openSession();
        Transaction tr=null;
        
        List<Item> updateItemList = new ArrayList<>();
        for (ItemDTO i : updateItem) {
            Item item = new Item(i.getItemCode(), i.getDescription(), i.getUnitPrice(), i.getQtyOnHand());
            updateItemList.add(item);
        }
        
        Orders order=new Orders(or.getOid(), or.getOrderDate(), or.getOrderPriority(), or.getCid());
        
        boolean result=false;
        try{
            tr=session.beginTransaction();
            superDAO.setSession(session);
            int count = 0;
            
            List<OrderDetail> newList=new ArrayList<>();
            for (OrderDetailDTO o : list) {
                OrderDetail od=new OrderDetail(updateItemList.get(count), order, o.getOrderQty());
                newList.add(od);
                result=superDAO.update(od);
                count++;
                if(!result){ 
                    tr.rollback();
                    return false;
                }
            }
            
            for (OrderDetailDTO o : removeList) {
                OrderDetail od=new OrderDetail(o.getItemCode(), o.getOid(), o.getOrderQty());
                result=superDAO.delete(od);
                if(!result){
                    tr.rollback();
                    return false;
                }
            }
            
//            ordersDAO.setSession(session);
//            order.setOrderDetailList(newList);
//            ordersDAO.update(order);
            
            itemDAO.setSession(session);
            for (Item i : updateItemList) {
            result = itemDAO.update(i);  //Update the Item
                if (!result) {
                    tr.rollback();
                    return false;
                }
            }
            tr.commit();
            return true;
        }catch(HibernateException e){
            if(tr!=null)tr.rollback();
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }

}
