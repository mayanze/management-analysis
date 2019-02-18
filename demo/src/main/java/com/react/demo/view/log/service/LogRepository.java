package com.react.demo.view.log.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Auther: mayanze
 * @Date: 2018/9/14 23:35
 * @Description:
 */
@Repository
public interface LogRepository extends JpaRepository<LogEntity,Long>,JpaSpecificationExecutor<LogEntity> {
    @Query("select t.date,\n" +
            "(select SUM(tt.money) from LogEntity tt where tt.id<=t.id ) as money\n" +
            "from LogEntity t where 1=1 and t.date between ?1 and ?2 ORDER BY t.date")
    List<LogEntity> findDateAndMoney(Date beginDate, Date endDate);
}
