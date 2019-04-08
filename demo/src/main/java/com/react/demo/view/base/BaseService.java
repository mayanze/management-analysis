package com.react.demo.view.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BaseService<T> {
    T save(T var1);
    Page<T> findAll(T logEntity, Pageable pageable);
    Optional<T> findById(Long id);
}
