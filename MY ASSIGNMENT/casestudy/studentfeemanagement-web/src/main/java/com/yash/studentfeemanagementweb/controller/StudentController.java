package com.yash.studentfeemanagementweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yash.studentfeemanagementform.form.Student;




/**
 * @author somesh.kumar
 *This class represents student controller
 */

@Controller
@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired

	
	
	
	/**
	 * @param model
	 * @return student registration page
	 */
	
	
	@ResponseBody
	@RequestMapping(value = "/studentregistrationpage",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudentRegistration(@RequestBody Student student) {
		
		System.out.println("inside Controller");
		List<Student> students=studentService.saveStudent(student);
		return students;

	
	}

}
