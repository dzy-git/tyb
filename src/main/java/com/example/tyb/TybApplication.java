package com.example.tyb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.example.tyb.mapper","com.example.tyb.cmapper"})
public class TybApplication {

	public static void main(String[] args) {
		SpringApplication.run(TybApplication.class, args);
	}

}
