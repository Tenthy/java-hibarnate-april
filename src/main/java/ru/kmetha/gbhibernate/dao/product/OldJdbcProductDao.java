package ru.kmetha.gbhibernate.dao.product;

import ru.kmetha.gbhibernate.entity.Manufacturer;
import ru.kmetha.gbhibernate.entity.Product;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class OldJdbcProductDao implements ProductDao {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/gb_shop", "postgres", "kmetha");
    }

    private void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @Override
    public Iterable<Product> findAll() {
        Set<Product> products = new HashSet<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from product");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                final Product product = Product.builder()
                        .id(resultSet.getLong("id"))
                        .title(resultSet.getString("title"))
                        .cost(resultSet.getBigDecimal("cost"))
                        .date(resultSet.getDate("date").toLocalDate())
                        .build();
                products.add(product);
            }
            statement.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return products;
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public Manufacturer findById(Long id) {
        return null;
    }

    @Override
    public void insert(Manufacturer manufacturer) {

    }

    @Override
    public void update(Manufacturer manufacturer) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
