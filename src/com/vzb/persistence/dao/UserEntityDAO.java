package com.vzb.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Getter;
import lombok.Setter;

import com.vzb.persistence.entity.UserProfile;

@Named
@ConversationScoped
@Stateful
public class UserEntityDAO implements Serializable {

	private static final long serialVersionUID = -5092819821882631615L;

	@PersistenceContext(unitName="MySQLDS")
	private EntityManager em;

	public UserEntityDAO() {
		setEjbql("select userProfile from UserProfile userProfile");
	}

	@Getter	@Setter	private String ejbql;
	@Getter	@Setter	private UserProfile userProfile = new UserProfile();
	@Getter	@Setter	private UserProfile addUserProfile = new UserProfile();

	@SuppressWarnings("unchecked")
	public List<UserProfile> getResultList() {
		return em.createQuery(getEjbql()).getResultList();
	}

	/** �First add the code to UserController to add a record */
	public void addUser() {
		try {
			System.out.println(addUserProfile);
			em.persist(addUserProfile);
			setMessage(FacesMessage.SEVERITY_INFO, "User Profile Added Successfully !");
			cleanUser();
		} catch (Exception e) {
			setMessage(FacesMessage.SEVERITY_ERROR, "User Profile Add Failed :( ", e.getMessage());
		} finally {
			
		}
	}

	/** �Next add the code to UserController to remove a record */
	public void removeUser(long id) {
		try {
			UserProfile userx = em.find(UserProfile.class, id);
			em.remove(userx);
			setMessage(FacesMessage.SEVERITY_INFO, "User Profile Deleted Successfully !");
			cleanUser();
		} catch (Exception e) {
			setMessage(FacesMessage.SEVERITY_ERROR,	"User Profile Remove Failed :(", e.getMessage());
		} finally {
			
		}
		
	} 

	/** �Finally add the code to UserController to update a record */
	public void updateUser() {
		try {
			System.out.println(userProfile);
			UserProfile userx = em.find(UserProfile.class, userProfile.getGuid());
			userx.setUserName(userProfile.getUserName());
			userx.setPassword(userProfile.getPassword());
			userx.setEmailAddress(userProfile.getEmailAddress());
			em.flush();
			setMessage(FacesMessage.SEVERITY_INFO, "User Profile Updated Successfully !","");
			cleanUser();
		} catch (Exception e) {
			setMessage(FacesMessage.SEVERITY_ERROR,	"User Profile Updated Failed :( ", e.getMessage());
		} finally {
			
		}
	}
	
	public void cleanUser(){
		userProfile = new UserProfile();
		addUserProfile = new UserProfile();
	}

	private void setMessage(Severity severityInfo, String ...messages) {
		FacesMessage message = new FacesMessage();
		message.setSeverity(severityInfo);
		message.setSummary(messages[0]);
		if(severityInfo==FacesMessage.SEVERITY_ERROR){
			message.setDetail(messages[1]);
		}
		FacesContext.getCurrentInstance().addMessage("messageBox", message);
	}
}
