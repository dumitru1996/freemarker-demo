<employee>
    <id>${id}</id>
    <name>${name?upper_case}</name>
    <email>${email!"N/A"}</email>
    <role>${role?capitalize}</role>
    <salary>${salary}</salary>
    <departmentType>
        <#if department == "Engineering">Technical<#elseif department == "HR">Administrative<#else>General</#if>
    </departmentType>
    <isActive>
        <#if isActive??> ${isActive?string("true", "false")}<#else>unknown</#if>
    </isActive>
    <joiningDate>
        <#if joiningDate??>${joiningDate?date("yyyy-MM-dd")}<#else>Not Specified</#if>
    </joiningDate>
    <salaryLevel>
        <#if salary gte 80000>High-Level
        <#elseif salary gte 50000>Mid-Level
        <#else>Entry-Level</#if>
    </salaryLevel>
    <skills>
        <#list skills as skill>
            <skill>${skill.name?capitalize}</skill>
        </#list>
    </skills>
</employee>
