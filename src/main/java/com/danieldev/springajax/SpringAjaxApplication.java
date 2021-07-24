package com.danieldev.springajax;

import com.danieldev.springajax.service.SocialMetaTagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAjaxApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringAjaxApplication.class, args);
	}

	@Autowired
	SocialMetaTagService service;

	public void run(String... args) throws Exception {
		
	}

}
