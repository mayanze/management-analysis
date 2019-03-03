package com.react.demo.view.dictionary.service;

import org.springframework.data.domain.Example;
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
public interface DictionaryRepository extends JpaRepository<DictionaryPo,Long>,JpaSpecificationExecutor<DictionaryPo> {
    @Query(nativeQuery = true,value = "select *,(select name from dictionary_t t1 where t1.id=t.pId) parentName from dictionary_t t")
    @Override
    <S extends DictionaryPo> List<S> findAll(Example<S> example);
}
