package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// 该注解 发现注解@Scheduled的任务并后台执行
@EnableScheduling
@MapperScan("com.example.demo.mapper")

public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
		int i=12227225522;        int h=3553;}
/*@SpringBootApplication  
@RestController  
@ServletComponentScan
@MapperScan("com.example.demo.mapper")
public class DemoApplication extends SpringBootServletInitializer{  
    @RequestMapping("/")  
    public String home(){  
      return "hello wor   圣诞节就冻死了ld";    }  
  
    public static void main(String[] args) {  
        SpringApplication.run(DemoApplication.class, args);  
    }  
}  */
