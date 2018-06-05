package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.common.entity.PageBean;
import com.example.demo.model.Person;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	private  Person person;
	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
	System.out.println(person.toString());	
	}

}
