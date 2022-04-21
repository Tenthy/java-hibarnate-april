package ru.kmetha.gbhibernate.dao.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kmetha.gbhibernate.entity.Manufacturer;
import ru.kmetha.gbhibernate.entity.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

//@Component
@RequiredArgsConstructor
public class SpringJdbcProductDao implements ProductDao {

    private final DataSource dataSource;

    @Override
    public Iterable<Product> findAll() {
        Set<Product> products = new HashSet<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
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
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
