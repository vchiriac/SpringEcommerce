package org.ecommerce.repository;

import org.ecommerce.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by valentinchiriac on 19/07/2017.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public List<User> findAll() {
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
    public void delete(User user) {

    }

    @Override
    public void delete(Iterable<? extends User> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<User> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> save(Iterable<? extends User> iterable) {
        return null;
    }

    @Override
    public User findOne(Integer integer) {
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
    public User saveAndFlush(User user) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<User> iterable) {

    }
}
