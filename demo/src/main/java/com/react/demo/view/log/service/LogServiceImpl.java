package com.react.demo.view.log.service;

import com.react.demo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: mayanze
 * @Date: 2018/9/14 23:39
 * @Description:
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogRepository repository;

    @Override
    public LogEntity save(LogEntity var1) {
        return repository.save(var1);
    }

    @Override
    public Page<LogEntity> findAll(LogEntity logEntity, Pageable pageable) {
        Page<LogEntity> bookPage = this.repository.findAll((Specification<LogEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<Predicate>();

            if (!StringUtils.isEmpty(logEntity.getRemark())) {
                list.add(criteriaBuilder.like(root.get("remark").as(String.class), "%" + logEntity.getRemark() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        }, pageable);
        return bookPage;
    }

    @Override
    public List<LogEntity> findDateAndMoney(String month) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;
        try {
            beginDate = dateFormat.parse(month + "-01");
            endDate = DateUtil.subMonth(month + "-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return repository.findDateAndMoney(beginDate,endDate);
    }

    @Override
    public Optional<LogEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long... id) {
        List<LogEntity> logEntities = new LinkedList<>();
        for (int i = 0; i < id.length; i++) {
            LogEntity logEntity = new LogEntity();
            logEntity.setId(id[i]);
            logEntities.add(logEntity);
        }
        repository.deleteInBatch(logEntities);
    }
}
