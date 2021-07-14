package com.employees.employees;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeController employeeController;

    private static ObjectMapper mapper = new ObjectMapper();
    
    @Test
    public void testGetAllEmployees() throws Exception {
        List<Employee> employees = new ArrayList<Employee>();

        Date now = new Date();

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Nuno");
        employee.setAddress("Etz");
        employee.setBirthday( now );
        employee.setPosition( new Position(1, "Java Developer") );
        employee.setStatus( new Status(1, "OK") );

        employees.add(employee);
        Mockito.when( employeeController.getAllEmployees() ).thenReturn( new ResponseEntity<>(employees, HttpStatus.OK) );
        mockMvc.perform( 
            get("/employee/getall") 
        ).
        andExpect( 
            status().isOk()
        ).
        andExpect(
            jsonPath("$", Matchers.hasSize(1))
        ).
        andExpect(
            jsonPath("$[0].name", Matchers.equalTo("Nuno"))
        )
        .andExpect(
            jsonPath("$[0].address", Matchers.equalTo("Etz"))
        )
        .andExpect(
            jsonPath("$[0].position.positionID", Matchers.equalTo(1))
        )
        .andExpect(
            jsonPath("$[0].position.description", Matchers.equalTo("Java Developer"))
        )
        .andExpect(
            jsonPath("$[0].status.statusID", Matchers.equalTo(1))
        )
        .andExpect(
            jsonPath("$[0].status.description", Matchers.equalTo("OK"))
        );
    }

    @Test
    public void testPostEmployee() throws Exception {
        Date now = new Date();

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Nuno");
        employee.setAddress("ETZ");
        employee.setBirthday( now );
        employee.setPosition( new Position(1, "Java Developer") );
        employee.setStatus( new Status(1, "OK") );

        Mockito.when(employeeController.saveEmployee(ArgumentMatchers.any())).thenReturn( new ResponseEntity<>(employee, HttpStatus.CREATED) );
        String json = mapper.writeValueAsString(employee);
        mockMvc.perform(
            post("/employee/add").contentType(MediaType.APPLICATION_JSON)
            .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
            .andExpect(
                jsonPath("$.id", Matchers.equalTo(1))
            )
            .andExpect(
                jsonPath("$.name", Matchers.equalTo("Nuno"))
            )
            .andExpect(
                jsonPath("$.address", Matchers.equalTo("ETZ"))
            );
    }

    @Test
    public void testPutEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setId(2);
        employee.setName("Nuno");

        Mockito.when(employeeController.editEmployee(ArgumentMatchers.any(), ArgumentMatchers.anyInt() )).thenReturn( new ResponseEntity<>(employee, HttpStatus.OK) );
        String json = mapper.writeValueAsString(employee);
        mockMvc.perform(
            put("/employee/edit/{id}", 1 ).contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
            .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
            .andExpect(
                jsonPath("$.id", Matchers.equalTo(2))
            )
            .andExpect(
                jsonPath("$.name", Matchers.equalTo("Nuno"))
            );
    }
 
    @Test
    public void testDeleteEmployee() throws Exception {
        Mockito.when(employeeController.deleteEmployee(ArgumentMatchers.anyInt())).thenReturn( new ResponseEntity<>("Employee Successfully Removed", HttpStatus.OK) );

        MvcResult requestResult = mockMvc.perform(delete("/employee/delete/{id}", ArgumentMatchers.anyInt() ))
                .andExpect(
                    status().isOk()).andExpect(status().isOk()
                ).andReturn();
        String result = requestResult.getResponse().getContentAsString();
        assertEquals(result, "Employee Successfully Removed");
    }

}
