package com.vzb.persistence.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class JPABaseDao<E, ID extends Serializable> {
	protected Class<E> entityClass;

	public static String JNDI_NAME = JPABaseDao.class.getName();

	@PersistenceContext(unitName="MySQLDS")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public JPABaseDao() {
		System.out.println("Initilized");
		Type superType = getClass().getGenericSuperclass();
		if (superType instanceof Class) {
			// this may happen when proxies are being instantiated by container,
			// like in case of ejbs
			superType = ((Class<?>) superType).getGenericSuperclass();
		}
		ParameterizedType genericSuperclass = (ParameterizedType) superType;
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
		initResult();
	}

	public void persist(E entity) {em.persist(entity);}
	public void remove(E entity) {em.remove(entity);}
	
	public E findById(ID id) {return em.find(entityClass, id);}
	public E merge(E entity) {return em.merge(entity);}

	private String ejbQL = "";
	public void setEjbQL(String ejbQL) {this.ejbQL = ejbQL;}
	public String getEjbQL() {return ejbQL;}

	private List<E> resultList;
	public void setResultList(List<E> resultList) {	this.resultList = resultList;}
	public List<E> getResultList() {return resultList;}

	private Integer maxResult = 5;
	public void  setMaxResult(Integer maxResult) {this.maxResult = maxResult;}
	public Integer getMaxResult() {	return maxResult;}

	@SuppressWarnings("unchecked")
	public void initResult() {
		try {
			System.out.println("JPABaseDao.initResult() Initilized");
			javax.persistence.Query q = em.createQuery(ejbQL);
			q.setMaxResults(maxResult);
			setResultList(q.getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
