package com.react.demo.view.log.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: mayanze
 * @Date: 2018/9/14 23:38
 * @Description:
 */
public interface LogService {
    LogEntity save(LogEntity var1);
    Page<LogEntity> findAll(LogEntity logEntity, Pageable pageable);

    List<LogEntity> findDateAndMoney(String month);

    Optional<LogEntity> findById(Long id);

    void deleteById(Long... id);
}
