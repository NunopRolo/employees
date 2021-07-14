package com.employees.employees;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeID;
    
    private String name;
    private Date birthday;
    private String address;

    @ManyToOne
	@JoinColumn(name="statusid")
    private Status status;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    @ManyToOne
	@JoinColumn(name="positionid")
    private Position position;

    protected Employee() {}

    public Employee(int employeeID, String name, Date birthday, String address, Status status, Position position, Date created, Date updated){
        this.employeeID = employeeID;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.status = status;
        this.position = position;
        this.created = created;
        this.updated = updated;
    }

    public int getId() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public Status getStatus() {
        return status;
    }

    public Position getPosition() {
        return position;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setId(int id) {
        this.employeeID = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String toString(){
        String employee = "ID: "+this.employeeID+" | Name: "+this.name+" | Birthday: "+this.birthday+" | Address: "+this.address+" | Position: "+this.position+" | Status: "+this.status+" | Created: "+this.created+" | Updated: "+this.updated;
        return employee;
    }

}
