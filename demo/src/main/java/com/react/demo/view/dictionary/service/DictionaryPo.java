package com.react.demo.view.dictionary.service;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "dictionary_t")
public class DictionaryPo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long pId;
  private String type;
  private String creator;
  private Date createTime;
  private Date remarks;
}
