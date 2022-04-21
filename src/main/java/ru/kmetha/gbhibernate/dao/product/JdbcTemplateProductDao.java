package ru.kmetha.gbhibernate.dao.product;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.kmetha.gbhibernate.entity.Manufacturer;
import ru.kmetha.gbhibernate.entity.Product;

//@Component
@RequiredArgsConstructor
public class JdbcTemplateProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Product> findAll() {
        return null;
    }

    @Override
    public String findNameById(Long id) {
        return jdbcTemplate.queryForObject("SELECT name FROM product where id = ?", String.class, id);
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
