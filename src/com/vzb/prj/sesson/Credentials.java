/**
 * 
 */
package com.vzb.prj.sesson;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Ramkumar Pillai
 *
 */
@Named("credentials")
@javax.enterprise.context.SessionScoped
@Data
@EqualsAndHashCode
public class Credentials implements Serializable{
	private static final long serialVersionUID = 1L;
	private static Logger _logger = LoggerFactory.getLogger(Credentials.class);
	
	private String username;
    private String password;
    private boolean loggedIn;
    public boolean getLoggedIn() {return loggedIn;}
    
	public String login() {
		_logger.info("User Credentials : ", this.username);
		try {
			//String uid = getUsername();
			//String pwd = CipherData.encrypt(getPassword());
			if("admin".equals(getUsername()) && "admin".equals(getPassword())){
				setLoggedIn(true);
				_logger.info("Login successfully");
			}else{
				setLoggedIn(false);
				_logger.info("Login UnSuccessfully");
				FacesContext.getCurrentInstance().addMessage("loginErr",new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Password or Username", "Invalid Password or Username"));
			}
		} catch (Exception e) {
			setLoggedIn(false);
			FacesContext.getCurrentInstance().addMessage("loginErr",new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
			_logger.info("Login successfully");
		}
		return "Login";
	}
	
	public String logout() {
		this.loggedIn= false;
		this.password = "";
		this.username = "";
		_logger.info("Logout happend successfully");
		return "Logout";
	}
	
    
}