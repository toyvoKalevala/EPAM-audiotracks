package com.epam.audiotracks.dao;

import com.epam.audiotracks.connection.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DaoHelperFactory {

    private static final Logger logger = LogManager.getLogger();

    public DaoHelper create() {
        logger.debug("Try to create DaoHelper");
        return new DaoHelper(ConnectionPool.getInstance());
    }
}
