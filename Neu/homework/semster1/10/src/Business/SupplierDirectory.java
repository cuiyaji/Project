/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Abstract.User;
import Business.Users.Supplier;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harshalneelkamal
 */
public class SupplierDirectory {
    
    private List<User> supplierList;
    
    public SupplierDirectory(){
        supplierList = new ArrayList<>();
    }

    public List<User> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(List<User> supplierList) {
        this.supplierList = supplierList;
    }
    /*
    public Supplier addCustomer(String password, String userName){
        Supplier s = new Supplier(password, userName);
        supplierList.add(s);
        return s; 
    }
    
    public void removeCustomer(Supplier s){
        supplierList.remove(s);
    }
    
    public User searchCustomer(String keyword){
        for (User supplier : supplierList) {
            if(supplier.getUserName().equals(keyword)){
                return supplier;
            }
        }
        return null;
    }
    */
}
