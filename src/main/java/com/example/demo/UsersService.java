package com.example.demo;



public interface UsersService {
	 public int getActive(ResetPassword resetPassword);
	 void SetActive(ResetPassword resetPassword);
	 public boolean ifEmailExist(String email);
	 public Users getUserByMail(String mail);
	 public void editUser(Users users);
	 public void addUser(Users users);
}
