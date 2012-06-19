package com.vzb.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Entity
@Table(name="tbl_user_profile")
@Data
public class UserProfile implements Serializable {

	private static final long serialVersionUID = -718889282905759003L;
	
	@Id private long guid;
	@Column(name="user_name") private String userName;
	@Column(name="email_address") private String emailAddress;
	private String password;
	@Version private int version;

	public UserProfile() {}
}