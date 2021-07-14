package com.employees.employees;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int positionID;
    
    private String description;

    @OneToMany(mappedBy = "position")
    private List<Employee> employees;

    protected Position() {}

    public Position(int positionID, String description){
        this.positionID = positionID;
        this.description = description;
    }

    public int getPositionID() {
        return positionID;
    }

    public String getDescription() {
        return description;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        String position = "ID: "+this.positionID+" | Desc: "+this.description;
        return position;
    }
}
