package com.example.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
public class User {
	
	
//	@Id
//	@TableGenerator(name="tbl_user_gen",table="tbl_user_id",
//	pkColumnName = "pk_id_name",pkColumnValue = "user_pk",
//	initialValue = 202400,allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.TABLE,generator = "tbl_user_gen")
//	private int id;
//	private String name;
//	private String email;
//	private String password;
//	private String phone;
//	public User() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private String phone;
	public User() {
		super();
	}

	
}
