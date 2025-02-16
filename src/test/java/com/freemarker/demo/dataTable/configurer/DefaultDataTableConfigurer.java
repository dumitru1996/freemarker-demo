package com.freemarker.demo.dataTable.configurer;

import com.freemarker.demo.dataTable.RequestOfUser;
import com.freemarker.demo.dataTable.Skill;
import io.cucumber.java.DataTableType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultDataTableConfigurer {

    @DataTableType
    public RequestOfUser requestOfUserTransformer(Map<String, String> row) {
        return new RequestOfUser(
                row.get("id") != null ? Integer.parseInt(row.get("id")) : null,
                row.get("name") != null ? row.get("name") : null,
                row.get("email") != null ? row.get("email") : null,
                row.get("role") != null ? row.get("role") : null,
                row.get("salary") != null ? Double.parseDouble(row.get("salary")) : null,
                row.get("department") != null ? row.get("department") : null,
                row.get("isActive") != null ? Boolean.valueOf(row.get("isActive")) : null,
                row.get("joiningDate") != null ? row.get("joiningDate") : null,
                row.get("salaryLevel") != null ? row.get("salaryLevel") : null,
                row.get("skills") != null ? Stream.of(row.get("skills").split(",")).map(Skill::new).collect(Collectors.toList()) : null
        );
    }
}