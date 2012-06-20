package com.vzb.persistence.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lombok.Getter;
import lombok.Setter;

public abstract class EntityList<E, ID extends Serializable> {

	@Getter @Setter private List<E> resultList;
	@Getter @Setter private int maxResultsetList;
	@Getter @Setter private Class<E> singleResult;
	@Getter @Setter private Long resultCount;
	@Getter @Setter private String ejbql;

	@PersistenceContext
	private EntityManager em;
	
	public void persist(E entity) {em.persist(entity);}
	public void remove(E entity) {em.remove(entity);}
	public E findById(ID id) {return em.find(singleResult, id);}
	public E merge(E entity) {return em.merge(entity);}
	
	@SuppressWarnings("unchecked")
	public EntityList(){
		Type superType = getClass().getGenericSuperclass();
		if (superType instanceof Class) {
			superType = ((Class<?>) superType).getGenericSuperclass();
		}
		ParameterizedType genericSuperclass = (ParameterizedType) superType;
		this.singleResult = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
		initResultSet();
	}
	
	@SuppressWarnings("unchecked")
	private void initResultSet(){
		if(getResultList() !=null){
			Query query = em.createQuery(getEjbql());
			setResultList(query.getResultList());
			System.out.println("EntityList.initResultSet(): ResultSet: "+resultList.size());
		}
	}

}
