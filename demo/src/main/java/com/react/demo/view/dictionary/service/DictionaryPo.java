package com.react.demo.view.dictionary.service;

import com.react.demo.view.base.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "dictionary_t")
public class DictionaryPo extends BaseEntity {
  @Column(name = "pid")
  private long pId;
  private String name;
}
