package com.example.demo;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UsersService {
	  @Autowired
    private UsersRepository usersRepository;

	  @Transactional

	  public int getActive( ResetPassword resetPassword){
			return usersRepository.getActive(resetPassword.getEmail());
		}
	  @Transactional
	    public void addUser(Users users){
	        usersRepository.save(users);
	    }
	  
	  @Transactional
	  public  void SetActive(ResetPassword resetPassword) {
		   usersRepository.SetActive(resetPassword.getEmail());
		  
	  }
	  @Transactional
	  public boolean ifEmailExist(String email){
	        return usersRepository.existsByEmail(email);
	    }
	  public Users getUserByMail(String mail){
	        return this.usersRepository.findByEmail(mail);
	    }
	    public void editUser(Users users){
	        this.usersRepository.save(users);
	    }

   
   
   
}
