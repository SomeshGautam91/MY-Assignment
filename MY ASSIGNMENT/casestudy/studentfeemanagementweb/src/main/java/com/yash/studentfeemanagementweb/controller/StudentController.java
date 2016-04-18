package com.yash.studentfeemanagementweb.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yash.studentfeemanagementform.form.Student;
import com.yash.studentfeemanagementlogger.logger.Log;
import com.yash.studentfeemanagementservice.service.StudentServiceIfc;




/**
 * @author somesh.kumar
 *This class represents student controller
 */

@Controller
@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired
	StudentServiceIfc studentService;
	
	/**
	 * empty student list
	 */
	List<Student> students=null;
	
	/**
	 * @param model
	 * @return list of students 
	 * This method receive data from form ,save into student model and pass it to service
	 */
	@ResponseBody
	@RequestMapping(value = "/studentregistrationpage",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudentRegistration(@RequestBody Student student) {
		
		Log.getlog().info("getStudentRegistration started");
		System.out.println(student.getMonth()+student.getPaidAmount());
		students=studentService.saveStudent(student);
		Log.getlog().info("getStudentRegistration End");
		return students;

	
	}
	
	/**
	 * @param index
	 * @return list of students
	 * This method receive student id from form, pass it to service
	 */
	@ResponseBody
	@RequestMapping(value="/deleteStudentUsingId/{index}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> deleteStudentUsingId(@PathVariable("index") int index)
	{
		Log.getlog().info("deleteStudentUsingId started");
		System.out.println("Index is "+ index);
		students=studentService.deleteStudent(index);
		Log.getlog().info("deleteStudentUsingId End");
		return students;
		
	}
	/**
	 * @param student
	 * @return list of students
	 * this method receive Student model from form,pass it to service
	 */
	@ResponseBody
	@RequestMapping(value="/updateStudentUsingId",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> updateStudentUsingId(@RequestBody Student student)
	{
		Log.getlog().info("updateStudentUsingId started");
		System.out.println("student fee month "+ student.getMonth()+student.getStudentId());
		students=studentService.updateStudent(student);
		Log.getlog().info("updateStudentUsingId End");
		return students;
		
	}
	
	/**
	 * @param searchData
	 * @return list of students
	 * This method receive searchdata from form,pass it to service
	 */
	@ResponseBody
	@RequestMapping(value="/searchStudent/{searchData}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> searchStudent(@PathVariable("searchData") String searchData)
	{
		Log.getlog().info("searchStudent started");
		System.out.println(" SearchDataInController "+searchData);
		students=studentService.searchStudent(searchData);
		Log.getlog().info("searchStudent End");
		return students;
		
		
	}

	@ResponseBody
	@RequestMapping(value="/unpaidStudents",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getUnpaidStudent()
	{
		Log.getlog().info("getUnpaidStudent started");
		students=studentService.searchUnpaidStudent();
		Log.getlog().info("getUnpaidStudent End");
		return students;
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="/paidStudents",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getPaidStudent()
	{
		Log.getlog().info("getUnpaidStudent started");
		students=studentService.searchPaidStudent();
		Log.getlog().info("getUnpaidStudent End");
		return students;
		
		
	}
	
}
