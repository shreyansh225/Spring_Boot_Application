package com.springrestD.springrestD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrestD.springrestD.entities.Course;
import com.springrestD.springrestD.services.CourseService;

// REST - Representational State Transfer - it sends data in the form of Json or xml format
           
// Step 3 - it is a controller of REST Service
@RestController
public class MyController //  Controller in Presentation layer and all the requests will come firstly to the controller in a maven project
{
	@Autowired                             // Step 18 - Spring will automatically create object and inject here for the implementation class(CourseServiceIMPL) of interface(CourseService)
	private CourseService courseService;  // Step 17 - created an interface type of variable since CourseService is the Parent of CourseServiceIMPL
										  // (Step 19 in CoursServiceIMPL.java)
	
	@GetMapping("/home")    // Example
	public String home() {
		return "Welcome to courses application";
	}

//Step 10 - right click on src/main.java and select create New interface ( CourseService ) Then in place of package write a sub-package com.springrestD.springrestD.services
// (Step 11 in CourseService.java)
	
	// get the courses    // import List from java.util
	@GetMapping("/courses")                       // Step 4 - right click on <Course> and select create new class (Course.java). Then create a new sub package com.springrestD.springrestD.entities
	public List<Course> getCourses()              // (Step 5 in Course.java)
	{             
	  // Step 16 - Need to Create an object to call the class(CourseServiceIMPL.java) of the service
		
		// Before calling this we need to create an object for CourseService in step 18
		return this.courseService.getCourses();   // Now the getCourses() method of the interface CourseService method will get called; 
													// and since there is no body for getCourses() in CourseService, it will call the getCourses() from the CourseServiceIMPL.java
	}
	
	// Step 20 - created a new method for getting/displaying a single course by id
	@GetMapping("/courses/{courseId}")    // {} curly braces coz we need the link by its Value
	public Course getCourse(@PathVariable String courseId) {   // Step 21 - @pathVariable annotation will help Spring understand that the String courseId can be dynamically passed from the link to the parameter
		// Course is the return Type here
		return this.courseService.getCourse(Long.parseLong(courseId));   // (Step 22 in CourseService.java)
	}
	
	// Step 25 - created a new method for posting/adding courses
	@PostMapping(path="/courses", consumes = "application/json")         // Step 29  - added path and consumes (not needed)
	public Course addCourse(@RequestBody Course cors) {   // Since we need the object(cors) of Course as its parameter
															// and since the object is coming from Request Body, therefore the annotation
		return this.courseService.addCourse(cors);      // (Step 26 in CourseService.java)
	}
	// Step 30  - make an object of Json and paste in Body-> Raw -> Json and hit SEND where the link is set to POST 
//	{
//        "id": 777,
//        "title": "React JS ",
//        "description": " This is React Course "
//	}
	
	@PutMapping("/courses")  // Will remove all the existing data except the data that is hard coded in the program and will update it with new data
	public Course updateCourse(@RequestBody Course cors) {
		
		return this.courseService.updateCourse(cors);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {    // To make a robust API we must also pass the HTTP status of the request 
		
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//return null;
		
		
	}
	
}
