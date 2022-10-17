package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users,Long> {

	//List<Users> findByEmail(String email); hedhy shyha zeda
	//List<Users> findByEmailContaining(String email);
	
	/*
	@Query("SELECT Users.active FROM Users  WHERE email=?1") 
	 int getActive(String email);*/
	
	 @Query("select u.active from Users u where u.email=?1")
	    public int getActive(String email);
	 @Transactional
	 @Modifying
	 @Query("update Users u SET u.active=1 WHERE u.email=?1")
	 void SetActive(String email);
	   // public void SetActive(String email);
	 public boolean existsByEmail(String email);
	 public Users findByEmail(String email);


	 
	 

	 
	 
	
	
}
