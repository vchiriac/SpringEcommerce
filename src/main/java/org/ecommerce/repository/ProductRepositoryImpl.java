package org.ecommerce.repository;

import org.ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by valentinchiriac on 19/07/2017.
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public Product findBySku(String sku) {
        return null;
    }

    @Override
    public List<Product> search(String query) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void delete(Iterable<? extends Product> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Product> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public List<Product> save(Iterable<? extends Product> iterable) {
        return null;
    }

    @Override
    public Product findOne(Integer integer) {
        return null;
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public Product saveAndFlush(Product product) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Product> iterable) {

    }
}
