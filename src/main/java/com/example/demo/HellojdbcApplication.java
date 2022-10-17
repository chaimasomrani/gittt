package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellojdbcApplication implements CommandLineRunner {
	@Autowired
	UsersRepository usersRepository;
	public static void main(String[] args) {
		SpringApplication.run(HellojdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//usersRepository.save(new Users("zina","CHAIMA5",0));
		//usersRepository.save(new Users("mohamed","chaima",1));
		//usersRepository.getActive("hvg");
		//usersRepository.find
/*.forEach((u->{
	System.out.println(u.toString());
})); */		
		
	}

}
