package com.react.demo.view.dictionary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @Auther: mayanze
 * @Date: 2018/9/14 23:39
 * @Description:
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryRepository repository;

    @Override
    public DictionaryPo save(DictionaryPo var1) {
        return repository.save(var1);
    }

    @Override
    public Page<DictionaryPo> findAll(DictionaryPo logEntity, Pageable pageable) {
        Page<DictionaryPo> bookPage = this.repository.findAll((Specification<DictionaryPo>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();

            if (!StringUtils.isEmpty(logEntity.getName())) {
                list.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + logEntity.getName() + "%"));
            }
            if (!StringUtils.isEmpty(logEntity.getPId())) {
                list.add(criteriaBuilder.equal(root.get("pId").as(Integer.class), logEntity.getPId()));
            }
            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        }, pageable);
        return bookPage;
    }


    @Override
    public Optional<DictionaryPo> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long... id) {
        List<DictionaryPo> logEntities = new LinkedList<>();
        for (int i = 0; i < id.length; i++) {
            DictionaryPo logEntity = new DictionaryPo();
            logEntity.setId(id[i]);
            logEntities.add(logEntity);
        }
        repository.deleteInBatch(logEntities);
    }

    @Override
    public List<DictionaryPo> findByParentCode(String parentCode) {
        DictionaryPo byParentCode = repository.findTopByCode(parentCode);
        Long pId = byParentCode.getId();
        List<DictionaryPo> bypId = repository.findBypId(pId);
        return bypId;
    }
}
