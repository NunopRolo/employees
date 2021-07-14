package com.employees.employees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeTest {

    @Test
    public void testSetterAndGetterId() throws Exception {
        Employee employee = new Employee();
        employee.setId(1);

        assertEquals(employee.getId(), 1);
    }

    @Test
    public void testSetterAndGetterName() throws Exception {
        String name = "Nuno";

        Employee employee = new Employee();
        employee.setName(name);

        assertEquals(employee.getName(), name);
    }

    @Test
    public void testSetterAndGetterAddress() throws Exception {
        String address = "Estremoz";

        Employee employee = new Employee();
        employee.setAddress(address);

        assertEquals(employee.getAddress(), address);
    }

    @Test
    public void testSetterAndGetterBirthday() throws Exception {
        Date birthday = new SimpleDateFormat("dd-MM-yyyy").parse("1998-05-08");  

        Employee employee = new Employee();
        employee.setBirthday(birthday);

        assertEquals(employee.getBirthday(), birthday);
    }

    @Test
    public void testSetterAndGetterPosition() throws Exception {
        Position position = new Position(1, "Java Developer");

        Employee employee = new Employee();
        employee.setPosition(position);

        assertEquals(employee.getPosition(), position);
    }

    @Test
    public void testSetterAndGetterStatus() throws Exception {
        Status status = new Status(1, "OK");

        Employee employee = new Employee();
        employee.setStatus(status);

        assertEquals(employee.getStatus(), status);
    }

    @Test
    public void testSetterAndGetterCreated() throws Exception {
        Date created = new Date();

        Employee employee = new Employee();
        employee.setCreated(created);

        assertEquals(employee.getCreated(), created);
    }

    @Test
    public void testSetterAndGetterUpdated() throws Exception {
        Date updated = new Date();

        Employee employee = new Employee();
        employee.setUpdated(updated);

        assertEquals(employee.getUpdated(), updated);
    }

}
