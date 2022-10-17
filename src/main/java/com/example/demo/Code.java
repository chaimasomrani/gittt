package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Code  {
	@Id 
	private Long id;

    @Lob
    @Column(name = "code")
    private String Code;

    @OneToOne(mappedBy = "code")
    private Users users;

}
