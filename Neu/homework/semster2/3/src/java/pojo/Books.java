/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Richard
 */
public class Books {
    private String name;
    
    
    public Books(){}
    
    public Books(String name){
        this.name = name;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     
    @Override
    public String toString() {
        return "Books{" + "name=" +name + '}';
    }
     
    
}
