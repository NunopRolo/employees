package com.employees.employees;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int statusID;

    private String description;

    @OneToMany(mappedBy = "status")
    private List<Employee> employees;

    protected Status() {}

    public Status(int statusID, String description){
        this.statusID = statusID;
        this.description = description;
    }

    public int getStatusID() {
        return statusID;
    }

    public String getDescription() {
        return description;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        String status = "ID: "+this.statusID+" | Desc: "+this.description;
        return status;
    }
}
