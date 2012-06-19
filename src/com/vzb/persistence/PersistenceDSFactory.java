package com.vzb.persistence;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.vzb.prj.err.ErrorDescriptions;

public class PersistenceDSFactory {
    private static Logger logger = Logger.getLogger(PersistenceDSFactory.class);

    public static PersistenceDSFactory dsFactory;

    protected static DataSource ds;

    private PersistenceDSFactory() {
    }

    public static PersistenceDSFactory getInstance() {
        if (dsFactory == null) {
        	dsFactory = new PersistenceDSFactory();
            setDataSource();
        }
        return dsFactory;
    }

    private static void setDataSource() {
        Context ctx;

        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:MySQLDS");
        } catch (Exception e) {
            logger.error(ErrorDescriptions.DBConnectionFailure);
            dsFactory = null;
            
        }
    }

    public DataSource getDataSource() {
        return ds;
    }
}

