/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 *
 * @author Hansani Kariyawasam
 */
@Entity
public class OrderDetail extends SuperEntity{
    @EmbeddedId
    private OrderDetail_PK orderDetail_PK;
    
    @Column(name = "OrderQty")
    private int orderQty;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "oid",referencedColumnName = "oid",insertable = false,updatable = false))
    private Orders orders;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "itemCode",referencedColumnName = "itemCode",insertable = false,updatable = false))
    private Item item;

    public OrderDetail() {
    }

    public OrderDetail(int itemCode,int oid, int orderQty) {
        this.orderDetail_PK = new OrderDetail_PK(oid, itemCode);
        this.orderQty = orderQty;
    }
    
    public OrderDetail(Item item, Orders orders, int orderQty){
        this.item=item;
        this.orders=orders;
        this.orderDetail_PK=new OrderDetail_PK(orders.getOid(), item.getItemCode());
        this.orderQty = orderQty;
    }
    
    

    public OrderDetail(OrderDetail_PK orderDetail_PK, int orderQty, Orders orders, Item item) {
        this.orderDetail_PK = orderDetail_PK;
        this.orderQty = orderQty;
        this.orders = orders;
        this.item = item;
    }

    public OrderDetail_PK getOrderDetail_PK() {
        return orderDetail_PK;
    }

    public void setOrderDetail_PK(OrderDetail_PK orderDetail_PK) {
        this.orderDetail_PK = orderDetail_PK;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "orderDetail_PK=" + orderDetail_PK + ", orderQty=" + orderQty + ", orders=" + orders + ", item=" + item + '}';
    }
    
    
}
