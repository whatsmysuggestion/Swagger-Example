package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;

@RestController
public class HelloController {
	
	@Autowired
	Environment env;
	
	
	@Value("${spring.application.name}")
	String appName;
	
	//@Value("${server.port}")
	int port;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String sayHello() {
		return "Swagger Hello World";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public String addition(@RequestParam(name = "ename",required = false, defaultValue = "xyz") String name,@RequestParam(name = "sal") int a,@RequestParam(name = "bonus") int b) {
		
		int c=a+b;

		return "Employee With Name "+name+"  Got Salary:- "+c;
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/sub/{ename}/{first}/{second}")

	public String sub(@PathVariable(name = "ename") String name,@PathVariable("first")  int a,@PathVariable("second") int b) {
		
		int c=a+b;

		return "Employee With Name "+name+"  Got Salary:- "+c;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/nameTest")

	public String nameTest(@RequestBody User user) {
		
		 port=Integer.parseInt(env.getProperty("server.port"));
		return user.getEname()+"   "+port+"  "+appName;
	}
	
	
}