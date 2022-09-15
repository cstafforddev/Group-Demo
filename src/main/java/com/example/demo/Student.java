package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
/*@Entity-it tells the hibernate layer to create a table with the name same as the pojo class
 *@Id-It tell the hibernate layer to create a column with a primary key  
 *@Column- It tell the hibernate layer to create a column
 * 
 * */
@Data
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int sid;
@Column(name="sname")
private String name;
private String email;
private String phoneno;
	// TODO Auto-generated method stub
	
}


