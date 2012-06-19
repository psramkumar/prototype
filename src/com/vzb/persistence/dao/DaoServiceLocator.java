package com.vzb.persistence.dao;

import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.log4j.Logger;

@Startup
@DependsOn({})
@Singleton
public class DaoServiceLocator {
	
	private static Logger logger = Logger.getLogger(DaoServiceLocator.class);
	
	//public static SborsPricingSolutionsRespDao sborsPricingSolutionsRespDao;
	//public static SalesOrderPacketDao salesOrderPacketDao;
	//public static SborsLineItemDao sborsLineItemDao;
	
	/*@Inject
	private void setSborsPricingSolutionsRespDao(SborsPricingSolutionsRespDao sborsPricingSolutionsRespDao) {
		String s = null;
		SborsServiceLocator.sborsPricingSolutionsRespDao = sborsPricingSolutionsRespDao;
	}*/
		
	/*@Inject
	private void setSalesOrderPacketDao(SalesOrderPacketDao salesOrderPacketDao) {
		String s = null;
		SborsServiceLocator.salesOrderPacketDao = salesOrderPacketDao;
	}
	
	@Inject
	private void setSborsLineItemDao(SborsLineItemDao sborsLineItemDao) {
		String s = null;
		SborsServiceLocator.sborsLineItemDao = sborsLineItemDao;
	}*/
	
	
	
//	public static <T extends SborsJpaBaseDao> T getSborsJpaDao(Class<T> serviceClass) {
//		String jndiName = getJndiName(serviceClass);
//		//T result = (T) lookup(jndiName);
//		return null;
//	}
//	
//	private static <T extends SborsJpaBaseDao> String getJndiName(Class<T> serviceClass) {
//		String jndiName = null;
//		try {
//			Field f = serviceClass.getDeclaredField("JNDI_NAME");
//		} catch (Exception e) {
//			logger.error("Cant find property JNDI_NAME on class "+serviceClass, e);
//		}
//		return jndiName;
//	}
//	
//	private static Object lookup(String jndiName) {
//		return null;
//	}
}
