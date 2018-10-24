package com.myz.analysis.managementanalysis.view.log.service;

import com.myz.analysis.managementanalysis.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public Page<LogEntity> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
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
}
