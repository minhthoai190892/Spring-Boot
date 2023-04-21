package com.example.rest03createacontroller.entity;

import com.example.rest03createacontroller.request.EmployeeManyRequest;
import com.example.rest03createacontroller.request.EmployeeRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

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
    // @NotNull(message = "Name can not null")
    @Column(name = "name")
    // @JsonProperty("full_name") //thay đổi tên trường khi sử dụng
    private String name;
    @Column(name = "age")
    // @JsonIgnore //đánh dấu ẩn tên trường
    private Long age;
    @Column(name = "location")
    // @NotBlank(message = "Location not blank")
    private String location;
    @Column(name = "email")
    // @Email(message = "Email invalid")
    private String email;
    @OneToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(EmployeeRequest request) {
        this.name = request.getName();

    }

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private Date createAt;
    @UpdateTimestamp
    @Column(name = "update_at")
    private Date updateAt;

    @OneToMany(mappedBy = "employee")
    private List<DepartmentMany> departmentManyList;

    public Employee(EmployeeManyRequest employeeManyRequest) {
        this.name = employeeManyRequest.getName();
    }
}
