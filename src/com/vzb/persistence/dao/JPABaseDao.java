package com.vzb.persistence.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class JPABaseDao<E, ID extends Serializable> {
	protected Class<E> entityClass;

	public static String JNDI_NAME = JPABaseDao.class.getName();

	@PersistenceContext
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public JPABaseDao() {
		Type superType = getClass().getGenericSuperclass();
		if (superType instanceof Class) {
			// this may happen when proxies are being instantiated by container,
			// like in case of ejbs
			superType = ((Class<?>) superType).getGenericSuperclass();
		}
		ParameterizedType genericSuperclass = (ParameterizedType) superType;
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
	}

	public void persist(E entity) {entityManager.persist(entity);}
	public void remove(E entity) {entityManager.remove(entity);}
	
	public E findById(ID id) {return entityManager.find(entityClass, id);}
	public E merge(E entity) {return entityManager.merge(entity);}

	private String ejbQL = "";
	public void setEjbQL(String ejbQL) {this.ejbQL = ejbQL;}
	public String getEjbQL() {return ejbQL;}

	private List<E> resultList;
	public void setResultList(List<E> resultList) {	this.resultList = resultList;}
	public List<E> getResultList() {return resultList;}

	private Integer maxResult;
	public void setMaxResult(Integer maxResult) {this.maxResult = maxResult;}
	public Integer getMaxResult() {	return maxResult;}

	@SuppressWarnings("unchecked")
	public void initResult() throws Exception {
		if(entityManager == null) return;
		Query query = entityManager.createQuery(ejbQL);
		if (maxResult != null) {
			query.setMaxResults(maxResult);
		}
		setResultList(query.getResultList());
		System.out.println("JPABaseDao.initResult()"+query.getResultList().size());
	}
}
