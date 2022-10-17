package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	
	/*@GetMapping("/p")
	public List <Users> users(){
	return usersRepository.findAll();
	
	}
	@GetMapping("/p/act")
	public ResponseEntity<List<Users>> act(@RequestBody ResetPassword resetPassword){
		try {
		      List<Users> users = usersRepository.findByEmail(resetPassword.getEmail());
		     if (users.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(users, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
		//}*/
	@GetMapping("/active")
	public String getActiveUser(@RequestBody ResetPassword resetPassword) {
		UserActive userActive= new UserActive( userServiceImpl.getActive(resetPassword));
		if(userActive.getActive()==0) {
			return "Access Denided";
		}else {
			return "Hello!";
			
		}
		
		
		
		// return "Votre email est incorrect!";
		
		
	}
	
	@PostMapping("/block")
	public String setActiveUser(@RequestBody ResetPassword resetPassword) {
		userServiceImpl.SetActive(resetPassword);
		
			return "BLOCK!";
			
		}
	 @PostMapping("/checkEmail")
	    public AccountResponse resetPasswordEmail(@RequestBody ResetPassword resetPassword){
	        //Boolean result = this.userServiceImpl.ifEmailExist(resetPassword.getEmail());
		 Users users=this.userServiceImpl.getUserByMail( resetPassword.getEmail());
	        AccountResponse accountResponse = new AccountResponse();
	        
	        if(users !=null){
	            String code = UserCode.getCode();
	            Mail mail = new Mail(resetPassword.getEmail(),code);
	            emailServiceImpl.sendCodeByMail(mail);
	            users.getCode().setCode(code);
	            this.userServiceImpl.editUser(users);
	            accountResponse.setResult(1);
	        } else {
	            accountResponse.setResult(0);
	        }
	        return accountResponse;
	    }
	 @PostMapping("/resetPassword")
	    public AccountResponse resetPassword(@RequestBody NewPassword newPassword){
	        Users users = this.userServiceImpl.getUserByMail(newPassword.getEmail());
	        AccountResponse accountResponse = new AccountResponse();
	        if(users != null){
	            if(users.getCode().getCode().equals(newPassword.getCode())){
	            	users.setPassword(newPassword.getPassword());
	            	userServiceImpl.addUser(users);
	                accountResponse.setResult(1);
	            } else {
	                accountResponse.setResult(0);
	            }
	        } else {
	            accountResponse.setResult(0);
	        }
	        return accountResponse;
	    }
		
		
		// return "Votre email est incorrect!";
		
		
	}
	
	/*@GetMapping("/p/actt")
	public int getActive(@RequestBody ResetPassword resetPassword){
		return usersRepository.getActive(resetPassword.getEmail());
	}*/
