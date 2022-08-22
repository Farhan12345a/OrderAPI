package com.fshahbaz.orders.data;

import com.fshahbaz.orders.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDaoDB implements OrderDao {

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    public OrderDaoDB(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    @Transactional
    public Order add(Order order) {
        final String INSERT_ORDER = "INSERT INTO order(apples, oranges) VALUES(?,?)";

        jdbc.update(INSERT_ORDER,
                order.getNumberOfApples(),
                order.getNumberOfOranges());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        order.setOrderID(newId);
        return order;
    }

    @Override
    public List<Order> getAll() {
        final String SELECT_ALL_ORDERS = "SELECT * FROM order";
        return jdbc.query(SELECT_ALL_ORDERS, new OrderDaoDB.RoomMapper());
    }

    @Override
    public Order findById(int id) {
        try {
            final String SELECT_ORDER_BY_ID = "SELECT * FROM order WHERE order_id = ?";
            return jdbc.queryForObject(SELECT_ORDER_BY_ID, new OrderDaoDB.RoomMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }


    @Override
    public void deleteOrderById(int id) {
        final String DELETE_MEETING_BY_ROOM = "DELETE FROM order WHERE order_id = ?";
        jdbc.update(DELETE_MEETING_BY_ROOM, id);
    }

    public static final class RoomMapper implements RowMapper<Order> {

        @Override
        public Order mapRow(ResultSet rs, int index) throws SQLException {
            Order order = new Order();
            order.setOrderID(rs.getInt("order_id"));
            order.setNumberOfApples(rs.getInt("apples"));
            order.setNumberOfOranges(rs.getInt("oranges"));
            return order;
        }
    }
}
