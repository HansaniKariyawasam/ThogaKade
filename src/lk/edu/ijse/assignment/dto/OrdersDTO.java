/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.dto;

/**
 *
 * @author Hansani Kariyawasam
 */
public class OrdersDTO extends SuperDTO{
    private int oid;
    private String orderDate;
    private String orderPriority;
    private int cid;

    public OrdersDTO() {
    }

    public OrdersDTO(String orderDate, String orderPriority) {
        this.orderDate = orderDate;
        this.orderPriority = orderPriority;
    }

    public OrdersDTO(String orderDate, String orderPriority, int cid) {
        this.orderDate = orderDate;
        this.orderPriority = orderPriority;
        this.cid = cid;
    }

    public OrdersDTO(int oid, String orderDate, String orderPriority, int cid) {
        this.oid = oid;
        this.orderDate = orderDate;
        this.orderPriority = orderPriority;
        this.cid = cid;
    }
    
    

    public OrdersDTO(int oid, String orderDate, String orderPriority) {
        this.oid = oid;
        this.orderDate = orderDate;
        this.orderPriority = orderPriority;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
    
    

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(String orderPriority) {
        this.orderPriority = orderPriority;
    }
    
    
}
