package com.example.rest03createacontroller.controller;

import com.example.rest03createacontroller.entity.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//nhận biết class controller
//@Controller
@RestController // @Controller+ @ResponseBody
public class EmployeeController {
    @Value("${app.name}")
    private String appName;
    @Value("${app.verson}")
    private String verson;
@GetMapping("/infoApp")
    public String getInforApp(){
        return appName+" "+verson;
    }


    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    public String getEmployees(){
        return "Display the list of employees with @RequestMapping(value = \"/employees\",method = RequestMethod.GET)";
    }
    @GetMapping("/employeess")
//    http://localhost:8080/employeess
    public String getEmployees1(){
        return "Display the list of employees with  @GetMapping(\"/employeess\")";
    }

    @GetMapping("/employeess/{id}")
//    http://localhost:8080/employeess/12
    public String getEmployee(@PathVariable Long id){
        return "Fetching the employee details for id "+id;
    }
    @DeleteMapping("/employeess")
//    http://localhost:8080/employeess?id=78
    //check on Postman
    public String deleteEmployee(@RequestParam("id")Long id){
        return "Deleting the employee details for the id "+id;
    }
    @PostMapping("/employeess")
//    http://localhost:8080/employeess
    public String saveEmployee(@RequestBody Employee employee){
        return "save the employee details to the database "+employee;
    }
    @PutMapping("/employeess/{id}")
//    http://localhost:8080/employeess/2
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        System.out.println("Updating the employee data for the id "+id);
        return employee;
    }
}




