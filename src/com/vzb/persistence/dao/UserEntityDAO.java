package com.vzb.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Getter;
import lombok.Setter;

import com.vzb.persistence.entity.UserProfile;


@Named
@Stateful
public class UserEntityDAO implements Serializable {

	private static final long serialVersionUID = -5092819821882631615L;

	@PersistenceContext	
	private EntityManager em;
	
	public UserEntityDAO() {
		setEjbql("select userProfile from UserProfile userProfile");
	}
	
	@Getter @Setter private String ejbql;
	@Getter @Setter private UserProfile userProfile = new UserProfile();
	
	@SuppressWarnings("unchecked")
	public List<UserProfile> getResultList(){
		if(em ==null){
			System.out.println("Entety Manager Null");
		}else{
			System.out.println(em.getProperties());
		}
		return em.createQuery("select userProfile from UserProfile userProfile").getResultList();
	}

}
