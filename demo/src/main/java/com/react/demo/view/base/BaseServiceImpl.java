package com.react.demo.view.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Auther: mayanze
 * @Date: 2018/9/14 23:39
 * @Description:
 */
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    public abstract BaseRepository<T> repository();

    @Override
    public T save(T var1) {
        return (T) repository().save(var1);
    }

    @Override
    public Page<T> findAll(T logEntity, Pageable pageable) {
        Page<T> bookPage = repository().findAll((Specification<T>) (root, criteriaQuery, criteriaBuilder) -> {
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
    public Optional<T> findById(Long id) {
        return repository().findById(id);
    }
}
