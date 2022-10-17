package com.example.demo;




import javax.persistence.CascadeType;
//import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Users {
	@Id 
	private Long id;
	private String username;
	private String email;
	private int active;
	private String password;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "code_id")
    private Code code;
	

}
