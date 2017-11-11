/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Hansani Kariyawasam
 */
@Entity
public class Customer extends SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    @Column(name = "Name")
    private String customerName;
    @Column(name = "Address")
    private String address;
    @Column(name = "Contact")
    private String tel;
    @Column(name = "NIC")
    private String nic;

    public Customer() {
    }

    public Customer(String customerName, String address, String tel, String nic) {
        this.customerName = customerName;
        this.address = address;
        this.tel = tel;
        this.nic = nic;
    }

    public Customer(int cid, String customerName, String address, String tel, String nic) {
        this.cid = cid;
        this.customerName = customerName;
        this.address = address;
        this.tel = tel;
        this.nic = nic;
    }
    
    

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "Customer{" + "cid=" + cid + ", customerName=" + customerName + ", address=" + address + ", tel=" + tel + ", nic=" + nic + '}';
    }
    
   
    
}
