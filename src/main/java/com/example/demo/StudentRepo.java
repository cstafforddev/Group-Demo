package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
                                    //pojo class name,Integer
public interface StudentRepo extends JpaRepository<Student,Integer> {

}

