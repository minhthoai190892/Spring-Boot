package com.example.rest03createacontroller.controller;

import com.example.rest03createacontroller.entity.Employee;
import com.example.rest03createacontroller.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//nhận biết class controller
//@Controller
@RestController // @Controller+ @ResponseBody
@RequestMapping("/api/v1")//http://localhost:8080/api/v1/employeess
public class EmployeeController {
    //tạo trường service
    private EmployeeService service;

    //injection
    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @Value("${app.name}")
    private String appName;
    @Value("${app.verson}")
    private String verson;

    @GetMapping("/infoApp")
    public String getInforApp() {
        return appName + " " + verson;
    }


    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String getEmployees() {
        return "Display the list of employees with @RequestMapping(value = \"/employees\",method = RequestMethod.GET)";
    }

    @GetMapping("/employeess")
//    http://localhost:8080/employeess
    public ResponseEntity<List<Employee>> getEmployees1(@RequestParam Integer pageNumber,@RequestParam Integer pageSize) {
        return new ResponseEntity<List<Employee>>(service.getEmployees(pageNumber,pageSize), HttpStatus.OK);
    }

    @GetMapping("/employeess/{id}")
//    http://localhost:8080/employeess/12
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        System.out.println("Fetching the employee details for id " + id);
        return new ResponseEntity<>(service.getSingleEmployee(id), HttpStatus.OK);
    }

    @DeleteMapping("/employeess")
//    http://localhost:8080/employeess?id=78
    //check on Postman
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long id) {
        System.out.println("Deleting the employee details for the id " + id);
        service.deleteEmployee(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/employeess")
//    http://localhost:8080/employeess
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        System.out.println("save the employee details to the database " + employee);

        return new ResponseEntity<Employee>(service.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employeess/{id}")
//    http://localhost:8080/employeess/2
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        System.out.println("Updating the employee data for the id " + id);
        employee.setId(id);
        return new ResponseEntity<>(service.updateEmployee(employee), HttpStatus.OK);
    }

    @GetMapping("/employeess/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
        return new ResponseEntity<>(service.getEmployeesByName(name), HttpStatus.OK);
    }
    @GetMapping("/employeess/findByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name, @RequestParam String location){
    return new ResponseEntity<>(service.getEmployeeByNameAndLocation(name,location),HttpStatus.OK);
    }
    @GetMapping("/employeess/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeeByKeyword(@RequestParam String name){
        return new ResponseEntity<>(service.getEmployeesByKeyword(name),HttpStatus.OK);
    }
}




