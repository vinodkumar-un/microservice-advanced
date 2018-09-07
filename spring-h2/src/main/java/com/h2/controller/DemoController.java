package com.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/createTable")
	public void createTable() {

		try {
			jdbcTemplate.execute("create table customers(id SERIAL, name VARCHAR2(10), age VARCHAR2(20))");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@PutMapping("/putData")
	public void putData() {
		jdbcTemplate.execute("insert into customers values(1, 'vinod', '26')");
	}

}
