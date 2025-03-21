package com.freemarker.demo.dataTable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class RequestOfUser {

    private Integer id;
    private String name;
    private String email;
    private String role;
    private Double salary;
    private String department;
    private Boolean isActive;
    private String joiningDate;
    private String salaryLevel;
    private List<Skill> skills;

}
