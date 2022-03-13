package com.springrestD.springrestD.services;

import java.util.List;

import com.springrestD.springrestD.entities.Course;

public interface CourseService {

	// Step 11 - we'll create an abstract method (getCourses())  that would return a list of courses
	public List<Course> getCourses(); // Since we can't give body to an interface; we will use this for loose coupling for ease coupling
										// Loose coupling coz if we want to make any changes later then we can just make changes 
										// in the implementation class( CourseServiceIMPL ) and we wont need to make changes in controller class( MyController )
	
	
	//Step 12 - We'll create a new class That will implement the interface CourseService 
	// right click on the same package com.springrestD.springrestD.services and 
	// select create New class ( CourseServiceIMPL ), click on Add to add the interface CourseService, then click Finish
	
	
	public Course getCourse(long courseId);  //Step 22 - we'll create an abstract method (getCourse())  that would return the single course by id


	public Course addCourse(Course cors);    //Step 26 - we'll create an abstract method (addCourse())  that would return the courses


	public Course updateCourse(Course cors);


	public void deleteCourse(long parseLong);
	
	// (Step 13 in CourseServiceIMPL.java)
	// (Step 23 in CourseServiceIMPL.java)
	// (Step 27 in CourseServiceIMPL.java)
}
