package com.react.demo.view.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Auther: mayanze
 * @Date: 2018/9/14 23:35
 * @Description:
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T,Long>,JpaSpecificationExecutor<T> {

}
