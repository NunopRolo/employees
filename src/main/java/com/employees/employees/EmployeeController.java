package com.employees.employees;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/getall")
    public ResponseEntity< List<Employee> > getAllEmployees() {

        try{
            List<Employee> list = employeeRepository.findAll();

            if(list.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("/getemployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
    {
        try{
            Optional<Employee> employee = employeeRepository.findById(id);
            if(employee.isPresent())
                return new ResponseEntity<>(employee.get() , HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee newEmployee) throws Exception
    {
        try{
            return new ResponseEntity<>(employeeRepository.save(newEmployee), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Employee> editEmployee(@RequestBody Employee newEmployee, @PathVariable int id) throws Exception
    {

        try{
            Optional<Employee> employee = employeeRepository.findById(id);
            if(employee.isPresent()){
                Employee employee_res = employee.get();

                String address = newEmployee.getAddress(); 
                if(address != null){
                    employee_res.setAddress( address );
                }
                
                Date birthday = newEmployee.getBirthday();  
                if(birthday != null){
                    employee_res.setBirthday( birthday );
                }

                String name = newEmployee.getName();
                if(name != null){
                    employee_res.setName( name );
                }

                Position position = newEmployee.getPosition();
                if(position != null){
                    employee_res.setPosition( position );
                }

                Status status = newEmployee.getStatus();
                if(status != null){
                    employee_res.setStatus( status );
                }

                employee_res.setUpdated( new Date() );

                return new ResponseEntity<>(employeeRepository.save(employee_res) , HttpStatus.OK);
            }
                
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) throws Exception
    {
        try{
            employeeRepository.deleteById(id);

            return new ResponseEntity<>("Employee Successfully Removed", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

}
