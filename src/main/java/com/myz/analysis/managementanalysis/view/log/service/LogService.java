package com.myz.analysis.managementanalysis.view.log.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Auther: mayanze
 * @Date: 2018/9/14 23:38
 * @Description:
 */
public interface LogService {
    LogEntity save(LogEntity var1);
    Page<LogEntity> findAll(Pageable pageable);

    List<LogEntity> findDateAndMoney(String month);
}
