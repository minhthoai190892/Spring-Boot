package com.example.rest03createacontroller.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    // @JsonProperty("full_name") //thay đổi tên trường khi sử dụng
    private String name;
    @Column(name = "age")
    // @JsonIgnore //đánh dấu ẩn tên trường
    private Long age;
    @Column(name = "location")
    private String location;
    @Column(name = "email")
    private String email;
    @Column(name = "department")
    private String department;
}
