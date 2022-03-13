package com.springrestD.springrestD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// (Step 1 in pom.xml) 
//Step 2 - right click on src/main.java and select create New class ( MyController.java ) Then in place of package write a sub-package com.springrestD.springrestD.controller
// (Step 3 in MyController.java) 

//  To run the application in Eclipse -> right click on SpringDApplication.java and Run As Java Application
// To run the application in STS-> right click on the project and Run As Spring Boot App
@SpringBootApplication
public class SpringrestDApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrestDApplication.class, args);
	}

}

// API Urls for the course App
//
//  Method         API Urls(Urls start with Base url)         Operation
//
//   GET                /courses                          Get all course
//   GET                /courses/{courseId}               Get single course of the given courseId in Url
//   POST               /courses                          Add new course
//   PUT                /courses                          Update the course
//  DELETE              /courses/{courseId}               Delete the course of the given courseId in the url