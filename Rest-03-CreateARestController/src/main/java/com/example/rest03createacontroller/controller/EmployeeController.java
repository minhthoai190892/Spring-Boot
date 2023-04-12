package com.example.rest03createacontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//nhận biết class controller
//@Controller
@RestController // @Controller+ @ResponseBody
public class EmployeeController {
    //ánh xạ
//    localhost:
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
    public String getEmployee(@PathVariable("id")Long id){
        return "Fetching the employee details for id "+id;
    }
    @DeleteMapping("/employeess")
//    http://localhost:8080/employeess?id=78
    //check on Postman
    public String deleteEmployee(@RequestParam("id")Long id){
        return "Deleting the employee details for the id "+id;
    }
}
