package com.example.SpringJDBCDemo;

import com.example.SpringJDBCDemo.model.Tabletest;
import com.example.SpringJDBCDemo.repo.TabletestRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

		List<String> list = Arrays.asList("hello", "world",null);
		List<String> upperCaseList = list.stream()
				.filter(s -> s != null)
				.map(String::toUpperCase)
				.collect(Collectors.toList());

		System.out.println(upperCaseList);
		List<Integer> numbers = new ArrayList<>();
		for(int i=0;i<=1000;i++) {
			numbers.add(i);
		}
/*
		for (int num :a) {
			System.out.println(num + " ");}
*/
		long count = numbers.parallelStream()
				.filter(n -> n > 100) // Correct filter condition
				.count();
		System.out.println("Count of numbers greater than 100: " + count);


	}
}