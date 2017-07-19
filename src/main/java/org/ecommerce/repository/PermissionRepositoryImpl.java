package org.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.security.Permission;
import java.util.List;

/**
 * Created by valentinchiriac on 19/07/2017.
 */
@Repository
public class PermissionRepositoryImpl implements PermissionRepository {
    @Override
    public List<Permission> findAll() {
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
    public void delete(Permission permission) {

    }

    @Override
    public void delete(Iterable<? extends Permission> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Permission> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Permission> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Permission save(Permission permission) {
        return null;
    }

    @Override
    public List<Permission> save(Iterable<? extends Permission> iterable) {
        return null;
    }

    @Override
    public Permission findOne(Integer integer) {
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
    public Permission saveAndFlush(Permission permission) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Permission> iterable) {

    }
}
