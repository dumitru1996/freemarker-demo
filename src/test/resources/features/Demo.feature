@Run
Feature: Apache Freemarker examples

  Scenario Outline: Generate JSON file using Freemarker
    Given there is generated a file in JSON format
      | id   | name   | email   | role   | salary   | department   | isActive   | joiningDate   | salaryLevel   | skills   |
      | <id> | <name> | <email> | <role> | <salary> | <department> | <isActive> | <joiningDate> | <salaryLevel> | <skills> |
    Examples:
      | id  | name        | email              | role      | salary | department  | isActive | joiningDate | salaryLevel | skills                    |
      | 101 | John Doe    | johndoe@mail.com   | Developer | 85000  | Engineering | true     | 2025-01-26  | High-Level  | Java, Kotlin, Spring, SQL |
      | 102 | Alice Smith | alice@mail.com     | Manager   | 95000  | HR          | false    | 2024-12-15  | High-Level  | Leadership, Communication |
      | 103 | Bob Brown   | bob.brown@mail.com | Intern    | 45000  | Marketing   | true     | 2024-06-01  | Entry-Level | Social Media, Analytics   |
      | 104 | Jane Roe    |                    | Tester    | 55000  | QA          |          |             | Mid-Level   | Automation, JavaScript    |

  Scenario Outline: Generate SQL file using Freemarker
    Given there is generated a file in SQL format
      | id   | name   | email   | role   | salary   | department   | isActive   | joiningDate   | salaryLevel   | skills   |
      | <id> | <name> | <email> | <role> | <salary> | <department> | <isActive> | <joiningDate> | <salaryLevel> | <skills> |
    Examples:
      | id  | name        | email              | role      | salary | department  | isActive | joiningDate | salaryLevel | skills                    |
      | 101 | John Doe    | johndoe@mail.com   | Developer | 85000  | Engineering | true     | 2025-01-26  | High-Level  | Java, Kotlin, Spring, SQL |
      | 102 | Alice Smith | alice@mail.com     | Manager   | 95000  | HR          | false    | 2024-12-15  | High-Level  | Leadership, Communication |
      | 103 | Bob Brown   | bob.brown@mail.com | Intern    | 45000  | Marketing   | true     | 2024-06-01  | Entry-Level | Social Media, Analytics   |
      | 104 | Jane Roe    |                    | Tester    | 55000  | QA          |          |             | Mid-Level   | Automation, JavaScript    |

  Scenario Outline: Generate XML file using Freemarker
    Given there is generated a file in XML format
      | id   | name   | email   | role   | salary   | department   | isActive   | joiningDate   | salaryLevel   | skills   |
      | <id> | <name> | <email> | <role> | <salary> | <department> | <isActive> | <joiningDate> | <salaryLevel> | <skills> |
    Examples:
      | id  | name        | email              | role      | salary | department  | isActive | joiningDate | salaryLevel | skills                    |
      | 101 | John Doe    | johndoe@mail.com   | Developer | 85000  | Engineering | true     | 2025-01-26  | High-Level  | Java, Kotlin, Spring, SQL |
      | 102 | Alice Smith | alice@mail.com     | Manager   | 95000  | HR          | false    | 2024-12-15  | High-Level  | Leadership, Communication |
      | 103 | Bob Brown   | bob.brown@mail.com | Intern    | 45000  | Marketing   | true     | 2024-06-01  | Entry-Level | Social Media, Analytics   |
      | 104 | Jane Roe    |                    | Tester    | 55000  | QA          |          |             | Mid-Level   | Automation, JavaScript    |

