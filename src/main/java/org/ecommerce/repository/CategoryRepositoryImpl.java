package org.ecommerce.repository;

import org.ecommerce.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by valentinchiriac on 19/07/2017.
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    @Override
    public Category getByName(String name) {
        return null;
    }

    @Override
    public List<Category> findAll() {
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
    public void delete(Category category) {

    }

    @Override
    public void delete(Iterable<? extends Category> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Category> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public List<Category> save(Iterable<? extends Category> iterable) {
        return null;
    }

    @Override
    public Category findOne(Integer integer) {
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
    public Category saveAndFlush(Category category) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Category> iterable) {

    }
}
