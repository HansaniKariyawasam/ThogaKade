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
public class CustomerDTO extends SuperDTO{
    private int cid;
    private String customerName;
    private String address;
    private String tel;
    private String nic;

    public CustomerDTO() {
    }

    public CustomerDTO(String customerName, String address, String tel, String nic) {
        this.customerName = customerName;
        this.address = address;
        this.tel = tel;
        this.nic = nic;
    }

    public CustomerDTO(int cid, String customerName, String address, String tel, String nic) {
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
    
    
}
