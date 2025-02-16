<#-- Assuming we have a table structure like this: -->
<#-- CREATE TABLE employees (
        id INT, name VARCHAR, email VARCHAR, role VARCHAR,
        salary DECIMAL, departmentType VARCHAR, isActive BOOLEAN,
        joiningDate DATE, salaryLevel VARCHAR, skills JSON
    ); -->

INSERT INTO employees (
id, name, email, role, salary, departmentType, isActive, joiningDate, salaryLevel, skills
) VALUES (
${id},
'${name?upper_case}',
'${email!"N/A"}',
'${role?capitalize}',
${salary},
'<#if department == "Engineering">Technical<#elseif department == "HR">Administrative<#else>General</#if>',
<#if isActive??><#if isActive>true<#else>false</#if><#else>NULL</#if>,
<#if joiningDate??>${joiningDate?date("yyyy-MM-dd")} <#else>Not Specified</#if>,
'<#if salary gte 80000>High-Level<#elseif salary gte 50000>Mid-Level<#else>Entry-Level</#if>',
'[<#list skills as skill>"${skill.name?capitalize}"<#if skill_has_next>, </#if></#list>]'
);
