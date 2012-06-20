package com.vzb.prj.sesson;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.jboss.seam.security.BaseAuthenticator;
import org.jboss.seam.security.Credentials;
import org.jboss.solder.logging.Logger;
import org.picketlink.idm.impl.api.PasswordCredential;
import org.picketlink.idm.impl.api.model.SimpleUser;


public class Authenticator extends BaseAuthenticator implements Serializable,
		org.jboss.seam.security.Authenticator {
	private static final long serialVersionUID = 6330848764697614851L;

	private static final Logger log = Logger.getLogger(Authenticator.class);

	@Inject
	Credentials credentials;

	@Override
	public void authenticate() {
		if ("demo".equals(credentials.getUsername()) && credentials.getCredential() instanceof PasswordCredential && "demo".equals(((PasswordCredential) credentials.getCredential()).getValue())) {
			setStatus(AuthenticationStatus.SUCCESS);
			setUser(new SimpleUser("demo"));
			log.info("Authentication successful for user '"	+ credentials.getUsername() + "'");
		} else {
			setStatus(AuthenticationStatus.FAILURE);
			FacesContext.getCurrentInstance().addMessage("loginErr",new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Password or Username", "Invalid Password or Username"));
			log.info("Authentication failed for user '"	+ credentials.getUsername() + "'");
		}
	}

}
