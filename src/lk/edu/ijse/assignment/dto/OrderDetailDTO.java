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
public class OrderDetailDTO extends SuperDTO{
    private int itemCode;
    private int oid;
    private int orderQty;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO( int orderQty) {
        this.orderQty = orderQty;
    }

    
    public OrderDetailDTO(int itemCode, int oid, int orderQty) {
        this.itemCode = itemCode;
        this.oid = oid;
        this.orderQty = orderQty;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }
    
    
}
