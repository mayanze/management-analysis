package com.react.demo.view.dictionary.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: mayanze
 * @Date: 2018/9/14 23:38
 * @Description:
 */
public interface DictionaryService {
    DictionaryPo save(DictionaryPo var1);
    Page<DictionaryPo> findAll(DictionaryPo logEntity, Pageable pageable);

    Optional<DictionaryPo> findById(Long id);

    void deleteById(Long... id);

    List<DictionaryPo> findByParentCode(String parentCode);
}
