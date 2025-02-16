package com.freemarker.demo.dataTable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Skill {
    private String name;


    public String getSkillNameUppercase() {
        return this.name.toUpperCase();
    }
}
