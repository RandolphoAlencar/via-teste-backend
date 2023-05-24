package com.randolphoalencar.viatestebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.randolphoalencar.viatestebackend.cmdapi.views.MainView;

@SpringBootApplication
public class ViatestebackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViatestebackendApplication.class, args);

		MainView.printMainView();
		
	}
}