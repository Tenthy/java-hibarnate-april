package ru.kmetha.gbhibernate.dao.product;

import ru.kmetha.gbhibernate.entity.Manufacturer;
import ru.kmetha.gbhibernate.entity.Product;

public interface ProductDao {

    Iterable<Product> findAll();
    public String findNameById(Long id);
    Manufacturer findById(Long id);
    void insert(Manufacturer manufacturer);
    void update(Manufacturer manufacturer);
    void deleteById(Long id);
}
