# BREAKDOWN OF SCHOOL MANAGEMENT SYSTEM

## HOW TO RUN

### BACKEND RESTFUL API - SPRING BOOT JAVA

git pull into your working folder. 

reload dependencies via maven, environment tested in: java 11 version

make sure applications.properties has the right credentials for DB as well as the postgres version

<!- I am using POSTGRES with a database called school_management_system -!!>

run build from SchoolManagementSystemApplicationClass


### FRONT END - NEXT JS

git pull from and follow the instruction. ensure that it runs on port 8080 on server side and port 3000 on the front end. 

remember to run npm commands in the readme.md

You can configure both in the configs' folder in the next js app or configure the CORS on the security/securityconfig class

Some of the pictures from the rendering of next js front end can be found at: https://drive.google.com/drive/folders/1qGFygwS9lbSowxMCGalx7I_9GyPdC-iG?usp=sharing

## PROBLEM DEFINITION

Learning institution management is key to the success of both the learners, staff, and the owners. (ideal)

Currently, most parts of the institution are managed manually using the old filing system. (reality)

The incremental filing and loss associated with manual filing is high. This leads to both high financial cost, and broken view of the institution running. (consequences)

To reduce this, save cost, and ensure efficiency, a school management system should be introduced. This way, managers, staff and parents can have a centralized manner of performing roles digitally. (proposal)

### USERS OF THE SYSTEM
- Parents
- Staff
- Adminstrator

### ACTIVITIES TO BE RECORDED
- Students crud
- Grade crud
- Classrooms crud
- Staff crud

Main goal: automate data filing



## SYSTEM BREAKDOWN

### MODELS

User

- first_name
- second_name
- email
- phone
- password
- gender

users_roles

- role_id
- user_id

Role

- name

Settings 
- school_name
- school_slogan
- school_location
- school_phone
- school_email

Sessions

- year
- term
- active(boolean)

Subject 

- subject
- abbreviation
- grade_id
- active (boolean)

Fees

- class_id
- fee_name
- Amount
- currency
- session_id

Students

- first_name
- last_name
- dob
- nationality
- gender
- religion
- adm_no (unique, autogenerated)
- class
- parent_id

Parent_id

- user_id
- student_id 
- address

Staff

- user_id
- staff_id (unique, autogenerated)
- designation
- nationality

Class

- session_id
- name
- abbreviation
- active (boolean)
- grade_id
- staff_id

Grade

- name
- desc

Exam

- exam_type_id
- name
- start_date
- start_time
- end_time
- status
- staff_id

Exam Type

- name
- desc

Attendance

- date
- student_id
- status
- remarks
- staff_id

Schedule

- class_id
- subject_id
- date
- status
- start_time
- end_time
- staff_id

Exam Results

- exam_id
- student_id
- grade_points
- comments
- staff_id

Reports

- comments

reports_exam_results

- report_id
- exam_result_id



Finance

// Not Implemented

Salaries

- staff_id
- basic_pay
- category
- status

Allowances

- salary_id
- name
- type
- allowance

Deductions

- salary_id
- name
- type
- deduction

Collections

- student_id
- fee_id
- amount
- balance


### Functions

CRUD - users, roles, students, parents, staff, grade, subjects, sessions, classroom, exams, exam results, schedule, reports, settings

ROLE BASED ACCESS TO CRUD

## APPROACH

### BACKEND USING SPRING BOOT

set up db connection

set up models

set up corresponding JPA repository

set up services

    - StudentService

    - ParentService

    - TeacherService

    - AdminService

set up seeding DB CommandLiner

set up controllers for the rest api

set up custom authenication and authorisation using SpringBoot Security

<!-- Test run and debug through each step
 -->

 Test the RestControllers on Insomia or Postman

 ### FRONT END - NEXT JS

 Set up token authentication and authorisation

 Build components

 Set up pages based on user roles
 
 Test while building

### Things not implemented

Secure token for algorithm encryption

Brute force stop by checking number of unsuccessful login attempts

Factors such as refactoring. Some repeated code




# LESSONS FROM THE FEEDBACK ON THE INTERVIEW

## first things first

Understanding system architecture

https://www.youtube.com/watch?v=ScbSrUSbumo 

Keywords, precisely describing 

dont miss out all the functions

Operand - what generates the value

Attribute associated with the value. 

Example: Refrigerator

Food

Goal - reduce spoilage rate

Processes - Chilling, radiate, dry, preserving, marinating, smoking, vacuum packing the food or eating it :)

Form - its function } makes up the device

Always consider the elements of the system. for a fridge, its 

food

support structure

heat load

operator

Process is

Take the requirement, understand the breakdown the system

Factors such as 

security

performance

resource utilization

NASA Standards

- decomposition

    - understanding of technical requirements

    - conversion of the technical breakdown into models

Logical Decompostion

- input

- activities

- output

Does involve factors such as 

- Brainstorming

    - Should have a driving question


https://www.youtube.com/watch?v=OcB1NKX_kYw

- structural software system i.e. 

    - blueprint for building a software

    - breakdown components, relationship btwn components, data & algorithm structures,  data flow, control flow, dependancies etc

https://www.youtube.com/watch?v=_07NtoK-Kns

It's all about making systems simple. make it simple

Consider qualities: performance, availability, usability, scalability, safety

Technical 

- Monolithic

- Layed

- Microservices


TASK 

SCHOOL MANAGEMENT SYSTEM

- USAGE 

- USERS

- ENVIRONMENT
