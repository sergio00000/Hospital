# **Getting Started**

### **What this is**

This project is a simple Rest webservice for a tech challenge. In this project is a Springboot application, with a Postgres database, orchestrated with docker.
The objective is to create a simple webservice with an API to get, insert, update and delete information.

It's a simple case of a hospital, that needs management of patients, doctors and consults. Every consult must have a doctor, speciality and patient associated.


### **Requirements**

 - Maven
 - Java 17
 - Docker

### **Start-up**

Run the following commands in the command line:

    - mvn clean install 
    - docker build -t challenge-1.0.0.jar .
    - docker-compose up

### **Endpoints**
