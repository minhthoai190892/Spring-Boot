package com.example.rest03createacontroller.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    private Long id;
    // @JsonProperty("full_name") //thay đổi tên trường khi sử dụng
    private String name;
    // @JsonIgnore //đánh dấu ẩn tên trường
    private Long age;
    private String location;
    private String email;
    private String department;
}




