/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Hansani Kariyawasam
 */
@Embeddable
public class OrderDetail_PK implements Serializable{
    private int oid;
    private int itemCode;

    public OrderDetail_PK() {
    }

    public OrderDetail_PK(int oid, int itemCode) {
        this.oid = oid;
        this.itemCode = itemCode;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }
    
    
}
