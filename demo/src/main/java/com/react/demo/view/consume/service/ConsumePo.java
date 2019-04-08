package com.react.demo.view.consume.service;


import com.react.demo.view.base.BaseEntity;
import com.react.demo.view.dictionary.service.DictionaryPo;
import lombok.Data;

import javax.persistence.*;

/**
 * @auth mayanze
 * @date 2019-02-11
 */
@Data
@Entity
@Table(name = "consume_t")
public class ConsumePo extends BaseEntity {
    private String type;
    private double money;
    private long version;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type",insertable = false,updatable = false,referencedColumnName = "code")
    private DictionaryPo dictionaryPo;
}
