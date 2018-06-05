package com.example.demo.model;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@PropertySource(value = "classpath:config/person1.properties")
@Component 
@ConfigurationProperties(prefix ="person" )
public class Person {
	private Dog dog;
	private String age;
	private List<String> list;
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Person [dog=" + dog + ", age=" + age + ", list=" + list + "]";
	}
	
	


}
