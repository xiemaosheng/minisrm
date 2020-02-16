package com.minisrm.admin.service.impl;

import com.minisrm.admin.mapper.TestMapper;
import com.minisrm.admin.model.Test;
import com.minisrm.admin.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> selectList(Test test, String orderBy) {
        return testMapper.selectList(test, orderBy);
    }

    @Override
    public List<Test> selectAll() {
        return testMapper.selectAll();
    }
}
