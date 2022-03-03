package com.epam.audiotracks.dao;

import com.epam.audiotracks.rowmapper.RowMapper;
import com.epam.audiotracks.entity.Identifiable;
import com.epam.audiotracks.exeption.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends Identifiable> implements Dao<T> {

    private final Connection connection;

    private static final Logger logger = LogManager.getLogger();

    protected AbstractDao(Connection connection) {
        this.connection = connection;
    }

    protected List<T> executeQuery(String query, RowMapper<T> rowMapper, Object... params) throws DaoException {
        logger.info("Prepare is: " + query + "params is: " + Arrays.toString(params));
        try (PreparedStatement statement = createStatement(query, params)) {
            ResultSet resultSet = statement.executeQuery();
            logger.info(resultSet);
            List<T> entities = new ArrayList<>();
            while (resultSet.next()) {
                T entity = rowMapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private PreparedStatement createStatement(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        logger.info(params.length + " " + Arrays.toString(params));
        logger.info(statement.toString());
        for (int i = 1; i <= params.length; i++) {
            statement.setObject(i, params[i - 1]);
        }
        return statement;
    }

    protected Optional<T> executeForSingleResult(String query, RowMapper<T> mapper, Object... params) throws DaoException {
        logger.info("Prepare is: " + query + "params is: " + Arrays.toString(params));
        List<T> items = executeQuery(query, mapper, params);
        if (items.size() == 1) {
            return Optional.of(items.get(0));
        } else if (items.size() > 1) {
            throw new IllegalArgumentException("More than one record found");
        } else {
            return Optional.empty();
        }
    }

    public List<T> findAll() throws DaoException {
        String table = getTableName();
        RowMapper<T> mapper = (RowMapper<T>) RowMapper.create(table);
        return executeQuery("SELECT * FROM " + table, mapper);
    }

    public abstract String getTableName();
}
