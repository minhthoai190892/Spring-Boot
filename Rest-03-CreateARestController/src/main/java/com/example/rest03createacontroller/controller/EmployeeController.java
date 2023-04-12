package com.example.rest03createacontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//nhận biết class controller
//@Controller
@RestController // @Controller+ @ResponseBody
public class EmployeeController {
    //ánh xạ
    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    public String getEmployees(){
        return "Display the list of employees with @RequestMapping(value = \"/employees\",method = RequestMethod.GET)";
    }
    @GetMapping("/employeess")
    public String getEmployees1(){
        return "Display the list of employees with  @GetMapping(\"/employeess\")";
    }
}
