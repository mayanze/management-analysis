package com.react.demo.view.consume.service;

import com.react.demo.view.base.BaseRepository;
import com.react.demo.view.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: mayanze
 * @Date: 2018/10/10 18:33
 * @Description:
 */
@Service
public class ConsumeServiceImpl extends BaseServiceImpl<ConsumePo> implements ConsumeService {
    @Autowired
    private ConsumeRepository repository;

    @Override
    public BaseRepository<ConsumePo> repository() {
        return repository;
    }
}
