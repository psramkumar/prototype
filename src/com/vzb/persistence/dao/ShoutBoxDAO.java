package com.vzb.persistence.dao;

import javax.inject.Named;

import com.vzb.persistence.entity.Shoutbox;

@Named
public class ShoutBoxDAO extends JPABaseDao<Shoutbox, Long>{
	
	public ShoutBoxDAO(){
		setEjbQL("select Shoutbox from Shoutbox Shoutbox");
		setMaxResult(25);
	}

}
