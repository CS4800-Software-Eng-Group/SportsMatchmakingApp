package com.example.demo;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringsportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsportsApplication.class, args);
	}

	@Bean(initMethod="start",destroyMethod="stop")
	public org.h2.tools.Server h2WebConsoleServer () throws SQLException {
		return org.h2.tools.Server.createWebServer("-web","-webAllowOthers","-webDaemon","-webPort", "8080");
	}
}
