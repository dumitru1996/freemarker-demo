<#ftl output_format="JSON">
{
    "id": ${id},
    "name": ${name},
    "email": "${email!"N/A"}",
    "role": "${role?capitalize}",
    "salary": "${salary}",
    "department": "${department}",
    "isActive":<#if isActive??> ${isActive?string("true", "false")}<#else> false</#if>,
    "joiningDate": "<#if joiningDate??>${joiningDate?date("yyyy-MM-dd")} <#else>Not Specified</#if>",
    "salaryLevel": <#if salary \gte 80000>"High-Level",<#elseif salary \gte 50000>"Mid-Level",<#else>"Entry-Level",</#if>
    "departmentType": <#if department == "Engineering">"Technical",<#elseif department == "HR">"Administrative",<#else>"General",</#if>
    "skills": [
    <#list skills as skill>
        "${skill.getSkillNameUppercase()}"<#sep>,</#sep>
    </#list>
    ],
    "additionalInfo": {
      <#include "employee_details_json.ftl">
    }
}