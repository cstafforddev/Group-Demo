package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDAO {
	@Autowired
	StudentRepo repo;
	
	//insert
	public Student insert(Student s) {
		return repo.save(s);
	}
	
	//get the data
	public List<Student> getAll() {
		return repo.findAll();
	}
	
	//delete a row
	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
	//update
	//in a table 1 Shane 9999999999 sh@c.c
	//update     1 Rahman 9999999999 sh@c.c
	/*
	 * from the table find the row 
	 * update the attribute
	 * insert it again
	 */
	                     //1 Rahman 9999999999 sh@c.c 
	public Student updateName(Student s) {
		Student ss = repo.findById(s.getSid()).orElse(null); //1 Shane 9999999999 sh@c.c
		ss.setName(s.getName());
		return repo.save(ss);
	}
}
