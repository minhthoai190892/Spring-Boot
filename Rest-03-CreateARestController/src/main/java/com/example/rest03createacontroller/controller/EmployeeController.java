package com.example.rest03createacontroller.controller;

import com.example.rest03createacontroller.entity.Employee;
import com.example.rest03createacontroller.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public List<Employee> getEmployees1() {
       return service.getEmployees();
    }

    @GetMapping("/employeess/{id}")
//    http://localhost:8080/employeess/12
    public Employee getEmployee(@PathVariable Long id) {
        System.out.println("Fetching the employee details for id " + id);
        return service.getSingleEmployee(id);
    }

    @DeleteMapping("/employeess")
//    http://localhost:8080/employeess?id=78
    //check on Postman
    public void deleteEmployee(@RequestParam("id") Long id) {
        System.out.println( "Deleting the employee details for the id " + id);
          service.deleteEmployee(id);
    }

    @PostMapping("/employeess")
//    http://localhost:8080/employeess
    public Employee saveEmployee(@RequestBody Employee employee) {
        System.out.println("save the employee details to the database " + employee);
        return service.saveEmployee(employee);
    }

    @PutMapping("/employeess/{id}")
//    http://localhost:8080/employeess/2
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        System.out.println("Updating the employee data for the id " + id);
        return employee;
    }
}




