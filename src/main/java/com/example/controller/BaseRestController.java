package com.example.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.repo.StudentRepo;
import com.example.exception.ResponseNotFound;

@RestController
public class BaseRestController {
	
	@Autowired private StudentRepo sr;
	
	@GetMapping("/home")
	public String index() {
		return "hello world3";
	}
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student s) {
		
		
		return new ResponseEntity<Student>(sr.save(s), HttpStatus.CREATED);
	}
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id){
		Student s = sr.findById(id).orElseThrow(()->new ResponseNotFound("Student2", "ID", id));
		return new ResponseEntity<Student>(s, HttpStatus.OK);
	}

}
