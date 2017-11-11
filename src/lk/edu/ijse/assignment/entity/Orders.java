/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Hansani Kariyawasam
 */
@Entity
public class Orders extends SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;
    @Column(name = "OrderDate")
    private String orderDate;
    @Column(name = "OrderPriority")
    private String orderPriority;
    private int cid;

    public Orders() {
    }

    public Orders(String orderDate, String orderPriority) {
        this.orderDate = orderDate;
        this.orderPriority = orderPriority;
    }
    

    public Orders(String orderDate, String orderPriority, int cid) {

        this.orderDate = orderDate;
        this.orderPriority = orderPriority;

        this.cid = cid;
    }

    public Orders(int oid, String orderDate, String orderPriority,int cid) {
        this.oid = oid;
        this.orderDate = orderDate;
        this.orderPriority = orderPriority;
        this.cid=cid;
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
