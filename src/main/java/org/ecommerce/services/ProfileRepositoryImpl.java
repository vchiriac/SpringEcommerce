package org.ecommerce.services;

import org.ecommerce.model.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by valentinchiriac on 19/07/2017.
 */
@Repository
public class ProfileRepositoryImpl implements ProfileRepository {
    @Override
    public UserProfile findByType(String type) {
        return null;
    }

    @Override
    public List<UserProfile> findAll() {
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
    public void delete(UserProfile userProfile) {

    }

    @Override
    public void delete(Iterable<? extends UserProfile> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<UserProfile> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<UserProfile> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public UserProfile save(UserProfile userProfile) {
        return null;
    }

    @Override
    public List<UserProfile> save(Iterable<? extends UserProfile> iterable) {
        return null;
    }

    @Override
    public UserProfile findOne(Integer integer) {
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
    public UserProfile saveAndFlush(UserProfile userProfile) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<UserProfile> iterable) {

    }
}
