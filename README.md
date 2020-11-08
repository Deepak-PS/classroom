# Smart Classroom

Technologies: Spring Boot, Java Message Service (JMS) using Apache ActiveMQ, JPA, Spring Security, Spring MVC, MySQL, Html5, JavaScript

This application demonstrates the sharing of "Notes" consisting of a title and body from the teacher (producer) to the student(s) (consumer). Each side will have the copy of the notes stored in the database.

It provides UI to send and receive the Notes. Screenshots of the workflow is available in the screenshots folder. The security mechanism used is BCryptPasswordEncoder. 
It also provides a role-based login for teachers and students. It allows only active members to log into the application.
