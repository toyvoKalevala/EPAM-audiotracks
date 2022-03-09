package com.epam.audiotracks.dao.order;

import com.epam.audiotracks.dao.AbstractDao;
import com.epam.audiotracks.dto.AudioOrderDto;
import com.epam.audiotracks.entity.Order;
import com.epam.audiotracks.exeption.DaoException;
import com.epam.audiotracks.rowmapper.dto.AudioOrderDtoRowMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {

    private static final Logger logger = LogManager.getLogger();

    private static final String CREATE_ORDER = "INSERT Orders (user_id, track_id, is_paid, order_date) " +
            "VALUES(?, ?, ?, ?)";
    private static final String FIND_UNPAID_ORDERS_JOIN_TRACKS_BY_USER_ID = "SELECT tracks.name, price, order_date " +
            "FROM audiotracks.orders " +
            "inner join tracks on track_id=tracks.id where is_paid = 0 and user_id = ?;";
    private static final String FIND_PAID_ORDERS_JOIN_TRACKS_BY_USER_ID = "SELECT tracks.name, price, order_date " +
            "FROM audiotracks.orders " +
            "inner join tracks on track_id=tracks.id where is_paid = 1 and user_id = ?;";
    private static final String UPDATE_ORDER_BY_USER_ID = "UPDATE orders SET is_paid = 1 WHERE user_id = ?";

    public OrderDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return Order.TABLE;
    }

    @Override
    public void save(Order order) throws DaoException {
        executeUpdate(CREATE_ORDER, order.getUserId(), order.getTrackId(), order.isPaid(), order.getDateTime());
    }

    @Override
    public void update(int id) throws DaoException {
        executeUpdate(UPDATE_ORDER_BY_USER_ID, id);
    }

    @Override
    public List<AudioOrderDto> findUnpaidOrdersByUserId(int id) throws DaoException {
        return executeJoinQuery(FIND_UNPAID_ORDERS_JOIN_TRACKS_BY_USER_ID, new AudioOrderDtoRowMapper(), id);
    }

    @Override
    public List<AudioOrderDto> findPaidOrdersByUserId(int id) throws DaoException {
        return executeJoinQuery(FIND_PAID_ORDERS_JOIN_TRACKS_BY_USER_ID, new AudioOrderDtoRowMapper(), id);
    }



}
