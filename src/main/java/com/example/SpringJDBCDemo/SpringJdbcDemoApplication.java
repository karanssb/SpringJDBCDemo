package com.example.SpringJDBCDemo;

import com.example.SpringJDBCDemo.model.Tabletest;
import com.example.SpringJDBCDemo.repo.TabletestRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);

		Tabletest tabletest1 = context.getBean(Tabletest.class);
		tabletest1.setId(111);
		tabletest1.setName("first record");
		tabletest1.setTech("java");

		TabletestRepo repo = context.getBean(TabletestRepo.class);
		repo.save(tabletest1);
		System.out.println(repo.findAll());

	}
}